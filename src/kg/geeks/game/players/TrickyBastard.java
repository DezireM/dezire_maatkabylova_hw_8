package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class TrickyBastard extends Hero {
    private boolean isPretendingDead;

    public TrickyBastard(int health, int damage, String name) {
        super(health, damage, SuperAbility.PRETEND_DEAD, name);
        this.isPretendingDead = false;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!isPretendingDead && RPG_Game.random.nextBoolean()) {
            isPretendingDead = true;
            System.out.println(getName() + " pretends to be dead.");
        } else if (isPretendingDead) {
            isPretendingDead = false;
            System.out.println(getName() + " returns to field.");
        }
    }

}
