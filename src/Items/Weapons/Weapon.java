package Items.Weapons;

import Enums.ItemCategory;
import Items.Equipment;

public abstract class Weapon extends Equipment {
    private int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name, Integer.parseInt("Arma de tipo " + name), ItemCategory.Arma);
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void displayItemInfo() {
        System.out.println("Arma: " + getName() + " | Bono de ataque: " + attackBonus);
    }
}
