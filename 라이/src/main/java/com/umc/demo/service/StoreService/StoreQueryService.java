package com.umc.demo.service.StoreService;

import com.umc.demo.domain.Store;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
}
