package gui.exceptions;

public class PlayerDeadException extends Exception {

    public PlayerDeadException() {
        super("El jugador ha muerto");
    }
}
