package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDTO> resultDTO = result.map(movie -> new MovieDTO(movie));
		return resultDTO;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = movieRepository.findById(id).get(); // Forma simplificada, geralmente é com Optional daí necessita fazer o tratamento de excessao
		MovieDTO resultDTO = new MovieDTO(result);
		return resultDTO;
	}
	
}