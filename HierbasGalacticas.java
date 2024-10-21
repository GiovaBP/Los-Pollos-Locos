package Items.Miscs;

import Player.*;
import Enums.Stats;

public class HierbasGalacticas extends Misc {
    private int healingAmount;

    public HierbasGalacticas() {
        super("Hierbas Galácticas", "Recupera 20 de salud.");
        this.healingAmount = 20;
    }

    public void use(Player player) {
        int currentHealth = player.getStat(Stats.HP);
        player.putStat(Stats.HP, currentHealth + healingAmount);
        System.out.println("Has usado Hierbas Galácticas. Salud restaurada en " + healingAmount);
    }
}
