package umc.study.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.ReviewDTO;

@Service
public class ReviewService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;

    @Autowired
    public ReviewService(StoreRepository storeRepository, ReviewRepository reviewRepository, ReviewConverter reviewConverter) {
        this.storeRepository = storeRepository;
        this.reviewRepository = reviewRepository;
        this.reviewConverter = reviewConverter;
    }

    public ReviewDTO addReview(Long storeId, ReviewDTO reviewDto) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        Review review = reviewConverter.convertToEntity(reviewDto);
        review.updateStore(store);
        reviewRepository.save(review);
        return reviewConverter.convertToDto(review);
    }
}
