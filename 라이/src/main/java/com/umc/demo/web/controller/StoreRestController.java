package com.umc.demo.web.controller;

import com.umc.demo.apiPayload.ApiResponse;
import com.umc.demo.converter.StoreConverter;
import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Review;
import com.umc.demo.service.StoreService.StoreCommandService;
import com.umc.demo.validation.annotation.ExistMember;
import com.umc.demo.validation.annotation.ExistStore;
import com.umc.demo.web.dto.StoreRequestDTO;
import com.umc.demo.web.dto.StoreResponseDTO.CreateReviewResultDTO;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                           @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                           @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
}
