package com.shreyas.book_My_Show.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.shreyas.book_My_Show.dto.MovieDTO;
import com.shreyas.book_My_Show.entity.MovieEntity;
import com.shreyas.book_My_Show.repository.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    public MovieDTO addMovie(MovieDTO movieDTO){
        MovieEntity movieEntity = mapToEntity(movieDTO);
        MovieEntity savedMovie = movieRepository.save(movieEntity);
        return mapToDTO(savedMovie);
    }

    public List<MovieDTO> getAllMovies(){
        return movieRepository.findAll()
            .stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }
       public MovieDTO getMovieById(Long id) {
        MovieEntity movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return mapToDTO(movie);
    }

    private MovieDTO mapToDTO(MovieEntity movie){
        return MovieDTO.builder()
           .id(movie.getId())
           .title(movie.getTitle())
           .description(movie.getDescription())
           .releaseDate(movie.getReleaseDate())
           .language(movie.getLanguage())
           .genre(movie.getGenre())
           .durationMinutes(movie.getDurationMinutes())
           .build();

    }

    private MovieEntity mapToEntity(MovieDTO dto){
        return MovieEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .releaseDate(dto.getReleaseDate())
                .language(dto.getLanguage())
                .genre(dto.getGenre())
                .durationMinutes(dto.getDurationMinutes())
                .build();
    }


}
