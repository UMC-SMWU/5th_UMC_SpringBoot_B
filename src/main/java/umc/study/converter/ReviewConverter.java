package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewDTO;

@Component
public class ReviewConverter {

    public Review convertToEntity(ReviewDTO reviewDto) {
        return Review.builder()
                .title(reviewDto.getTitle())
                .score(reviewDto.getScore())
                .build();
    }

    public ReviewDTO convertToDto(Review review) {
        ReviewDTO reviewDto = new ReviewDTO();
        reviewDto.updateTitle(review.getTitle());
        reviewDto.updateScore(review.getScore());
        return reviewDto;
    }
}
