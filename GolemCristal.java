package Enemy.Enemys;

/*
   Esta clase representa un enemigo específico en el juego, el GolemCristal.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del GolemCristal.
*/

import Player.Player;
import Enemy.Enemys.Enemy;

public class GolemCristal extends Enemy {
    public GolemCristal() {
        super("GolemCristal", 150, 50, 25, "Una criatura robusta y resistente, formada por cristales duros.");
    }

    @Override
    public void attack(Player player) {
        System.out.println(getName() + " lanza un poderoso golpe con sus puños cristalinos!");
        player.takeDamage(getAttackPower());
    }
}
