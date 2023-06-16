package com.anda.ui.main.community.eyeMbti

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityEyeMbtiQuestionsBinding
import com.anda.databinding.FragmentCommunityEyeMbtiResultBinding

class CommunityEyeMbtiResultFragment(var operationName : String) : Fragment() {
    lateinit var binding: FragmentCommunityEyeMbtiResultBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityEyeMbtiResultBinding.inflate(inflater, container, false)

        binding.communityEyeMbtiResultOperationNameTv.text = operationName
        binding.communityEyeMbtiResultMyOperationExplanationTitleTv.text = operationName + "이란?"

        when(operationName){
            "라식" -> {
                binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_lasik)
                binding.communityEyeMbtiResultMyOperationExplanationSortTv.text=
                    "아픈 건 싫고 빨리 회복하고 싶은 당신!!"
                binding.communityEyeMbtiResultMyOperationExplanationContentTv.text=
                    "'라식'은 각막에 절편을 만든 후 레이저를 조사하여 실질을 제거하는 수술입니다.\n" +
                            "\n" +
                            "각막 절편을 수술 후 다시 덮기 때문에 상처가 겉으로 드러나지 않고 상처회복이 빠르다는 장점이 있습니다. 하지만 외부충격으로 인해 덮었던 각막 절편이 다시 열릴 수 있습니다.\n" +
                            "\n" +
                            "평소 과격한 움직임이 없거나 운동을 많이 하지 않는다면 라식은 좋은 선택지가 될 수 있을거에요."
            }
            "라섹" -> {
                binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_lasek)
                binding.communityEyeMbtiResultMyOperationExplanationSortTv.text=
                    "아픔을 잘 참고 확실한 회복을 원하는 당신!!"
                binding.communityEyeMbtiResultMyOperationExplanationContentTv.text=
                    "'라섹'은 각막 상피(재생 가능)를 제거한 후 레이저를 조사하여 실질을 제거하는 수술입니다.\n" +
                            "\n" +
                            "각막 상피를 제거한 후 재생을 기다리기 때문에 재생기간 동안 상당한 통증과 이물감이 있지만, 재생 후 외부 충격에 강하다는 장점이 있습니다.\n" +
                            "\n" +
                            "운동 등 과격한 활동을 해야 한다면 라섹은 좋은 선택지가 될 수 있을거에요."
            }
            "스마일 라식" -> {
                binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_smile)
                binding.communityEyeMbtiResultMyOperationExplanationSortTv.text=
                    "요즘 트렌드는 스마일 라식!!"
                binding.communityEyeMbtiResultMyOperationExplanationContentTv.text=
                    "'스마일 라식'은 각막을 투과할 수 있는 '펨토 레이저'를 이용하여 각막 실질 부분만을 절제하여 제거하는 수술입니다.\n" +
                            "\n" +
                            "각막 손상도가 라식, 라섹에 비해 현저히 줄었기 때문에 통증은 줄이고 회복은 빨리진 수술입니다. 라식과 라섹의 장점을 합친 수술로 비교적 최근(2011년 최초 도입)에 나온 트렌디한 수술임에도 적지 않은 데이터가 쌓여 안심하고 받을 수 있는 수술입니다.\n" +
                            "\n" +
                            "평소 안구건조증이 있거나 일상생활로 빠르게 복귀해야 한다면 스마일 라식을 한번 고려해보세요."
            }
            "렌즈 삽입술" -> {
                binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_lens)
                binding.communityEyeMbtiResultMyOperationExplanationSortTv.text=
                    "혹시 모를 상황을 대비하고 싶은 당신!!"
                binding.communityEyeMbtiResultMyOperationExplanationContentTv.text=
                    "'렌즈 삽입술'은 각막을 깍지 않고 눈 안에 렌즈를 삽입하여 시력을 교정하는 수술입니다. 이때, 각막을 전혀 깍지 않기 때문에 레이저 수술에는 없는 여러 장점들이 있습니다.\n" +
                            "\n" +
                            "크게 '전방 렌즈 삽입술', '후방 렌즈 삽입술' 두 가지로 분류됩니다.\n" +
                            "'전방 렌즈 삽입술'은 렌즈를 홍체에 매달아 놓기 때문에 고정력이 좋다는 장점이 있지만 렌즈가 눈에 보이고 내피세포(눈을 투명하게 유지시켜주는 세포)가 손상될 가능성이 존재합니다.\n" +
                            "'후방 렌즈 삽입술'은 렌즈를 홍체 뒤에 수집하는 수술입니다. 이 수술은 의사의 수술적 테크닉이 완벽하다면 내피세포의 손상 가능성이 없고 렌즈도 눈에 보이지 않지만 렌즈가 움직일 수 있다는 단점이 존재합니다.\n" +
                            "\n" +
                            "렌즈가 돌아가는 등 부작용이 발생한다면 재수술이 가능하기 때문에 신중하게 고민하고 싶다면 렌즈 삽일술은 좋은 선택지가 될 거에요. "
            }
        }
        Log.d("mbti결과", operationName)


        return binding.root
    }


}