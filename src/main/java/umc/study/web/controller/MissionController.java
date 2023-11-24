package umc.study.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.MissionService.MissionService;
import umc.study.web.dto.MissionDTO;
import umc.study.web.dto.MissionMemberDTO;

@RestController
@RequestMapping("/api/stores")
public class MissionController {

    private final MissionService missionService;

    @Autowired
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping("/{storeId}/missions")
    public ResponseEntity<MissionDTO> addMission(@PathVariable Long storeId, @RequestBody MissionDTO missionDto) {
        MissionDTO createdMission = missionService.addMission(storeId, missionDto);
        return new ResponseEntity<>(createdMission, HttpStatus.CREATED);
    }
    @PostMapping("/missions/members")
    public ResponseEntity<Void> addMissionToMember(@RequestBody MissionMemberDTO missionMemberDto) {
        missionService.addMissionToMember(missionMemberDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
