package car.parking.service;

import car.parking.domain.Community;
import car.parking.dto.CommunityRequest;
import car.parking.exception.NotFound;
import car.parking.model.CommunityResponse;
import car.parking.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;

    private final ModelMapper modelMapper;

    @Override
    public CommunityResponse createCommunity(final CommunityRequest communityRequest) {
        log.info("Creating community: {}", communityRequest);

        Community communityToSave = new Community();
        communityToSave.setName(communityRequest.getName());
        communityToSave.setAddress(communityRequest.getAddress());

        Community community = communityRepository.save(communityToSave);

        return modelMapper.map(community, CommunityResponse.class);
    }

    @Override
    public CommunityResponse getCommunityById(final Long id) {
        log.info("Retrieving community by id: {}", id);

        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new NotFound("Community not found."));

        return modelMapper.map(community, CommunityResponse.class);
    }

    @Override
    public List<CommunityResponse> getAllCommunities() {
        log.info("Retrieving all communities.");

        List<Community> communities = communityRepository.findAll();

        return communities.stream()
                .map(community -> modelMapper.map(community, CommunityResponse.class))
                .collect(Collectors.toList());
    }
}