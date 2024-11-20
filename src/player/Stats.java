package player;

public enum Stats {

	ATTACK("ATK"),
	DEFENSE("DEF"),
	DEXTERITY("HAB"),
	INTELLIGENCE("INT"),
	RESISTANCE("RES"),
	LUCK("SUE"),
	SPEED("VEL");

	private final String name;

	Stats(String name) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public static Stats getStat(String name) {

		for (Stats stat : Stats.values()) {
			if (stat.getName().equals(name)) {
				return stat;
			}
		}
		throw new IllegalArgumentException("Invalid stat: " + name);
	}
}
