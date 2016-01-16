package service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import repository.RandomizerRepository;
import domain.Game;
import domain.Henchman;
import domain.Hero;
import domain.Mastermind;
import domain.Scheme;
import domain.Villian;

public class RandomizerService
{
    @Autowired
    RandomizerRepository randomizerRepository;
    
    private static final int MAX_SCHEME = 8;
    public static final int MAX_MASTERMIND = 4;
    Random rand;
    
    public Game createRandomGame(int numberOfPlayers)
    {
	if(rand == null)
	    rand = new Random();
	Game game = new Game();
	game.setMastermind(determineMastermind());
	game.setScheme(determineScheme());
	game.setVillians(determineVillians(game.getMastermind(),game.getScheme(),numberOfPlayers));
	game.setHenchmen(determineHenchmen(game.getMastermind(), game.getScheme(), numberOfPlayers));
	game.setHeroes(determineHeroes(game.getScheme(), numberOfPlayers));
	return null;
    }
    private Scheme determineScheme()
    {
	int schemeId = rand.nextInt(MAX_SCHEME);
	Scheme scheme = randomizerRepository.lookupScheme(schemeId);
	return null;
    }
    private Mastermind determineMastermind()
    {
	int mastermindId = rand.nextInt(MAX_MASTERMIND);
	Mastermind mastermind = randomizerRepository.lookupMastermind(mastermindId);
	return mastermind;
    }
    private Hero[] determineHeroes(Scheme scheme, int numberOfPlayers)
    {
	int schemeId = scheme.getId()/10;
	int numberOfHeroes = 5;
	if(schemeId == 5)
	    numberOfHeroes++;
	if(schemeId == 6 && numberOfPlayers == 2)
	    numberOfHeroes++;
	if(numberOfPlayers == 5)
	    numberOfHeroes++;
	int[] heroIds = new int[numberOfHeroes];
	int heroId = rand.nextInt(15);
	for(int i = 0; i < numberOfHeroes; i++)
	{
	    while(arrayContains(heroIds, heroId))
	    {
		heroId = rand.nextInt(15);
	    }
	    heroIds[i] = heroId;
	}
	Hero[] heroes = randomizerRepository.lookupHeroes(heroIds);
	return heroes;
    }

    private Henchman[] determineHenchmen(Mastermind mastermind,  Scheme scheme,int numberOfPlayers)
    {
	int schemeId = scheme.getId()/10;
	int mastermindId = mastermind.getId()/10;
	int numberOfHenchmen = 0;
	switch (numberOfPlayers)
	{
	    case 2:
	    case 3:
		numberOfHenchmen = 1;
		break;
	    case 4:
	    case 5:
		numberOfHenchmen = 2;
		break;
	}
	if(schemeId == 2)
	    numberOfHenchmen++;
	
	
	int[] henchmenIds = new int[numberOfHenchmen];
	int i = 0;
	if(mastermindId == 2)
	    henchmenIds[i++] = 0;
	int henchmanId = rand.nextInt(4);
	for(; i < numberOfHenchmen; i++)
	{
	    while(arrayContains(henchmenIds, henchmanId))
	    {
		henchmanId = rand.nextInt(4);
	    }
	    henchmenIds[i] = henchmanId;
	}
	
	Henchman[] henchmen = randomizerRepository.lookupHenchmen(henchmenIds);
	return henchmen;
    }

    private Villian[] determineVillians(Mastermind mastermind, Scheme scheme, int numberOfPlayers)
    {
	int mastermindId = mastermind.getId()/10;
	int schemeId = scheme.getId()/10;
	int numberOfVillians = 0;
	switch (numberOfPlayers)
	{
	    case 2:
		numberOfVillians = 2;
		break;
	    case 3:
	    case 4:
		numberOfVillians = 3;
		break;
	    case 5:
		numberOfVillians = 4;
		break;
	}
	int[] villianIds = new int[numberOfVillians];
	int i = 0;

	if(mastermindId == 0)
	    villianIds[i++] = 1;
	if(mastermindId == 1)
	    villianIds[i++] = 0;
	if(mastermindId == 3 || schemeId == 5)
	    villianIds[i++] = 2;
	if(schemeId == 5)
	    villianIds[i++] = 5;

	int villian = rand.nextInt(7);
	for(; i < numberOfVillians; i++)
	{
	    while(arrayContains(villianIds, villian))
	    {
		villian = rand.nextInt(7);
	    }
	    villianIds[i] = villian;
	}
	Villian[] villians = randomizerRepository.lookupVillians(villianIds);
	return villians;
    }

    private static boolean arrayContains(int[] villians, int villian)
    {
	for(int i = 0; i < villians.length; i++)
	    if(villians[i] == villian)
		return true;
	return false;
    }
}
