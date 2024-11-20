package player.debuffs;

public class Debuff {

    private int duration;
    private int damage;

    private final DebuffType type;

    public Debuff(DebuffType type) {
        this.duration = 3;
        this.damage = 1;
        this.type = type;
    }

    public Debuff(DebuffType debuffType, int duration) {
        this.duration = duration;
        this.damage = 0;
        this.type = debuffType;
    }

    public Debuff(DebuffType debuffType, int duration, int defenseDecrease) {
        this.duration = duration;
        this.damage = defenseDecrease;
        this.type = debuffType;
    }

    public void reduceDuration() {
        duration--;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDuration() {
        return duration;
    }

    public int getDamage() {
        return damage;
    }
}
