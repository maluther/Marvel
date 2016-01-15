import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
	Random rand = new Random();
	int mastermind = rand.nextInt(4);
	int scheme = rand.nextInt(8);
	int[] villians = getVillians(mastermind, scheme, Integer.parseInt(args[0]), rand);
	int[] henchmen = getHenchmen(mastermind, scheme, Integer.parseInt(args[0]), rand);
	int[] heroes = getHeroes(scheme, rand, Integer.parseInt(args[0]));
	mastermindPrint(mastermind);
	schemePrint(scheme);
	villiansPrint(villians);
	henchmenPrint(henchmen);
	heroesPrint(heroes);
    }

    private static int[] getHeroes(int scheme, Random rand, int numberOfPlayers)
    {
	int numberOfHeroes = 5;
	if(scheme == 5)
	    numberOfHeroes++;
	if(scheme == 6 && numberOfPlayers == 2)
	    numberOfHeroes++;
	if(numberOfPlayers == 5)
	    numberOfHeroes++;
	int[] heroes = new int[numberOfHeroes];
	int hero = rand.nextInt(15);
	for(int i = 0; i < numberOfHeroes; i++)
	{
	    while(arrayContains(heroes, hero))
	    {
		hero = rand.nextInt(15);
	    }
	    heroes[i] = hero;
	}
	return heroes;
    }

    private static int[] getHenchmen(int mastermind,  int scheme,int numberOfPlayers, Random rand)
    {
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
	if(scheme == 2)
	    numberOfHenchmen++;
	
	
	int[] henchmen = new int[numberOfHenchmen];
	int i = 0;
	if(mastermind == 2)
	    henchmen[i++] = 0;
	int henchman = rand.nextInt(4);
	for(; i < numberOfHenchmen; i++)
	{
	    while(arrayContains(henchmen, henchman))
	    {
		henchman = rand.nextInt(4);
	    }
	    henchmen[i] = henchman;
	}
	return henchmen;
    }

    private static int[] getVillians(int mastermind, int scheme, int numberOfPlayers, Random rand)
    {
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
	int[] villians = new int[numberOfVillians];
	int i = 0;

	if(mastermind == 0)
	    villians[i++] = 1;
	if(mastermind == 1)
	    villians[i++] = 0;
	if(mastermind == 3 || scheme == 5)
	    villians[i++] = 2;
	if(scheme == 5)
	    villians[i++] = 5;

	int villian = rand.nextInt(7);
	for(; i < numberOfVillians; i++)
	{
	    while(arrayContains(villians, villian))
	    {
		villian = rand.nextInt(7);
	    }
	    villians[i] = villian;
	}
	return villians;
    }

    private static boolean arrayContains(int[] villians, int villian)
    {
	for(int i = 0; i < villians.length; i++)
	    if(villians[i] == villian)
		return true;
	return false;
    }

    static void heroesPrint(int[] heroIds)
    {
	System.out.println("Heroes: ");
	for(int id : heroIds)
	{
	    switch (id)
	    {
		case 0:
		    System.out.println("\tBlack Widow");
		    break;
		case 1:
		    System.out.println("\tCaptain America");
		    break;
		case 2:
		    System.out.println("\tCyclops");
		    break;
		case 3:
		    System.out.println("\tDeadpool");
		    break;
		case 4:
		    System.out.println("\tEmma Frost");
		    break;
		case 5:
		    System.out.println("\tGambit");
		    break;
		case 6:
		    System.out.println("\tHawkeye");
		    break;
		case 7:
		    System.out.println("\tHulk");
		    break;
		case 8:
		    System.out.println("\tIron Man");
		    break;
		case 9:
		    System.out.println("\tNick Fury");
		    break;
		case 10:
		    System.out.println("\tRogue");
		    break;
		case 11:
		    System.out.println("\tSpider-Man");
		    break;
		case 12:
		    System.out.println("\tStorm");
		    break;
		case 13:
		    System.out.println("\tThor");
		    break;
		case 14:
		    System.out.println("\tWolverine");
		    break;
	    }
	}
    }

    static void villiansPrint(int[] villianIds)
    {
	System.out.println("Villians: ");
	for(int id : villianIds)
	{
	    switch (id)
	    {
		case 0:
		    System.out.println("\tBrotherhood");
		    break;
		case 1:
		    System.out.println("\tEnemies of Asgard");
		    break;
		case 2:
		    System.out.println("\tHYDRA");
		    break;
		case 3:
		    System.out.println("\tMasters of Evil");
		    break;
		case 4:
		    System.out.println("\tRadiation");
		    break;
		case 5:
		    System.out.println("\tSkrulls");
		    break;
		case 6:
		    System.out.println("\tSpider Foes");
		    break;
	    }
	}
    }

    static void henchmenPrint(int[] henchmanIds)
    {
	System.out.println("Henchmen: ");
	for(int id : henchmanIds)
	{
	    switch (id)
	    {
		case 0:
		    System.out.println("\tDoombot Legion");
		    break;
		case 1:
		    System.out.println("\tHand Ninjas");
		    break;
		case 2:
		    System.out.println("\tSavage Land Mutates");
		    break;
		case 3:
		    System.out.println("\tSentinels");
		    break;
	    }
	}
    }

    static void mastermindPrint(int mastermindId)
    {
	System.out.println("Mastermind: ");
	switch (mastermindId)
	{
	    case 0:
		System.out.println("\tLoki");
		break;
	    case 1:
		System.out.println("\tMegneto");
		break;
	    case 2:
		System.out.println("\tDr. Doom");
		break;
	    case 3:
		System.out.println("\tRed Skull");
		break;
	}
    }

    static void schemePrint(int schemeId)
    {
	System.out.println("Scheme: ");
	switch (schemeId)
	{
	    case 0:
		System.out.println("\tThe Legacy Virus");
		break;
	    case 1:
		System.out.println("\tMidtown Bank Robbery");
		break;
	    case 2:
		System.out.println("\tNegative Zone Prison Breakout");
		break;
	    case 3:
		System.out.println("\tPortals to the Dark Dimension");
		break;
	    case 4:
		System.out.println("\tReplace Earth's Leaders with Killbots");
		break;
	    case 5:
		System.out.println("\tSecret Invasion of the Skrull Shapeshifters");
		break;
	    case 6:
		System.out.println("\tSuper Hero Civil War");
		break;
	    case 7:
		System.out.println("\tUnleash the Power of the Cosmic Cube");
		break;
	}
    }
}
