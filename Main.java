public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        battle.addToTeam1(new Warrior("Блум", "Огоненый взрыв", "бьёт огненным клинком"));
        battle.addToTeam1(new Mage("Стела", "Солнечный луч", "пускает искру солнца"));
        battle.addToTeam1(new Archer("Муза", "Звуковая волна", "стреляет нотами"));

        battle.addToTeam2(new Warrior("Айси", "Ледяной шар", "бьёт ледяным клинком"));
        battle.addToTeam2(new Mage("Сторми", "Удар молнии", "пускает грозу"));
        battle.addToTeam2(new Archer("Дарси", "Гипнотический выстрел", "стреляет темной магией"));

        battle.start();
    }
}