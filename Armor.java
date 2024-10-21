package Items.Armaduras;

import Enums.ItemCategory;
import Items.Equipment;

public abstract class Armor extends Equipment {
    private final int defenseBonus; // Cambiado a final para mayor claridad

    public Armor(String name, int defenseBonus) {
        super(name, Integer.parseInt("Armadura de tipo " + name), ItemCategory.Armadura);
        this.defenseBonus = defenseBonus;
    }

    public int getDefenseBonus() { // Cambié el nombre del método para reflejar correctamente la función
        return defenseBonus;
    }

    public void displayItemInfo() {
        System.out.println("Armadura: " + getName() + " | Bono de defensa: " + defenseBonus); // Corregido 'Bono de ataque' a 'Bono de defensa'
    }
}
