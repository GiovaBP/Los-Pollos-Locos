package Enums;

/*
   Esta enumeración (`enum`) define las estadísticas básicas que un jugador o enemigo puede tener en el juego,
   específicamente: ataque, salud (HP) y defensa.
   Se utiliza para garantizar seguridad de tipo al manejar estadísticas en otras clases del juego.
*/

public enum Stats {
    ATTACK,
    HP,
    DEFENSE;

    private Stats() {
    }
}
