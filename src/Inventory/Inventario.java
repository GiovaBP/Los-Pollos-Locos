package Inventory;

import Items.Item;
import Items.Armaduras.Armor;
import Items.Miscs.Misc;

import java.util.ArrayList;

class Inventory {

    private final ArrayList<Item> items; // Cambiado a final para mayor claridad
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("El inventario está lleno.");
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public int getItemCount() { // Cambié el tipo de retorno para devolver el conteo
        return items.size();
    }

    public boolean isFull() {
        return items.size() >= capacity; // Cambié para incluir el caso en que está lleno
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void increaseCapacity(int amount) {
        capacity += amount;
        items.ensureCapacity(capacity); // Esto asegura que el tamaño interno pueda crecer
    }

    public ArrayList<Armor> getArmors() {
        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }

    public ArrayList<Misc> getMiscs() {
        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }
}
