public class Warrior extends Hero {
    public Warrior(String name, String abilityName, String basicAttackName) {
        super(name, abilityName, basicAttackName, 120, 15);
    }

    @Override
    public void attack(Hero target) {
        if (cooldown == 0) {
            System.out.println(name + " использует " + abilityName + " по " + target.name);
            target.takeDamage(damage * 2);
            cooldown = 3;
        } else {
            System.out.println(name + " " + basicAttackName + " по " + target.name);
            target.takeDamage(damage);
            cooldown--;
        }
    }
}