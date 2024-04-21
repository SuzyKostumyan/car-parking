package car.parking.controller;

import car.parking.dto.CommunityRequest;
import car.parking.model.CommunityResponse;
import car.parking.service.CommunityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/communities")
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping
    public ResponseEntity<CommunityResponse> createCommunity(@RequestBody CommunityRequest communityRequest) {
        return ResponseEntity.ok(communityService.createCommunity(communityRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityResponse> getCommunityById(@PathVariable Long id) {
        return ResponseEntity.ok(communityService.getCommunityById(id));
    }

    @GetMapping
    public ResponseEntity<List<CommunityResponse>> getAllCommunities() {
        return ResponseEntity.ok(communityService.getAllCommunities());
    }
}