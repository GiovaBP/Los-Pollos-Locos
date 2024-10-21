package Enemy.Enemys;

/*
   Esta clase representa un enemigo específico en el juego, la QuimeraMutante.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque de la QuimeraMutante.
*/

import Player.Player;
import Enemy.Enemys.Enemy;

public class QuimeraMutante extends Enemy {
    public QuimeraMutante() {
        super("QuimeraMutante", 110, 50, 15, "Una criatura híbrida y monstruosa con fuerza y ferocidad impredecibles.");
    }

    @Override
    public void attack(Player player) {
        System.out.println(getName() + " golpea con sus múltiples extremidades!");
        player.takeDamage(getAttackPower());
    }
}
