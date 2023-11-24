package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private String title;
    private Float score;

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateScore(Float score) {
        this.score = score;
    }
}
