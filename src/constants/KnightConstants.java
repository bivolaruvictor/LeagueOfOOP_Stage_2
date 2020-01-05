/*
 * KnightConstants.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package constants;

public final class KnightConstants {
    private KnightConstants() { }
    public static final int KNIGHT_STARTING_HP = 900;
    public static final int KNIGHT_HP_PER_LEVEL = 80;

    public static final int EXECUTE_STARTING_DAMAGE = 200;
    public static final int EXECUTE_DAMAGE_ADDED_PER_LEVEL = 30;
    public static final float EXECUTE_HP_LIMIT_PERCENTAGE = 0.2f;
    public static final float EXECUTE_HP_LIMIT_PERCENTAGE_RISE_PER_LEVEL = 0.01f;
    public static final float EXECUTE_HP_MAXIMUM_PERCENTAGE = 0.4f;

    public static final int SLAM_STARTING_DAMAGE = 100;
    public static final int SLAM_DAMAGE_ADDED_PER_LEVEL = 40;
    public static final int ROUNDS_OF_SLAM_STUN = 1;

    /*Stage 2*/
    public static final int OFFENSE_MIN_HP_MULTIPLYER = 3;
    public static final int OFFENSE_MAX_HP_MULTIPLYER = 2;
    public static final int OFFENSE_HP_MULTIPLYER = 5;
    public static final float OFFENSE_DAMAGE_MULTIPLYER = 0.5f;

    public static final int DEFENSE_MAX_HP_MULTIPLYER = 3;
    public static final int DEFENSE_HP_MULTIPLYER = 4;
    public static final float DEFENSE_DAMAGE_MULTIPLYER = -0.2f;
}
