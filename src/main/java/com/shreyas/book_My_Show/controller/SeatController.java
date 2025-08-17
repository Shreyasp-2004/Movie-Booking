package com.shreyas.book_My_Show.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shreyas.book_My_Show.dto.SeatDTO;
import com.shreyas.book_My_Show.service.SeatService;

@RestController
@RequestMapping("/seats")
public class SeatController {
   private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public ResponseEntity<SeatDTO> addSeat(@RequestBody SeatDTO seatDTO) {
        return ResponseEntity.ok(seatService.addSeat(seatDTO));
    }

    @GetMapping
    public ResponseEntity<List<SeatDTO>> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }
// ✏️ Update seat availability
@PatchMapping("/{id}/availability")
public ResponseEntity<SeatDTO> updateSeatAvailability(
        @PathVariable Long id,
        @RequestParam boolean isAvailable) {
    SeatDTO updatedSeat = seatService.updateSeatAvailability(id, isAvailable);
    return ResponseEntity.ok(updatedSeat);
}

    @GetMapping("/{id}")
    public ResponseEntity<SeatDTO> getSeatById(@PathVariable Long id) {
        return ResponseEntity.ok(seatService.getSeatById(id));
    }
}
