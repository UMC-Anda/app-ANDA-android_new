package com.anda.ui.main.community

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.*
import com.anda.databinding.FragmentCommunityWritingDetailBinding

class CommunityWritingDetailFragment(var theme : String?, var subject : String?) : Fragment(), OnClickListener {
    private var communityWritingCommentDatas = ArrayList<ExCommunityWrtingComment>()
    private var communityCommentDatas = ArrayList<Comments>()
    private var askDoctorDetailCommentDatas = ArrayList<ExAskDoctorDetailComment>()
    private var communityDetailCommentDatas = ArrayList<ExCommunityDetailComment>()

    lateinit var binding: FragmentCommunityWritingDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityWritingDetailBinding.inflate(inflater, container, false)

        binding.communityWritingDetailBackIconIv.setOnClickListener(this)

        if (subject == "부작용 관리" || subject == "일반 진료") {
            binding.communityWritingDetailTitleTv.text = subject + "를 안다!"
        } else {
            binding.communityWritingDetailTitleTv.text = subject + "을 안다!"
        }

        if(theme == "커뮤니티"){
            setCommunityDetailComments()
            Log.d("댓글", "커뮤")
        }
        else if(theme == "의사질문"){
            setDoctorDetailComments()
            Log.d("댓글", "의사")
        }

        return binding.root
    }

    private fun setDoctorDetailComments() {
        askDoctorDetailCommentDatas.apply {
            add(
                ExAskDoctorDetailComment(
                    R.drawable.ex_img,
                    "이름1",
                    3,
                    "exEmail_01@naver.com",
                    "동해불과 백두산이 마르고 닳도록, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.real_ophtha_ex_img,
                    "이름2",
                    6,
                    "exEmail_02@naver.com",
                    "하나님이 보우하사 우리 나라 만세, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.ophtha_ex_img,
                    "이름3",
                    12,
                    "exEmail_03@naver.com",
                    "무궁화 삼천리 화려 강산~~~, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.real_ophtha_ex_img,
                    "이름4",
                    5,
                    "exEmail_04@naver.com",
                    "대~하ㄴ사람 대한으로 길이길이, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.ex_img,
                    "이름5",
                    67,
                    "exEmail_05@naver.com",
                    "보전어엉어어엉어어어어어언 해버리자 ㅜ와아, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    true
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.ophtha_ex_img,
                    "이름6",
                    1,
                    "exEmail_06@naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.ophtha_ex_img,
                    "이름6",
                    1,
                    "exEmail_07@naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.ex_img,
                    "이름6",
                    1,
                    "exEmail_08naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExAskDoctorDetailComment(
                    R.drawable.real_ophtha_ex_img,
                    "이름6",
                    1,
                    "exEmail_09@naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
        }
        val communityDoctorWritingDetailCommentRVAdapter =
            CommunityDoctorWritingDetailCommentRVAdapter(askDoctorDetailCommentDatas)
        binding.communityWritingDetailContentsCommentsRv.adapter =
            communityDoctorWritingDetailCommentRVAdapter
        binding.communityWritingDetailContentsCommentsRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setCommunityDetailComments() {
        communityDetailCommentDatas.apply {
            add(
                ExCommunityDetailComment(
                    R.drawable.ex_img,
                    "이름1",
                    3,
                    "exEmail_01@naver.com",
                    "동해불과 백두산이 마르고 닳도록, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.real_ophtha_ex_img,
                    "이름2",
                    6,
                    "exEmail_02@naver.com",
                    "하나님이 보우하사 우리 나라 만세, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.ophtha_ex_img,
                    "이름3",
                    12,
                    "exEmail_03@naver.com",
                    "무궁화 삼천리 화려 강산~~~, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.real_ophtha_ex_img,
                    "이름4",
                    5,
                    "exEmail_04@naver.com",
                    "대~하ㄴ사람 대한으로 길이길이, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.ex_img,
                    "이름5",
                    67,
                    "exEmail_05@naver.com",
                    "보전어엉어어엉어어어어어언 해버리자 ㅜ와아, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    true
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.ophtha_ex_img,
                    "이름6",
                    1,
                    "exEmail_06@naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.ophtha_ex_img,
                    "이름7",
                    1,
                    "exEmail_06@naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.ophtha_ex_img,
                    "이름8",
                    1,
                    "exEmail_06@naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
            add(
                ExCommunityDetailComment(
                    R.drawable.ex_img,
                    "이름9",
                    1,
                    "exEmail_06@naver.com",
                    "마지막1 막지막2 마지막3 안녕하세요 반가워요, 코딩 빨리 끝내고 앱 출시해버리고 싶다",
                    false
                )
            )
        }
        val communityCommunityWritingDetailCommentRVAdapter =
            CommunityCommunityWritingDetailCommentRVAdapter(communityDetailCommentDatas)
        binding.communityWritingDetailContentsCommentsRv.adapter =
            communityCommunityWritingDetailCommentRVAdapter
        binding.communityWritingDetailContentsCommentsRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.communityWritingDetailBackIconIv ->{
                if(theme == "커뮤니티"){
                    (activity as MainActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                        .commitAllowingStateLoss()
                }else{
                    (activity as MainActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                        .commitAllowingStateLoss()
                }
            }

        }
    }
}