package com.anda.ui.main.myInfo.myPoint.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.ExMyPointGetHistory
import com.anda.data.entities.ExMyPointGoods
import com.anda.data.entities.ExMyPointUseHistory
import com.anda.databinding.FragmentMyInfoMyPointHistoryBinding
import com.anda.ui.main.myInfo.myPoint.MyInfoMyPointFragment
import com.anda.ui.main.myInfo.myPoint.goods.MyInfoMyPointGoodsDetailFragment
import com.anda.ui.main.myInfo.myPoint.goods.MyInfoMyPointGoodsFragment
import com.anda.ui.main.myInfo.myPoint.goods.MyInfoMyPointGoodsRVAdapter

class MyInfoMyPointHistoryFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentMyInfoMyPointHistoryBinding

    var myInfoMyPointUseHistoryDatas = ArrayList<ExMyPointUseHistory>()
    var myInfoMyPointGetHistoryDatas = ArrayList<ExMyPointGetHistory>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoMyPointHistoryBinding.inflate(inflater, container, false)

        binding.myInfoMyPointHistoryContentsCv.clipToOutline = true

        binding.myInfoMyPointHistoryBackImgIv.setOnClickListener(this)
        binding.myInfoMyPointHistoryCategoryUsePointIv.setOnClickListener(this)
        binding.myInfoMyPointHistoryCategoryGetPointIv.setOnClickListener(this)


        myInfoMyPointGetHistoryDatas.apply {
            add(ExMyPointGetHistory("리뷰", 3000,"2020-09-03","2022-09-03","300"))
            add(ExMyPointGetHistory("커뮤니티", 50,"2020-05-15","2022-05-15","210"))
            add(ExMyPointGetHistory("리뷰", 3000,"2020-04-13","2022-04-13","300"))
            add(ExMyPointGetHistory("커뮤니티", 50,"2020-03-29","2022-03-29","50"))
            add(ExMyPointGetHistory("커뮤니티", 50,"2020-03-07","2022-03-07","75"))
            add(ExMyPointGetHistory("회원가입", 50,"2020-02-17","2022-02-17","27"))
        }
        myInfoMyPointUseHistoryDatas.apply {
            add(ExMyPointUseHistory("의사질문", 100,"2020-09-03"))
            add(ExMyPointUseHistory("의사질문", 100,"2020-09-03"))
            add(ExMyPointUseHistory("기프티콘", 3000,"2020-09-03"))
            add(ExMyPointUseHistory("의사질문", 100,"2020-09-03"))
            add(ExMyPointUseHistory("기프티콘", 3000,"2020-05-15"))
            add(ExMyPointUseHistory("기프티콘", 3000,"2020-04-13"))
            add(ExMyPointUseHistory("의사질문", 100,"2020-03-29"))
            add(ExMyPointUseHistory("기프티콘", 3000,"2020-03-07"))
            add(ExMyPointUseHistory("기프티콘", 3000,"2020-02-17"))
        }

        setGetPointHistory()
        return binding.root
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            binding.myInfoMyPointHistoryBackImgIv ->{
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, MyInfoMyPointFragment())
                    .commitAllowingStateLoss()
            }
            binding.myInfoMyPointHistoryCategoryUsePointIv ->{
                binding.myInfoMyPointHistoryCategoryUsePointIv.setImageResource(R.drawable.my_info_my_point_history_category_background_selected_img)
                binding.myInfoMyPointHistoryCategoryUsePointTv.setTextColor(resources.getColor(R.color.Main))
                binding.myInfoMyPointHistoryCategoryGetPointIv.setImageResource(R.drawable.my_info_my_point_history_category_background_unselected_img)
                binding.myInfoMyPointHistoryCategoryGetPointTv.setTextColor(resources.getColor(R.color.MAIN_50))

                setUsePointHistory()
            }
            binding.myInfoMyPointHistoryCategoryGetPointIv ->{
                binding.myInfoMyPointHistoryCategoryGetPointIv.setImageResource(R.drawable.my_info_my_point_history_category_background_selected_img)
                binding.myInfoMyPointHistoryCategoryGetPointTv.setTextColor(resources.getColor(R.color.Main))
                binding.myInfoMyPointHistoryCategoryUsePointIv.setImageResource(R.drawable.my_info_my_point_history_category_background_unselected_img)
                binding.myInfoMyPointHistoryCategoryUsePointTv.setTextColor(resources.getColor(R.color.MAIN_50))

                setGetPointHistory()
            }
        }
    }

    private fun setGetPointHistory() {
        val myinfoMyPointHistoryGetRVAdapter =
            MyInfoMyPointHistoryGetRVAdapter(myInfoMyPointGetHistoryDatas)
        binding.myInfoMyPointHistoryContentsRv.adapter = myinfoMyPointHistoryGetRVAdapter
        binding.myInfoMyPointHistoryContentsRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUsePointHistory() {
        val myinfoMyPointHistoryUseRVAdapter =
            MyInfoMyPointHistoryUseRVAdapter(myInfoMyPointUseHistoryDatas)
        binding.myInfoMyPointHistoryContentsRv.adapter = myinfoMyPointHistoryUseRVAdapter
        binding.myInfoMyPointHistoryContentsRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}
