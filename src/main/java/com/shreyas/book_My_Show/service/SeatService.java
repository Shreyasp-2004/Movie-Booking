package com.shreyas.book_My_Show.service;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreyas.book_My_Show.dto.SeatDTO;
import com.shreyas.book_My_Show.entity.ScreenEntity;
import com.shreyas.book_My_Show.entity.SeatEntity;
import com.shreyas.book_My_Show.repository.ScreenRepository;
import com.shreyas.book_My_Show.repository.SeatRepository;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;

    
    public SeatService(SeatRepository seatRepository, ScreenRepository screenRepository) {
        this.seatRepository = seatRepository;
        this.screenRepository = screenRepository;
    }

    public SeatDTO addSeat(SeatDTO seatDTO) {
        ScreenEntity screen = screenRepository.findById(seatDTO.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        SeatEntity seatEntity = mapToEntity(seatDTO, screen);
        SeatEntity saved = seatRepository.save(seatEntity);
        return mapToDTO(saved);
    }

    public List<SeatDTO> getAllSeats() {
        return seatRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
public SeatDTO updateSeatAvailability(Long id, boolean isAvailable) {
    SeatEntity seat = seatRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Seat not found"));

    seat.setAvailable(isAvailable); // ✅ Update availability
    SeatEntity updated = seatRepository.save(seat);

    return mapToDTO(updated);
}

    public SeatDTO getSeatById(Long id) {
        SeatEntity seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        return mapToDTO(seat);
    }

    // Mapping methods
    private SeatDTO mapToDTO(SeatEntity entity) {
        return SeatDTO.builder()
                .id(entity.getId())
                .seatNumber(entity.getSeatNumber())
                .seatType(entity.getSeatType())
                .isAvailable(entity.isAvailable())
                .screenId(entity.getScreen().getId())
                .build();
    }

    private SeatEntity mapToEntity(SeatDTO dto, ScreenEntity screen) {
        return SeatEntity.builder()
                .id(dto.getId())
                .seatNumber(dto.getSeatNumber())
                .seatType(dto.getSeatType())
                .isAvailable(dto.isAvailable())
                .screen(screen)
                .build();
    }
}