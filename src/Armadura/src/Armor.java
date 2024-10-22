package Armadura.src;

public class Armor {
    private String name;
    private int defense;
    private ArmorType type;
    private int durability;

    public Armor(String name, int defense, ArmorType type, int durability) {
        this.name = name;
        this.defense = defense;
        this.type = type;
        this.durability = Math.max(durability, 0); // Evitar durabilidad negativa al crear
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public ArmorType getType() {
        return type;
    }

    public int getDurability() {
        return durability;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDefense(int defense) {
        if (defense >= 0) {
            this.defense = defense;
        }
    }

    public void setType(ArmorType type) {
        this.type = type;
    }

    public void setDurability(int durability) {
        this.durability = Math.max(durability, 0); // Asegurar durabilidad no negativa
    }

    // Reduce la durabilidad de la armadura al recibir daño
    public void takeDamage(int damage) {
        if (damage > 0) {
            this.durability = Math.max(this.durability - damage, 0);
        }
    }

    // Método para reparar la armadura
    public void repair(int amount) {
        if (amount > 0) {
            this.durability += amount;
            // Aquí podrías agregar un valor máximo de durabilidad si es necesario.
        }
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", defense=" + defense +
                ", type=" + type +
                ", durability=" + durability +
                '}';
    }
}
