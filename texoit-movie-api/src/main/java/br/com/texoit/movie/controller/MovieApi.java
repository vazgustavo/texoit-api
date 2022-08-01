package br.com.texoit.movie.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.texoit.movie.entities.Movie;
import br.com.texoit.movie.service.MovieService;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieApi {
	
	@Autowired
	private MovieService movieService;
	
    @GetMapping("all")
    public List<Movie> listAll() {
        return movieService.listAll();
    }
    
    @PostMapping("create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }
    
    @GetMapping("{id}")
    public Movie buscarPorId(@PathVariable Long id) {
       return movieService.buscarPorId(id);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
    	movieService.excluirPorId(id);
    }
    
    @PutMapping("/{id}")
    public Movie atualizarPorId(@PathVariable Long id, @RequestBody Movie movie) {
    	return movieService.atualizarPorId(id, movie);
    }
}