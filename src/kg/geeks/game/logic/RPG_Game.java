package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Thanos");

        Warrior warrior1 = new Warrior(280, 10, "Stark");
        Warrior warrior2 = new Warrior(270, 15, "Thor");
        Magic magic = new Magic(290, 20, 20,"Robert-Houdin");
        Berserk berserk = new Berserk(260, 10, "Odin");
        Medic doc = new Medic(250, 5, 15, "Dr.OZ");
        Medic assistant = new Medic(300, 5, 5, "Hranitel");
        Witcher witcher = new Witcher(100,0,"Azeroth");
        Hacker hacker = new Hacker(150,5,90,"Edward Snowden");
        Avrora avrora = new Avrora(250,40,"Daisy");
        Druid druid = new Druid(150,10,"Dzen");
        TrickyBastard trickyBastard = new TrickyBastard(230,8,"Wilson");
        Antman antman = new Antman(240,27,3,"Max");
        Hero[] heroes = {warrior1, warrior2, doc, magic, berserk, assistant,witcher,hacker,};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ---------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

}
