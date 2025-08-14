package com.shreyas.book_My_Show.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.shreyas.book_My_Show.dto.TheatreDTO;
import com.shreyas.book_My_Show.entity.TheatreEntity;
import com.shreyas.book_My_Show.repository.TheatreRepository;

@Service
public class TheatreService {
    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public TheatreDTO addTheatre(TheatreDTO theatreDTO) {
        TheatreEntity entity = mapToEntity(theatreDTO);
        TheatreEntity saved = theatreRepository.save(entity);
        return mapToDTO(saved);
    }

    public List<TheatreDTO> getAllTheatres() {
        return theatreRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TheatreDTO getTheatreById(Long id) {
        TheatreEntity theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        return mapToDTO(theatre);
    }


    private TheatreDTO mapToDTO(TheatreEntity entity) {
        return TheatreDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .city(entity.getCity())
                .address(entity.getAddress())
                .totalScreens(entity.getTotalScreens())
                .build();
    }

    private TheatreEntity mapToEntity(TheatreDTO dto) {
        return TheatreEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(dto.getCity())
                .address(dto.getAddress())
                .totalScreens(dto.getTotalScreens())
                .build();
}
}