package com.anda.ui.main.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.ExCommunityAskDoctor
import com.anda.data.entities.ExCommunityCommunity
import com.anda.databinding.FragmentCommunityWritingListBinding
import com.anda.ui.main.community.askDoctor.CommunityAskDoctorRVAdapter
import com.anda.ui.main.community.community.CommunityCommunityRVAdapter

class CommunityWritingListFragment(var theme : String?, var subject : String?) : Fragment(), OnClickListener {
    private var CommunityCommunityDatas = ArrayList<ExCommunityCommunity>()
    private var CommunityAskDoctorDatas = ArrayList<ExCommunityAskDoctor>()

    lateinit var binding: FragmentCommunityWritingListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityWritingListBinding.inflate(inflater, container, false)

        binding.communityWritingListBackIconIv.setOnClickListener(this)

        if (subject == "부작용 관리" || subject == "일반 진료") {
            binding.communityWritingListTitleTv.text = subject + "를 안다!"
        } else if(subject == "좋아요" || subject == "스크랩" || subject == "질문"){
            binding.communityWritingListTitleTv.text = "My " + subject
        } else {
            binding.communityWritingListTitleTv.text = subject + "을 안다!"
        }
        if(theme == "커뮤니티") {
            setCommunityWirings()
        }
        else if(theme == "의사질문") {
            setDoctorWritings()
        }
        return binding.root
    }

    private fun setDoctorWritings() {
        CommunityAskDoctorDatas.apply {
            add(
                ExCommunityAskDoctor(
                    "제목1",
                    "안녕하세요. 반가워요",
                    false
                )
            )
            add(
                ExCommunityAskDoctor(
                    "제목2",
                    "어느새 길어진 그림자를 따라서 땅거미 진 어둠 속을 그대와 걷고 있네요 손을 마주 잡고 그 언제까지라도 함께 있는 것 만으로 눈물이 나는 걸요",
                    false,
                )
            )
            add(
                ExCommunityAskDoctor(
                    "제목3",
                    "바람이 차가워지는 만큼 겨울은 가까워 오네요 조금씩 이 거리 그 위로 그대를 보내야 했던 계절이 오네요",
                    false,
                )
            )
            add(
                ExCommunityAskDoctor(
                    "제목4",
                    "반가워요",
                    true
                )
            )
            add(
                ExCommunityAskDoctor
                    (
                    "제목5",
                    "지금 올해의 첫 눈꽃을 바라보며 함께 있는 이 순간에 내 모든 걸 당신께 주고 싶어 이런 가슴에 그댈 안아요? 약하기만 한 내가 아니에요 이렇게 그댈 사랑하는데 그저 내 맘이 이럴 뿐인 거죠",
                    false,
                )
            )
            add(
                ExCommunityAskDoctor(
                    "제목6",
                    "안녕하세요",
                    true
                )
            )
            add(
                ExCommunityAskDoctor(
                    "제목7",
                    "안녕하세요",
                    true
                )
            )
            add(
                ExCommunityAskDoctor(
                    "제목8",
                    "안녕하세요",
                    true
                )
            )
            add(
                ExCommunityAskDoctor(
                    "제목9",
                    "안녕하세요",
                    true
                )
            )
        }
        val communityAskDoctorRVAdapter = CommunityAskDoctorRVAdapter(CommunityAskDoctorDatas)
        binding.communityWritingListRv.adapter = communityAskDoctorRVAdapter
        binding.communityWritingListRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        communityAskDoctorRVAdapter.setCommunityAskDoctorItemClickListener(object :
            CommunityAskDoctorRVAdapter.CommunityAskDoctorItemClickListener {
            override fun onItemClick() {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.nav_host_fragment_container,
                        CommunityWritingDetailFragment(theme, subject)
                    )
                    .commitAllowingStateLoss()
            }
        })
    }

    private fun setCommunityWirings() {
        CommunityCommunityDatas.apply {
            add(
                ExCommunityCommunity
                    (
                    "제목1",
                    "안녕하세요. 반가워요",
                    5,
                )
            )
            add(
                ExCommunityCommunity(
                    "제목2",
                    "어느새 길어진 그림자를 따라서 땅거미 진 어둠 속을 그대와 걷고 있네요 손을 마주 잡고 그 언제까지라도 함께 있는 것 만으로 눈물이 나는 걸요",
                    5,
                )
            )
            add(
                ExCommunityCommunity
                    (
                    "제목3",
                    "바람이 차가워지는 만큼 겨울은 가까워 오네요 조금씩 이 거리 그 위로 그대를 보내야 했던 계절이 오네요",
                    18,
                )
            )
            add(
                ExCommunityCommunity
                    (
                    "제목4",
                    "반가워요",
                    30,
                )
            )
            add(
                ExCommunityCommunity
                    (
                    "제목5",
                    "지금 올해의 첫 눈꽃을 바라보며 함께 있는 이 순간에 내 모든 걸 당신께 주고 싶어 이런 가슴에 그댈 안아요? 약하기만 한 내가 아니에요 이렇게 그댈 사랑하는데 그저 내 맘이 이럴 뿐인 거죠",
                    27,
                )
            )
            add(
                ExCommunityCommunity
                    (
                    "제목6",
                    "안녕하세요",
                    192,
                )
            )
        }
        val communityCommunityRVAdapter = CommunityCommunityRVAdapter(CommunityCommunityDatas)
        binding.communityWritingListRv.adapter = communityCommunityRVAdapter
        binding.communityWritingListRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        communityCommunityRVAdapter.setCommunityCommunityItemClickListener(object :
            CommunityCommunityRVAdapter.CommunityCommunityItemClickListener {
            override fun onItemClick() {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.nav_host_fragment_container,
                        CommunityWritingDetailFragment(theme, subject)
                    )
                    .commitAllowingStateLoss()
            }
        })
    }

    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.communityWritingListBackIconIv ->{
                var subject:String? = "부작용 관리"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityFragment())
                    .commitAllowingStateLoss()
            }

        }
    }
}