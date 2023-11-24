package umc.study.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewService;
import umc.study.web.dto.ReviewDTO;

@RestController
@RequestMapping("/api/stores")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{storeId}/reviews")
    public ResponseEntity<ReviewDTO> addReview(@PathVariable Long storeId, @RequestBody ReviewDTO reviewDto) {
        ReviewDTO createdReview = reviewService.addReview(storeId, reviewDto);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
