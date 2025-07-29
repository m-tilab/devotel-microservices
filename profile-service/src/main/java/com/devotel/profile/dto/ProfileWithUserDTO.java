package com.devotel.profile.dto;

public record ProfileWithUserDTO(
    Long profileId,
    String bio,
    String location,
    int age,
    Long userId,
    String userName,
    String userEmail
) {}
