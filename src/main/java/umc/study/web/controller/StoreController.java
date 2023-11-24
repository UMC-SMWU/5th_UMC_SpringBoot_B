package umc.study.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.StoreService.StoreService;
import umc.study.web.dto.StoreDTO;

@RestController
@RequestMapping("/api/regions")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/{regionId}/stores")
    public ResponseEntity<StoreDTO> addStore(@PathVariable Long regionId, @RequestBody StoreDTO StoreDTO) {
        StoreDTO createdStore = storeService.addStore(regionId, StoreDTO);
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }
}
