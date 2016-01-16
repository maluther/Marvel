package com.marvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marvel.domain.Game;
import com.marvel.service.RandomizerService;

@Controller
public class RandomizerController
{
    @Autowired
    RandomizerService randomizerService;
    
    @RequestMapping(value="/randomize", method=RequestMethod.GET)
    public Game randomGame(@RequestParam int numberOfPlayers)
    {
	Game game = randomizerService.createRandomGame(numberOfPlayers);
	return game;
    }
}
