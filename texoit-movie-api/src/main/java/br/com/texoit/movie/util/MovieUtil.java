package br.com.texoit.movie.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import br.com.texoit.movie.entities.Movie;

public class MovieUtil {
	private static final Logger LOGGER = Logger.getLogger(MovieUtil.class.getName());
	
	public static List<Movie> csvToMovie() throws IOException {
		String pathLocal = System.getProperty("user.dir");
	
		LOGGER.log(Level.INFO, "Path your system: " + pathLocal);
		
		Reader reader = Files.newBufferedReader(Paths.get(pathLocal + "/src/main/resources/movielist.csv"));
		
        CsvToBean<Movie> csvToBean = new CsvToBeanBuilder<Movie>(reader)
                .withType(Movie.class)
                .build();
        
        List<Movie> movieList = csvToBean.parse();
		
		return movieList;
	}
}