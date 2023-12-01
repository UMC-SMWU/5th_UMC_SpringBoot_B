package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.StoreMissionConverter;
import umc.study.converter.StoreReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.member;
import umc.study.domain.review;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@Valid
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.newReviewResultDto> newReview(@RequestBody @Valid StoreRequestDTO.ReviewDto request,
                                                                      @PathVariable(name = "storeId") Long storeId,
                                                                      @RequestParam(name = "memberId") Long memberId){
        review review = storeCommandService.newReview(request, storeId, memberId);
        return ApiResponse.onSuccess(StoreReviewConverter.toNewReviewResultDto(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<StoreResponseDTO.newMissionResultDto> newMission(@RequestBody @Valid StoreRequestDTO.MissionDto request,
                                                                      @PathVariable(name = "storeId") Long storeId){
        Mission mission = storeCommandService.newMission(request, storeId);
        return ApiResponse.onSuccess(StoreMissionConverter.toNewMissionResultDto(mission));
    }
}
