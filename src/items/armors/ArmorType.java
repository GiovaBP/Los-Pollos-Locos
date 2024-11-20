package items.armors;

import java.io.Serializable;

public enum ArmorType implements Serializable {

	HEAD, CHEST, LEGS, FEET, HANDS, SHIELD;

	public static String getArmorType(ArmorType type) {

		return switch (type) {
			case HEAD -> "CABEZA";
			case CHEST -> "PECHO";
			case LEGS -> "PIERNAS";
			case FEET -> "PIES";
			case HANDS -> "MANOS";
			case SHIELD -> "ESCUDO";
		};
	}
}
