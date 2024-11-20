package util.managers;

import player.Player;

import java.io.*;

public class FileManager {

	public static Player loadGame(File file) throws FileNotFoundException {

		Player player;
		try {
			player = (Player) new ObjectInputStream(new FileInputStream(file)).readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new FileNotFoundException("No se encontró el archivo");
		}
		return player;
	}

	public static void saveGame(Player player) {

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("files/game.dat"));
			oos.writeObject(player);
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
