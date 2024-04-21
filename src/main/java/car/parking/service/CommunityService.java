package car.parking.service;

import car.parking.dto.CommunityRequest;
import car.parking.model.CommunityResponse;

import java.util.List;

public interface CommunityService {

    /**
     * Create a new community
     */
    CommunityResponse createCommunity(final CommunityRequest communityRequest);

    /**
     * Get community by id
     */
    CommunityResponse getCommunityById(final Long id);

    /**
     * Get all communities
     */
    List<CommunityResponse> getAllCommunities();
}