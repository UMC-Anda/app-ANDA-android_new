package com.anda.ui.main.compare

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.*
import com.anda.databinding.ItemCompareOphthaBinding
import com.anda.ui.main.home.ranking.HomeAndaRankingRVAdapter
import com.anda.ui.main.management.after.challenge.ManagementChallengeRVAdapter
import com.anda.ui.ophtha_info.OphthaInfoDetailReviewFragment
import com.anda.ui.ophtha_info.OphthaInfoReviewsRVAdapter


class CompareOphthaRVAdapter (private var compareOphthaList: ArrayList<CompareOphtha>, private val context: Context): RecyclerView.Adapter<CompareOphthaRVAdapter.ViewHolder>() {

    private var compareOphthaReviewDatas = ArrayList<ExOphthaInfoReview>()
    private lateinit var ophthaSharedPreferences: SharedPreferences
    private lateinit var reviewSharedPreferences: SharedPreferences
    var kindnessAvg : Float = 0f
    var effectiveAvg : Float = 0f
    var WaitingAvg : Float = 0f
    var informationAvg : Float = 0f
    var priceAvg : Float = 0f

    interface ItemClickListener{ fun onItemClick(compareOphtha: CompareOphtha){        } }

    private lateinit var mItemClickListener : ItemClickListener
    fun setItemClickListener(itemClickListener : ItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int, ): CompareOphthaRVAdapter.ViewHolder {
        val binding: ItemCompareOphthaBinding = ItemCompareOphthaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }





    override fun onBindViewHolder(holder: CompareOphthaRVAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick(compareOphthaList[position])}
        holder.bind(compareOphthaList[position], context)

