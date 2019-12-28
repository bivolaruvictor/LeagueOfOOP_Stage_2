package constants;

public final class PyromancerConstants {
    private PyromancerConstants() {
    }

    public static final int PYROMANCER_STARTING_HP  = 500;
    public static final int PYROMANCER_HP_PER_LEVEL  = 50;

    public static final int FIREBLAST_STARTING_DAMAGE  = 350;
    public static final int FIREBLAST_DAMAGE_ADDED_PER_LEVEL  = 50;

    public static final int IGNITE_STARTING_DAMAGE  = 150;
    public static final int IGNITE_DAMAGE_ADDED_PER_LEVEL  = 20;

    public static final int ROUNDS_OF_IGNITE_SECONDARY_DAMAGE = 2;
    public static final int IGNITE_SECONDARY_STARTING_DAMAGE = 50;
    public static final int IGNITE_SECONDARY_DAMAGE_PER_LEVEL = 30;

    /*Stage 2*/
    public static final int OFFENSE_MIN_HP_MULTIPLYER = 4;
    public static final int OFFENSE_MAX_HP_MULTIPLYER = 3;
    public static final int OFFENSE_HP_MULTIPLYER = 3;
    public static final float OFFENSE_DAMAGE_MULTIPLYER = 0.7f;

    public static final int DEFENSE_MAX_HP_MULTIPLYER = 4;
    public static final int DEFENSE_HP_MULTIPLYER = 3;
    public static final float DEFENSE_DAMAGE_MULTIPLYER = -0.3f;
}
