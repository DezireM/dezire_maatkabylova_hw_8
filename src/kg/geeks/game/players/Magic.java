package kg.geeks.game.players;

public class Magic extends Hero {
    private int attackIncrease;
    public Magic(int health, int damage,int attackIncrease, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.attackIncrease = attackIncrease;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            int newDamage = hero.getDamage() + attackIncrease;
            hero.setDamage(newDamage);
        }
        System.out.println("Magic " + getName() + " boosts the attack of all heroes by " + attackIncrease);


    }
}
