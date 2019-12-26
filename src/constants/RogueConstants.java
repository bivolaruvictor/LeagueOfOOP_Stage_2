package constants;

public final class RogueConstants {
    private RogueConstants() {
    }

    public static final int ROGUE_STARTING_HP = 600;
    public static final int ROGUE_HP_PER_LEVEL = 40;

    public static final int BACKSTAB_STARTING_DAMAGE = 200;
    public static final int BACKSTAB_DAMAGE_ADDED_PER_LEVEL = 20;
    public static final int BACKSTAB_CRITICAL_CHARGE = 3;
    public static final float BACKSTAB_CRITICAL_MULTIPLYER = 1.5f;

    public static final int PARALYSIS_STARTING_DAMAGE = 40;
    public static final int PARALYSIS_DAMAGE_ADDED_PER_LEVEL = 10;
    public static final int PARALYSIS_EFFECT_WOODS = 6;
    public static final int PARALYSIS_EFFECT_ALL_TERRAIN = 3;
}
