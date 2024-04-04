package kg.geeks.game.players;

public class Antman extends Hero {
    private double sizeMultiplier;

    public Antman(int health, int damage, double sizeMultiplier, String name) {
        super(health, damage, SuperAbility.SIZE_CHANGE, name);
        this.sizeMultiplier = sizeMultiplier;
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.setHealth((int) (this.getHealth() * sizeMultiplier));
        this.setDamage((int) (this.getDamage() * sizeMultiplier));
        System.out.println(this.getName() + " changes size. New health: " + this.getHealth() +
                ", New damage: " + this.getDamage());

    }

}
