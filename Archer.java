public class Archer extends Hero {
    public Archer(String name, String abilityName, String basicAttackName) {
        super(name, abilityName, basicAttackName, 90, 12);
    }

    @Override
    public void attack(Hero target) {
        if (cooldown == 0) {
            System.out.println(name + " выпускает " + abilityName + " в " + target.name);
            target.takeDamage(damage);
            if (target.isAlive) target.takeDamage(damage);
            cooldown = 2;
        } else {
            System.out.println(name + " " + basicAttackName + " в " + target.name);
            target.takeDamage(damage);
            cooldown--;
        }
    }
}