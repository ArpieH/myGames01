package com.vdab.sevices;

import com.vdab.domain.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.vdab.repositorie.NotFoundException;
import com.vdab.services.GameServices;

public class GameServiceTest {   private GameServices gameService = new GameServices();
    @Test
    public void testFindById () throws NotFoundException {

        Game game = gameService.findByID(1);
        Assertions.assertAll(()-> Assertions.assertEquals("Getting started with waste", game.getGameName()),
                ()-> Assertions.assertEquals("De Helix", game.getEditor()),
                ()-> Assertions.assertEquals(2005, game.getYearEdition()),
                ()->Assertions.assertEquals("from 13y", game.getAge()),
                ()->Assertions.assertEquals(4, game.getMinPlayers()),
                ()->Assertions.assertEquals(20, game.getMaxPlayers()),
                ()-> Assertions.assertEquals("educational", game.getCategory().getCategoryName()),
                ()->Assertions.assertEquals("easy", game.getDifficulty().getDifficultyName()),
                ()->Assertions.assertEquals(7.5, game.getPrice()),
                ()->Assertions.assertEquals("aandeslagmetafval.jpg", game.getImage()),
                ()->Assertions.assertEquals("n/a", game.getAuthor())
        );
    }

    @Test
    public void testFindGameByPartName() throws NotFoundException {
        Game game = gameService.findGameByPartName("Getting");
        Assertions.assertAll(()-> Assertions.assertEquals("Getting started with waste", game.getGameName()),
                ()-> Assertions.assertEquals("De Helix", game.getEditor()),
                ()-> Assertions.assertEquals(2005, game.getYearEdition()),
                ()->Assertions.assertEquals("from 13y", game.getAge()),
                ()->Assertions.assertEquals(4, game.getMinPlayers()),
                ()->Assertions.assertEquals(20, game.getMaxPlayers()),
                ()-> Assertions.assertEquals("educational", game.getCategory().getCategoryName()),
                ()->Assertions.assertEquals("easy", game.getDifficulty().getDifficultyName()),
                ()->Assertions.assertEquals(7.5, game.getPrice()),
                ()->Assertions.assertEquals("aandeslagmetafval.jpg", game.getImage()),
                ()->Assertions.assertEquals("n/a", game.getAuthor())
        );

    }

}
