package br.com.texoit.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.texoit.movie.entities.Movie;
import br.com.texoit.movie.repo.MovieRepository;
import br.com.texoit.movie.util.MovieUtil;

@Service
public class MovieService implements ApplicationRunner {
	private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());
	
	@Autowired
	private final MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
        List<Movie> movieList = MovieUtil.csvToMovie();

        LOGGER.log(Level.INFO, "Persist file: movieList.CSV");
        for (Movie movie : movieList)
        	movieRepository.save(movie);
	}
	
	public List<Movie> listAll() {
        return movieRepository.findAll();
    }
	
    public Movie buscarPorId(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movieOptional.get();
    }
    
    public void excluirPorId(Long id) {
    	Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        movieRepository.delete(movieOptional.get());
    }
    
    public Movie atualizarPorId(Long id, Movie movie) {
    	Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        movie.setId(id);
        return movieRepository.save(movie);
    }
    
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }
}