public class Mage extends Hero {
    public Mage(String name, String abilityName, String basicAttackName) {
        super(name, abilityName, basicAttackName, 80, 20);
    }

    @Override
    public void attack(Hero target) {
        if (cooldown == 0) {
            System.out.println(name + " колдует " + abilityName + " в " + target.name);
            target.takeDamage(damage + 15);
            cooldown = 2;
        } else {
            System.out.println(name + " " + basicAttackName + " в " + target.name);
            target.takeDamage(damage);
            cooldown--;
        }
    }
}