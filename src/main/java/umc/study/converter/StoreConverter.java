package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Store;
import umc.study.web.dto.StoreDTO;

@Component
public class StoreConverter {

    public Store convertToEntity(StoreDTO StoreDTO) {
        return Store.builder()
                .name(StoreDTO.getName())
                .address(StoreDTO.getAddress())
                .score(StoreDTO.getScore())
                .build();
    }

    public StoreDTO convertToDto(Store store) {
        StoreDTO StoreDTO = new StoreDTO();
        StoreDTO.updateName(store.getName());
        StoreDTO.updateAddress(store.getAddress());
        StoreDTO.updateScore(store.getScore());
        return StoreDTO;
    }
}
