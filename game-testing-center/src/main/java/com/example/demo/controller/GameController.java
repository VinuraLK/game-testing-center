package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converter.AppointmentConvertor;
import com.example.demo.converter.GameConvertor;
import com.example.demo.dto.AppointmentDto;
import com.example.demo.dto.GameDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Game;
import com.example.demo.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameConvertor convertor;
	
	@Autowired
	private AppointmentConvertor appConvertor;
	
	public GameController(AppointmentConvertor appConvertor) {
		super();
		this.appConvertor = appConvertor;
	}

	public GameController(GameConvertor convertor) {
		super();
		this.convertor = convertor;
	}
	
	//create appointment API
	@PostMapping("gamestestingcenter/game/create")
	public GameDto createGame(GameDto gamedto) {
		Game game = convertor.dtoToEntity(gamedto);
		gameService.saveGame(game);
		return convertor.entityToDto(game);
		
	}
	
	//Get All Rest API
	@PostMapping("gamestestingcenter/game/getall")
	public List<GameDto> getAllGames(){
		List<Game> getallgames = gameService.getAllGames();
		return convertor.entitytoDto(getallgames);
	}
	
	//Get Game by ID
	@GetMapping("gamestestingcenter/game/get/{id}")
	public GameDto getGameByID(@PathVariable("id") long id) {
		Game g = gameService.getGameById(id);
		return convertor.entityToDto(g);
	}
	
	//Update Game
	@PutMapping("gametestingcenter/game/update/{id}")
	public GameDto updateGame(@PathVariable("id") long id,@RequestBody GameDto dto) {
		Game entity = convertor.dtoToEntity(dto);
		entity = gameService.updateGame(id, entity);
		return convertor.entityToDto(entity);
	}
	
	//Delete Game
	@DeleteMapping("gamestestingcenter/game/delete/{id}")
	public void deleteGame(@PathVariable ("id") long id) {
		gameService.deleteGame(id);
	} 
	
	//Get appointments for a game
	@GetMapping("/gametestingcenter/game/{id}/posts")
	public List<AppointmentDto> getAppointmentsForGame(@PathVariable int id){
		List<Appointment> app = gameService.getAppointmentsForGame(id);
		 return appConvertor.entitytoDto(app);
		
	}
	
	
	
}
