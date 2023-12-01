package umc.study.converter;

import umc.study.domain.review;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreReviewConverter {
    public static review toReview(StoreRequestDTO.ReviewDto request){
        return review.builder()
                .point(request.getPoint())
                .photo(request.getPhoto())
                .text(request.getText())
                .build();
    }

    public static StoreResponseDTO.newReviewResultDto toNewReviewResultDto(review review){
        return StoreResponseDTO.newReviewResultDto.builder()
                .reviewId(review.getReviewId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
