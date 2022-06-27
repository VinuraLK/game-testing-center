package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.GameDto;
import com.example.demo.model.Game;

@Component
public class GameConvertor {
	
	public GameDto entityToDto (Game game) {
		GameDto g = new GameDto();
		g.setGameName(game.getGameName());
		g.setId(game.getId());
		g.setReleaseYear(game.getReleaseYear());
		
		return g;
		
		}
	public Game dtoToEntity (GameDto dto) {
		Game ga = new Game();
		ga.setGameName(dto.getGameName());
		ga.setId(dto.getId());
		ga.setReleaseYear(dto.getReleaseYear());
		
		return ga;
	}
	
	public List<GameDto> entitytoDto(List<Game> gamelist){
		
		return gamelist.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
	}
	
	public List<Game> dtoToEntity(List<GameDto> dtolist){
		
		return dtolist.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
		
	}
}
