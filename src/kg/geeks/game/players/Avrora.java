package kg.geeks.game.players;

public class Avrora extends Hero {
    private boolean isInvisible;
    private int invisibleRounds;
    public Avrora(int health, int damage, String name) {
        super(health, damage, SuperAbility.INVISIBLE_MODE, name);
        this.isInvisible = false;
        this.invisibleRounds = 2;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!isInvisible && invisibleRounds > 0) {
            isInvisible = true;
            invisibleRounds--;
            System.out.println(getName() + " is now invisible and immune to boss damage.");
        } else if (isInvisible) {
            boss.setHealth(boss.getHealth() - getDamage());
            System.out.println(getName() + " reflects damage to the boss.");
        }
    }

}
