public abstract class Hero {
    String name;
    String abilityName;
    String basicAttackName;
    int hp;
    int maxHp;
    int damage;
    boolean isAlive = true;
    int cooldown = 0;

    public Hero(String name, String abilityName, String basicAttackName, int hp, int damage) {
        this.name = name;
        this.abilityName = abilityName;
        this.basicAttackName = basicAttackName;
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
    }

    public void takeDamage(int dmg) {
        this.hp -= dmg;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
            System.out.println("  Ой-ё-ёй " + name + " умер :(");
        }
    }

    public abstract void attack(Hero target);
}