package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreMissionConverter;
import umc.study.converter.StoreReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.review;
import umc.study.domain.store;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public review newReview(StoreRequestDTO.ReviewDto request, Long storeId, Long memberId){
        review review = StoreReviewConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore((store) storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }

    @Override
    public Mission newMission(StoreRequestDTO.MissionDto request, Long storeId){
        Mission mission = StoreMissionConverter.toMission(request);

        mission.setStore((store) storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }
}
