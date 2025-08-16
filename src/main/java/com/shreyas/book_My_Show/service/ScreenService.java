package com.shreyas.book_My_Show.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shreyas.book_My_Show.dto.ScreenDTO;
import com.shreyas.book_My_Show.entity.ScreenEntity;
import com.shreyas.book_My_Show.entity.TheatreEntity;
import com.shreyas.book_My_Show.repository.ScreenRepository;
import com.shreyas.book_My_Show.repository.TheatreRepository;

@Service
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    public ScreenService(ScreenRepository screenRepository, TheatreRepository theatreRepository) {
        this.screenRepository = screenRepository;
        this.theatreRepository = theatreRepository;
    }

    public ScreenDTO addScreen(ScreenDTO screenDTO) {
        TheatreEntity theatre = theatreRepository.findById(screenDTO.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        ScreenEntity screenEntity = mapToEntity(screenDTO, theatre);
        ScreenEntity saved = screenRepository.save(screenEntity);
        return mapToDTO(saved);
    }

    public List<ScreenDTO> getAllScreens() {
        return screenRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ScreenDTO getScreenById(Long id) {
        ScreenEntity screen = screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen not found"));
        return mapToDTO(screen);
    }

    // Mapping methods
    private ScreenDTO mapToDTO(ScreenEntity entity) {
        return ScreenDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .totalSeats(entity.getTotalSeats())
                .theatreId(entity.getTheatre().getId())
                .build();
    }

    private ScreenEntity mapToEntity(ScreenDTO dto, TheatreEntity theatre) {
        return ScreenEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .totalSeats(dto.getTotalSeats())
                .theatre(theatre)
                .build();
}
}
