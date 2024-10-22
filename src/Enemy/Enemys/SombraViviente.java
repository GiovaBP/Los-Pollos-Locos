package Enemy.Enemys;

/*
   Esta clase representa un enemigo específico en el juego, la SombraViviente.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque de la SombraViviente.
*/

import Player.Player;
import Enemy.Enemys.Enemy;

public class SombraViviente extends Enemy {
    public SombraViviente() {
        super("SombraViviente", 50, 20, 5, "Una entidad oscura y ágil, difícil de detectar y mortal."); // Defensa ligera
    }

    @Override
    public void attack(Player player) {
        System.out.println(getName() + " se abalanza desde las sombras!");
        player.takeDamage(getAttackPower());
    }
}
