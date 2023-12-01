package umc.study.service.StoreService;

import umc.study.domain.Mission;
import umc.study.domain.review;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    review newReview(StoreRequestDTO.ReviewDto request, Long storeId, Long memberId);
    Mission newMission(StoreRequestDTO.MissionDto request, Long storeId);
}
