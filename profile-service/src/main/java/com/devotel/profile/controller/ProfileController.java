package com.devotel.profile.controller;

import com.devotel.profile.dto.ProfileDTO;
import com.devotel.profile.dto.ProfileWithUserDTO;
import com.devotel.profile.model.Profile;
import com.devotel.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Profiles", description = "Profile management API")
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Create a new profile for an existing user")
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDTO dto) {
        Profile created = profileService.createProfile(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileWithUserDTO> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileWithUser(id));
    }
}
