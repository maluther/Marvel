package domain;

public class Game
{
    Mastermind mastermind;
    Henchman[] henchmen;
    Hero[] heroes;
    Scheme scheme;
    Villian[] villians;
    
    public Mastermind getMastermind()
    {
        return mastermind;
    }
    public void setMastermind(Mastermind mastermind)
    {
        this.mastermind = mastermind;
    }
    public Henchman[] getHenchmen()
    {
        return henchmen;
    }
    public void setHenchmen(Henchman[] henchmen)
    {
        this.henchmen = henchmen;
    }
    public Hero[] getHeroes()
    {
        return heroes;
    }
    public void setHeroes(Hero[] heroes)
    {
        this.heroes = heroes;
    }
    public Scheme getScheme()
    {
        return scheme;
    }
    public void setScheme(Scheme scheme)
    {
        this.scheme = scheme;
    }
    public Villian[] getVillians()
    {
        return villians;
    }
    public void setVillians(Villian[] villians)
    {
        this.villians = villians;
    }
}
