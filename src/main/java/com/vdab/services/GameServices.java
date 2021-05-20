package com.vdab.services;

import com.vdab.domain.Game;
import com.vdab.repositorie.GameRepository;
import com.vdab.repositorie.NotFoundException;

import java.util.List;

public class GameServices {    GameRepository gameRepository = new GameRepository();


    public Game findFifthGame(){
        return gameRepository.findFifthGame();
    }


    public Game findGameByPartName(String string) throws NotFoundException {
        return gameRepository.findGameByPartName(string);
    }

    public List<Game> showAllGames() {
        return gameRepository.showAllGames();
    }

    public Game showAndChoose(String string) throws NotFoundException {
        return gameRepository.showAndChoose(string);
    }

    public List<Game> searchByDifficulty(int id) {
        return gameRepository.searchByDifficulty(id);
    }

    public List<Game> showAllGames2() {
        return gameRepository.showAllGames2();
    }

    public Game findByID(int id) {

        return gameRepository.findByID(id);
    }
}
