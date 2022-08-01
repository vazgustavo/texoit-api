package br.com.texoit.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.texoit.movie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}