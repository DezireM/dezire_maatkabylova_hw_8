package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Hacker extends Hero {
    private int healthStolenPerRound;
    public Hacker(int health, int damage,int healthStolenPerRound,String name) {
        super(health, damage,SuperAbility.HACKING, name);
        this.healthStolenPerRound = healthStolenPerRound;

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boss.setHealth(boss.getHealth() - healthStolenPerRound);
        int randomHeroIndex = RPG_Game.random.nextInt(heroes.length);
        Hero randomHero = heroes[randomHeroIndex];
        randomHero.setHealth(randomHero.getHealth() + healthStolenPerRound);
        System.out.println("Hacker " + getName() + " hacks boss and steals "
                + healthStolenPerRound + " health, transferring it to " + randomHero.getName());



    }
}
