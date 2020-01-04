package constants;

public final class WizardConstants {
    private WizardConstants() {
    }

    public static final int WIZARD_STARTING_HP = 400;
    public static final int WIZARD_HP_PER_LEVEL = 30;

    public static final float DRAIN_STARTING_PERCENTAGE = 0.2f;
    public static final float DRAIN_PERCENTAGE_ADDED_PER_LEVEL = 0.05f;
    public static final float DRAIN_HP_LIMIT_PERCENTAGE = 0.3f;

    public static final float DEFLECT_STARTING_PERCENTAGE = 0.35f;
    public static final float DEFLECT_PERCENTAGE_ADDED_PER_LEVEL = 0.02f;
    public static final float DEFLECT_MAXIMUM_PERCENTAGE = 0.7f;

    /*Stage 2*/
    public static final float OFFENSE_MIN_HP_MULTIPLYER = 4f;
    public static final float OFFENSE_MAX_HP_MULTIPLYER = 2f;
    public static final float OFFENSE_HP_MULTIPLYER = 10f;
    public static final float OFFENSE_DAMAGE_MULTIPLYER = 0.6f;

    public static final float DEFENSE_MAX_HP_MULTIPLYER = 4f;
    public static final float DEFENSE_HP_MULTIPLYER = 5f;
    public static final float DEFENSE_DAMAGE_MULTIPLYER = -0.2f;
}
