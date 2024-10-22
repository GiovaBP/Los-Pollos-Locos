package Items.Miscs;

import Enums.ItemCategory;
import Items.Item;

public abstract class Misc extends Item {
    private final String consumable;
    private final String stackable;

    public Misc(String consumable, String stackable) {
        super(ItemCategory.Miscelaneo);
        this.consumable = consumable;
        this.stackable = stackable;
    }

    public String getConsumable() {
        return consumable;
    }

    public String getStackable() {
        return stackable;
    }
}
