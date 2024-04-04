package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Druid extends Hero {
    private boolean hasSummoned;
    private boolean isAngelSummoned;

    public Druid(int health, int damage, String name) {
        super(health, damage, SuperAbility.SUMMON_HELPER, name);
        this.hasSummoned = false;
        this.isAngelSummoned = false;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!hasSummoned) {
            hasSummoned = true;
            isAngelSummoned = RPG_Game.random.nextBoolean();
            if (isAngelSummoned) {
                System.out.println(getName() + " summons an angel to help the heroes.");
            } else {
                System.out.println(getName() + " summons a crow to help the boss.");
            }
        }

    }
}