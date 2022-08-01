package br.com.texoit.movie.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@JsonInclude(value = Include.NON_EMPTY)
public class Movie implements Serializable {
	private static final long serialVersionUID = 1468526526699527595L;

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 //tive de colocar o nome da coluna em PT, pois em EN estava dando erro no momento da criacao no H2 #curioso
	 @Column(nullable = false, length = 4)
	 private String ano;
	 
	 @Column(nullable = false, length = 100)
	 private String title;
	 
	 @Column(nullable = false, length = 100)
	 private String studios;
	 
	 @Column(nullable = false, length = 200)
	 private String producers;
	 
	 @Column(nullable = true, length = 3)
	 private String winner;
	 
	 @Override
	 public String toString() {
		 return "Movie{ano=" + this.ano 
				 + ", title=" + this.title 
				 + ", studio=" + this.studios
	        	 + ", producers=" + this.producers
	        	 + ", winner=" + this.winner 
	        	 + "}";
	    }
}