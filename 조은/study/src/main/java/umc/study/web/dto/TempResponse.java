package umc.study.web.dto;

import lombok.*;

public class TempResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO {
        String testString;
    }

}
