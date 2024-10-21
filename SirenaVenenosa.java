package Enemy.Enemys;

/*
   Esta clase representa un enemigo específico en el juego, la SirenaVenenosa.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque de la SirenaVenenosa.
*/

import Player.Player;
import Enemy.Enemys.Enemy;

public class SirenaVenenosa extends Enemy {
    public SirenaVenenosa() {
        super("SirenaVenenosa", 80, 30, 10, "Una criatura hermosa pero mortal, con veneno en sus garras.");
    }

    @Override
    public void attack(Player player) {
        System.out.println(getName() + " lanza un ataque venenoso!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() para obtener el poder de ataque
    }
}
