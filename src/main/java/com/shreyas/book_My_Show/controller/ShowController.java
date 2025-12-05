package com.shreyas.book_My_Show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreyas.book_My_Show.dto.ShowDTO;
import com.shreyas.book_My_Show.service.MovieService;
import com.shreyas.book_My_Show.service.ShowService;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    

    @PostMapping
    public ResponseEntity<ShowDTO> addShow(ShowDTO showDTO) {
        return ResponseEntity.ok(showService.addShow(showDTO));
    }

    @GetMapping
    public ResponseEntity<List<ShowDTO>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowDTO> getShowById(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }
    @GetMapping("/movie/{movieId}")
public ResponseEntity<List<ShowDTO>> getShowsByMovie(@PathVariable Long movieId) {
    return ResponseEntity.ok(showService.getShowsByMovie(movieId));
}

}
