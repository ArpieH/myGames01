package com.vdab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.vdab.services.GameServices;


@Controller
public class GamesController {

    private GameServices gameService = new GameServices();

    @GetMapping(value = "/")
    public String showGamePage(Model model) {
        model.addAttribute("allGames", gameService.showAllGames());
        return "index";
    }

}



