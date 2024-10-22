package Items;

import java.util.Map;
import Enums.ItemCategory;
import Enums.Stats;
import Enums.Slot;

public abstract class Equipment extends Item {
    private Slot slot;                  // El tipo de ranura donde se equipa el equipo
    private Map<Stats, Integer> stats;  // Mapa de estadísticas del equipo

    // Constructor que inicializa el equipo con una ranura y un mapa de estadísticas
    public Equipment(Slot slot, Map<Stats, Integer> stats) {
        super(ItemCategory.Miscelaneo); // Llamada al constructor de la clase base
        this.slot = slot;
        this.stats = stats;
    }

    // Constructor adicional que permite crear un equipo con un nombre y una categoría
    public Equipment(String name, int id, ItemCategory category) {
        super(name, String.valueOf(id), category); // Inicializa el item base
        // Puedes agregar inicialización adicional aquí si es necesario
    }

    // Método para obtener la ranura del equipo
    public Slot getSlot() {
        return slot;
    }

    // Método para obtener el mapa de estadísticas
    public Map<Stats, Integer> getStats() {
        return stats;
    }

    // Método para obtener el valor de una estadística específica
    public int getStatValue(Stats stat) {
        return stats.getOrDefault(stat, 0); // Retorna 0 si la estadística no está presente
    }

    // Método para establecer el valor de una estadística específica
    public void setStatValue(Stats stat, int value) {
        stats.put(stat, value);
    }
}