        // 아이템 위치 값 로그 출력
        Log.d("CompareOphthaRVAdapter1", "Item position: $position")
    }

    override fun getItemCount(): Int = compareOphthaList.size

    inner class ViewHolder(val binding: ItemCompareOphthaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(compareOphtha: CompareOphtha, context: Context) {
            var totalAvg = compareOphtha.ratingAvg * 10f
            totalAvg = (totalAvg.toInt()) / 10f
            binding.itemCompareOphthaNameTv.text = compareOphtha.name
            binding.itemCompareOphthaLocationTv.text = compareOphtha.location
            binding.itemCompareOphthaTotalRatingTv.text = totalAvg.toString()
            binding.itemCompareOphthaReviewCntTv.text = compareOphtha.reviewCnt.toString()
            binding.itemCompareOphthaPictureCiv.setImageResource(compareOphtha.picture!!)
            binding.itemCompareOphthaReviewCntTv.text = " (${compareOphtha.reviewCnt}개의 리뷰)"

            // 리뷰 데이터 가져오기
            val compareOphthaReviewDatas = addDetailsReviews(compareOphtha.id!!, context)

            // 리사이클러뷰 설정
            settingOphthaReviews(binding, compareOphthaReviewDatas)
        }

        private fun addDetailsReviews(ophthaId: Int, context: Context): ArrayList<ExOphthaInfoReview> {
            val compareOphthaReviewDatas = ArrayList<ExOphthaInfoReview>()
            Log.d("ophthaId", ophthaId.toString())

            val ophthaSharedPreferences = context.getSharedPreferences("Ophtha$ophthaId", Context.MODE_PRIVATE)
            val reviewCnt = ophthaSharedPreferences.getInt("reviwCnt", 6)
            Log.d("reviewCnt", reviewCnt.toString())
            var kindnessAvg = 0f
            var effectiveAvg = 0f
            var waitingAvg = 0f
            var informationAvg = 0f
            var priceAvg = 0f

            for (i in 1..reviewCnt) {
                val reviewSharedPreferences = context.getSharedPreferences("Ophtha$ophthaId" + "_review$i", Context.MODE_PRIVATE)
                kindnessAvg += reviewSharedPreferences.getInt("ratingKindness", 0)
                effectiveAvg += reviewSharedPreferences.getInt("ratingEffect", 0)
                waitingAvg += reviewSharedPreferences.getInt("ratingWaitingTime", 0)
                informationAvg += reviewSharedPreferences.getInt("ratingInformation", 0)
                priceAvg += reviewSharedPreferences.getInt("ratingPrice", 0)

                val exOphthaInfoReview = ExOphthaInfoReview(
                    ophthaSharedPreferences.getString("operation", "라식"),
                    reviewSharedPreferences.getInt("price", 0),
                    "",
                    reviewSharedPreferences.getInt("totalRating", 0).toFloat(),
                    false,
                    reviewSharedPreferences.getString("review", "완전 좋았습니다!"),
                    reviewSharedPreferences.getInt("ratingKindness", 0).toInt(),
                    reviewSharedPreferences.getInt("ratingWaitingTime", 0).toInt(),
                    reviewSharedPreferences.getInt("ratingEffect", 0).toInt(),
                    reviewSharedPreferences.getInt("ratingInformation", 0).toInt(),
                    reviewSharedPreferences.getInt("ratingPrice", 0).toInt(),
                    reviewSharedPreferences.getString("nickName", "")
                )

                compareOphthaReviewDatas.add(exOphthaInfoReview)
            }

            kindnessAvg /= reviewCnt
            effectiveAvg /= reviewCnt
            waitingAvg /= reviewCnt
            informationAvg /= reviewCnt
            priceAvg /= reviewCnt

            return compareOphthaReviewDatas
        }

        private fun settingOphthaReviews(binding: ItemCompareOphthaBinding, compareOphthaReviewDatas: ArrayList<ExOphthaInfoReview>) {
            val compareOphthaReviewRVAdapter = CompareOphthaReviewRVAdapter(compareOphthaReviewDatas)
            binding.itemCompareOphthaReviewsRv.adapter = compareOphthaReviewRVAdapter
            binding.itemCompareOphthaReviewsRv.layoutManager = LinearLayoutManager(binding.itemCompareOphthaReviewsRv.context, LinearLayoutManager.HORIZONTAL, false)
            val snap = PagerSnapHelper()
            snap.attachToRecyclerView(binding.itemCompareOphthaReviewsRv)
            binding.itemCompareOphthaReviewsRv.smoothScrollToPosition(0)

            compareOphthaReviewRVAdapter.setItemClickListener(object :
                CompareOphthaReviewRVAdapter.ItemClickListener {
                override fun onItemClick(ophthaInfoReview: ExOphthaInfoReview) {
                    (context as MainActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_container, OphthaInfoDetailReviewFragment(ophthaInfoReview))
                        .commitAllowingStateLoss()
                }
            })
        }
    }
}

//compareOphthaReviewDatas.apply {
//    add(
//        CompareOphthaReview(
//            R.color.Main,
//            "냥냥펀치",
//            3,
//            221.128,
//            4,
//            1,
//            0,
//            1,
//            1,
//            1,
//            0,
//            true,
//            "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요."
//        )
//    )
//    add(
//        CompareOphthaReview(
//            R.color.Main,
//            "냥냥펀치",
//            2,
//            2211.28,
//            4,
//            1,
//            0,
//            1,
//            1,
//            1,
//            0,
//            false,
//            "원장님 꼼꼼하게 설명해주시고,\n 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
//        )
//    )
//    add(
//        CompareOphthaReview(
//            R.color.Main,
//            "냥냥펀치",
//            1,
//            2211.28,
//            2,
//            1,
//            0,
//            1,
//            1,
//            1,
//            0,
//            false,
//            "어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요.\n지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
//        )
//    )
//    add(
//        CompareOphthaReview(
//            R.color.Main,
//            "냥냥펀치",
//            5,
//            221.128,
//            1,
//            1,
//            0,
//            1,
//            1,
//            1,
//            0,
//            true,
//            "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
//        )
//    )
//    add(
//        CompareOphthaReview(
//            R.color.Main,
//            "냥냥펀치",
//            8,
//            22.1128,
//            5,
//            1,
//            0,
//            1,
//            1,
//            1,
//            0,
//            false,
//            "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
//        )
//    )
//}
