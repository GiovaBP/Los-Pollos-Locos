package Items.Miscs;

import Player.*;
import Enums.Stats;

public class CristalRegenaracion extends Misc {
    private int healingAmount;

    public CristalRegenaracion() {
        super("Cristal de Regeneración", "Restaura 50 puntos de salud.");
        this.healingAmount = 50;
    }

    public void use(Player player) {
        int currentHealth = player.getStat(Stats.HP);
        player.putStat(Stats.HP, currentHealth + healingAmount);
        System.out.println("Has usado un Cristal de Regeneración. Salud restaurada en " + healingAmount);
    }
}
