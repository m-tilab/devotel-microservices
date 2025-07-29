package com.devotel.profile.service;

import com.devotel.profile.dto.ProfileDTO;
import com.devotel.profile.dto.ProfileWithUserDTO;
import com.devotel.profile.exception.ResourceNotFoundException;
import com.devotel.profile.model.Profile;
import com.devotel.profile.repository.ProfileRepository;
import com.devotel.profile.soap.client.UserSoapClient;
import com.devotel.profile.soap.stub.GetUserByIdResponse;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserSoapClient userSoapClient;

    public ProfileService(ProfileRepository profileRepository, UserSoapClient userSoapClient) {
        this.profileRepository = profileRepository;
        this.userSoapClient = userSoapClient;
    }

    public Profile createProfile(ProfileDTO dto) {

        GetUserByIdResponse user = userSoapClient.getUserById(dto.userId());

        if (user == null || user.getId() == null) {
            throw new ResourceNotFoundException("User not found with ID: " + dto.userId());
        }

        Profile profile = new Profile();
        profile.setUserId(dto.userId());
        profile.setBio(dto.bio());
        profile.setLocation(dto.location());
        profile.setAge(dto.age());
        return profileRepository.save(profile);
    }

    public ProfileWithUserDTO getProfileWithUser(Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with ID: " + profileId));

        GetUserByIdResponse user = userSoapClient.getUserById(profile.getUserId());

        if (user == null || user.getId() == null) {
            throw new ResourceNotFoundException("User not found with ID: " + profile.getUserId());
        }

        return new ProfileWithUserDTO(
                profile.getId(),
                profile.getBio(),
                profile.getLocation(),
                profile.getAge(),
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
