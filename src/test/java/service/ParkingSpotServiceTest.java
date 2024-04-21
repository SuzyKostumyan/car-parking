package service;

import car.parking.domain.Community;
import car.parking.domain.ParkingSpot;
import car.parking.exception.NotFound;
import car.parking.model.CommunityResponse;
import car.parking.model.ParkingSpotResponse;
import car.parking.repository.ParkingSpotRepository;
import car.parking.service.CommunityService;
import car.parking.service.ParkingSpotServiceImpl;
import helper.CommunityBuilder;
import helper.ParkingSpotBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import util.RandomValueGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParkingSpotServiceTest {

    @Mock
    private CommunityService communityService;

    @Mock
    private ParkingSpotRepository parkingSpotRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ParkingSpotServiceImpl parkingSpotService;

    @AfterEach
    void finalizeTest() {
        verifyNoMoreInteractions(communityService, parkingSpotRepository, modelMapper);
    }

    @Test
    void createParkingSpot_shouldCreateParkingSpot() {
        // Given
        Long communityId = RandomValueGenerator.generatePositiveRandomLong();
        CommunityResponse communityResponse = new CommunityBuilder().buildCommunityResponse();
        Community community = new CommunityBuilder().build();

        ParkingSpot parkingSpot = new ParkingSpotBuilder().build();
        ParkingSpotResponse expectedResponse = new ParkingSpotBuilder().buildParkingSpotResponse();

        when(communityService.getCommunityById(communityId)).thenReturn(communityResponse);
        when(modelMapper.map(communityResponse, Community.class)).thenReturn(community);
        when(modelMapper.map(parkingSpot, ParkingSpotResponse.class)).thenReturn(expectedResponse);
        when(parkingSpotRepository.save(any(ParkingSpot.class))).thenReturn(parkingSpot);

        // When
        ParkingSpotResponse result = parkingSpotService.createParkingSpot(communityId);

        // Then
        assertNotNull(result);
        assertEquals(expectedResponse, result);
        verify(communityService, times(1)).getCommunityById(communityId);
        verify(modelMapper, times(1)).map(communityResponse, Community.class);
        verify(modelMapper, times(1)).map(parkingSpot, ParkingSpotResponse.class);
        verify(parkingSpotRepository, times(1)).save(any(ParkingSpot.class));
    }

    @Test
    void createParkingSpot_ShouldThrowException_WhenCommunityNotFound() {
        // Given
        Long communityId = 1L;
        when(communityService.getCommunityById(communityId)).thenThrow(new NotFound("Community not found."));

        // Then
        assertThrows(NotFound.class, () -> parkingSpotService.createParkingSpot(communityId));
        verify(communityService, times(1)).getCommunityById(communityId);
    }
}