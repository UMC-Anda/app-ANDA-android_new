import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentManagementBeforeOperationBinding
import com.anda.ui.main.community.eyeMbti.CommunityEyeMbtiFragment
import com.anda.ui.main.compare.option.CompareOptionSelectSortFragment
import com.anda.ui.write_review.WriteReview1Fragment
import java.util.*

class ManagementBeforeOperationFragment : Fragment() {

    private lateinit var binding: FragmentManagementBeforeOperationBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val items = listOf("5 point", "6 point", "7 point", "8 point", "9 point", "10 point")
    private var isSpinning = false
    private var rotateAnimation: RotateAnimation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementBeforeOperationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        binding.buttonCheckin.setOnClickListener { onCheckInButtonClick() }
        binding.resultTextView.setOnClickListener { onResultTextViewClick() }
        binding.bannerMbti.setOnClickListener { onBannerMbtiClick() }
        binding.bannerReview.setOnClickListener { onBannerReviewClick() }

        // 버튼 초기 상태 설정
        val lastSpinTime = sharedPreferences.getLong(KEY_LAST_SPIN_TIME, 0L)
        val currentTime = System.currentTimeMillis()
        val twentyFourHoursInMillis = 24 * 60 * 60 * 1000
        if (currentTime - lastSpinTime < twentyFourHoursInMillis) {
            disableButton()
        }
    }

    private fun onBannerMbtiClick() {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_container, CommunityEyeMbtiFragment())
            .commitAllowingStateLoss()
    }

    private fun onBannerReviewClick() {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_container, WriteReview1Fragment())
            .commitAllowingStateLoss()
    }

    private fun onCheckInButtonClick() {
        val lastSpinTime = sharedPreferences.getLong(KEY_LAST_SPIN_TIME, 0L)
        val currentTime = System.currentTimeMillis()
        val twentyFourHoursInMillis = 24 * 60 * 60 * 1000

        if (!isSpinning && (currentTime - lastSpinTime >= twentyFourHoursInMillis)) {
            spinRoulette()
            sharedPreferences.edit().putLong(KEY_LAST_SPIN_TIME, currentTime).apply()
            disableButton()
        }
    }

    private fun onResultTextViewClick() {
        binding.resultTextView.visibility = View.GONE
        binding.rouletteImage.visibility = View.GONE
        resetAnimation()
    }

    private fun spinRoulette() {
        val randomIndex = Random().nextInt(items.size)
        val selectedItem = items[randomIndex]

        val fromDegrees = 0f
        val toDegrees = (360 * 5 + (randomIndex * (360 / items.size))).toFloat()
        rotateAnimation = RotateAnimation(
            fromDegrees, toDegrees,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation?.duration = 2000
        rotateAnimation?.fillAfter = true

        binding.rouletteImage.visibility = View.VISIBLE

        rotateAnimation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isSpinning = true
                binding.resultTextView.visibility = View.GONE
            }

            override fun onAnimationEnd(animation: Animation?) {
                isSpinning = false
                binding.resultTextView.visibility = View.VISIBLE
                binding.resultTextView.text = selectedItem
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.rouletteImage.startAnimation(rotateAnimation)
    }

    private fun resetAnimation() {
        rotateAnimation?.cancel()
        rotateAnimation = null
        binding.rouletteImage.clearAnimation()
    }

    private fun disableButton() {
        binding.buttonCheckin.isEnabled = false
        binding.buttonCheckin.setBackgroundColor(resources.getColor(R.color.gray)) // 버튼의 색상을 원하는 색상으로 설정해주세요.
    }

    private fun enableButton() {
        binding.buttonCheckin.isEnabled = true
        binding.buttonCheckin.setBackgroundColor(resources.getColor(R.color.Main)) // 버튼의 색상을 원하는 색상으로 설정해주세요.
    }

    companion object {
        private const val KEY_LAST_SPIN_TIME = "last_spin_time"
    }
}
