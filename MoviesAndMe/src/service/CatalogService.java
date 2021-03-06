package service;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

import metier.*;
import metier.entities.*;


@Singleton
@Path("/catalog")
@Produces(MediaType.APPLICATION_JSON)
public class CatalogService {
	private Catalog metier;
	
	public CatalogService() {
		metier = new Catalog();
		metier.initializeCatalog();
	}
	
	@GET
	@Path("/films")
	public List<Film> AllFilm(){
		return metier.listFilm();
	}
	
	@GET
	@Path("/film/{id}")
	public Film FilmById(@PathParam (value="id")int id){
		return metier.FilmById(id);
	}
	
	@GET
	@Path("/filmsKW/")
	public List<Film> ListFilmByKeyWord(@QueryParam(value="keyword")String keyword) {
		return metier.ListFilmByKeyWord(keyword);
	}
	
	
	@GET
	@Path("/cinemas")
	public List<Cinema> AllCinema(){
		return metier.listCinema();
	}
	
	@GET
	@Path("/cinema/{id}")
	public Cinema SelectCinemaById(@PathParam (value="id") int id){
		return metier.CinemaById(id);
	}
	
	
	
}
