package umc.study.web.dto;

import lombok.Getter;
import org.w3c.dom.Text;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {

    @Getter
    public static class ReviewDto{
        @NotNull
        int point;
        @NotBlank
        String text;
        @NotBlank
        String photo;
    }

    @Getter
    public static class MissionDto{
        @NotNull
        int point;
        @NotBlank
        String text;
    }
}
