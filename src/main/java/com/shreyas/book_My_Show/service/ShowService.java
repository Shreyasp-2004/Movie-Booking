package com.shreyas.book_My_Show.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shreyas.book_My_Show.dto.ShowDTO;
import com.shreyas.book_My_Show.entity.MovieEntity;
import com.shreyas.book_My_Show.entity.ScreenEntity;
import com.shreyas.book_My_Show.entity.ShowEntity;
import com.shreyas.book_My_Show.repository.MovieRepository;
import com.shreyas.book_My_Show.repository.ScreenRepository;
import com.shreyas.book_My_Show.repository.ShowRepository;

@Service
public class ShowService {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    public ShowService(ShowRepository showRepository,
                       MovieRepository movieRepository,
                       ScreenRepository screenRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.screenRepository = screenRepository;
    }

    public ShowDTO addShow(ShowDTO showDTO) {
        MovieEntity movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        ScreenEntity screen = screenRepository.findById(showDTO.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        ShowEntity entity = mapToEntity(showDTO, movie, screen);
        ShowEntity saved = showRepository.save(entity);
        return mapToDTO(saved);
    }

    public List<ShowDTO> getAllShows() {
        return showRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ShowDTO getShowById(Long id) {
        ShowEntity show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        return mapToDTO(show);
    }

    // Mapping methods
    private ShowDTO mapToDTO(ShowEntity entity) {
        return ShowDTO.builder()
                .id(entity.getId())
                .showTime(entity.getShowTime().toString())
                .ticketPrice(entity.getTicketPrice())
                .movieId(entity.getMovie().getId())
                .screenId(entity.getScreen().getId())
                .build();
    }

    private ShowEntity mapToEntity(ShowDTO dto, MovieEntity movie, ScreenEntity screen) {
        return ShowEntity.builder()
                .id(dto.getId())
                .showTime(LocalDateTime.parse(dto.getShowTime()))
                .ticketPrice(dto.getTicketPrice())
                .movie(movie)
                .screen(screen)
                .build();
    }
}
