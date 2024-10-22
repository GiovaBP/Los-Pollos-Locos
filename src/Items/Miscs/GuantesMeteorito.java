package Items.Miscs;

import Player.*;

public class GuantesMeteorito extends Misc {
    private int attackBoost;
    private int defenseBoost;
    private int duration;

    public GuantesMeteorito() {
        super("Guantes Meteorito", "Aumenta el ataque y la defensa por 3 turnos.");
        this.attackBoost = 20;
        this.defenseBoost = 15;
        this.duration = 9;
    }

    public void use(Player player) {
        System.out.println("Has consumido Guantes Meteorito. Ataque aumentado en " + attackBoost +
                " y defensa aumentada en " + defenseBoost + " por " + duration + " turnos.");
        // Aquí aplicaríamos lógica para aumentar temporalmente ataque y defensa
        // Puede implicar un seguimiento de turnos y reducción de los efectos al expirar
    }
}
