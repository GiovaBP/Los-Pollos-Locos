package Items.Miscs;

import Player.*;
import Enums.Stats;

public class ElixirEstelar extends Misc {
    private int healingAmount;

    public ElixirEstelar() {
        super("Elixir Estelar", "Recupera 35 de salud.");
        this.healingAmount = 35;
    }

    public void use(Player player) {
        int currentHealth = player.getStat(Stats.HP);
        player.putStat(Stats.HP, currentHealth + healingAmount);
        System.out.println("Has usado un Elixir Estelar. Salud restaurada en " + healingAmount);
    }
}
