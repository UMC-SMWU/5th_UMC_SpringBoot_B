package umc.study.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreDTO;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final StoreConverter storeConverter;

    @Autowired
    public StoreService(StoreRepository storeRepository, RegionRepository regionRepository, StoreConverter storeConverter) {
        this.storeRepository = storeRepository;
        this.regionRepository = regionRepository;
        this.storeConverter = storeConverter;
    }

    public StoreDTO addStore(Long regionId, StoreDTO StoreDTO) {
        Region region = regionRepository.findById(regionId).orElseThrow(() -> new RuntimeException("Region not found"));
        Store store = storeConverter.convertToEntity(StoreDTO);
        store.updateRegion(region);
        storeRepository.save(store);
        return storeConverter.convertToDto(store);
    }
}
