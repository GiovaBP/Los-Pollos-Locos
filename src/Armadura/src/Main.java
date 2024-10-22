package Armadura.src;

public class Main {
    public static void main(String[] args) {
        Armor helmet = new Armor("Iron Helmet", 5, ArmorType.HELMET, 100);
        Armor chestplate = new Armor("Steel Chestplate", 15, ArmorType.CHESTPLATE, 200);

        displayArmorInfo(helmet);
        displayArmorInfo(chestplate);

        // Simula que el casco recibe 20 de daño
        helmet.takeDamage(20);
        System.out.println("After taking damage: " + helmet);

        // Repara el casco
        helmet.repair(10);
        System.out.println("After repairing: " + helmet);
    }

    private static void displayArmorInfo(Armor armor) {
        System.out.println(armor);
    }
}
