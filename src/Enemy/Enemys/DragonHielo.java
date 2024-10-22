package Enemy.Enemys;

/*
   Esta clase representa un enemigo específico en el juego, el DragonHielo.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del DragonHielo.
*/

import Player.Player;
import Enemy.Enemys.Enemy;

public class DragonHielo extends Enemy {
    public DragonHielo() {
        super("DragonHielo", 100, 40, 20, "Una criatura imponente que ataca con frialdad mortal y garras heladas.");
    }

    @Override
    public void attack(Player player) {
        System.out.println(getName() + " exhala un aliento gélido!");
        player.takeDamage(getAttackPower());
    }
}
