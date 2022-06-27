package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.model.Game;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	private GameRepository gameRepository;

	@Override
	public Game saveGame(Game game) {
		Game ga = gameRepository.save(game);
		return ga;
	}

	@Override
	public List<Game> getAllGames() {
		List<Game> list = gameRepository.findAll();
		return list;
	}

	@Override
	public Game getGameById(long id) {
		Optional<Game> g = gameRepository.findById(id);
		return g.get();
	}

	@Override
	public Game updateGame(long id, Game game) {
		Game existingGame = gameRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Game", "Id", id));;
		existingGame.setGameName(game.getGameName());
		existingGame.setId(game.getId());
		existingGame.setReleaseYear(game.getReleaseYear());
		
		gameRepository.save(existingGame);
		return existingGame;
	}

	@Override
	public void deleteGame(long id) {
		gameRepository.deleteById(id);
		
	}

	@Override
	public List<Appointment> getAppointmentsForGame(long id) {
		Game game = gameRepository.findById(id).get();
		return game.getAppointments();
	}

}
