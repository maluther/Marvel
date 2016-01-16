package controller;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.RandomizerService;
import domain.Game;

@Controller
public class Main
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
