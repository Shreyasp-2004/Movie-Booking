package com.shreyas.book_My_Show.service;

// import java.util.UUID;

// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.shreyas.book_My_Show.dto.ProfileDTO;
import com.shreyas.book_My_Show.entity.ProfileEntity;
import com.shreyas.book_My_Show.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    // private final ProfileDTO profileDTO;
    // private final PasswordEncoder passwordEncoder;

    public ProfileDTO registerUser(ProfileDTO profileDTO) {
        ProfileEntity newProfile = toEntity(profileDTO);
         newProfile = toEntity(profileDTO);
        newProfile = profileRepository.save(newProfile);
        return toDTO(newProfile);
    }

    public ProfileEntity toEntity(ProfileDTO profileDTO) {
        return ProfileEntity.builder()
                .id(profileDTO.getId())
                .name(profileDTO.getName())
                .email(profileDTO.getEmail())
                .password(profileDTO.getPassword())
                .build();
    }

    public ProfileDTO toDTO(ProfileEntity profileEntity) {
        return ProfileDTO.builder()
                .id(profileEntity.getId())
                .name(profileEntity.getName())
                .email(profileEntity.getEmail())
                .build();
    }
}
