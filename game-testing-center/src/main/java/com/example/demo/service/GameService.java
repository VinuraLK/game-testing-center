package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Appointment;
import com.example.demo.model.Game;

public interface GameService {

	Game saveGame(Game game);
	
	List<Game> getAllGames();
	
	Game getGameById (long id);
	
	Game updateGame (long id, Game game);
	
	void deleteGame (long id);
	
	List<Appointment> getAppointmentsForGame(long id );
}
