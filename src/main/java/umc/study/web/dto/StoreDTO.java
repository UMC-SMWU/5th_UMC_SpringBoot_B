package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {

    private String name;
    private String address;
    private Float score;


    public void updateName(String name) {
        this.name = name;
    }


    public void updateAddress(String address) {
        this.address = address;
    }

    public void updateScore(Float score) {
        this.score = score;
    }
}
