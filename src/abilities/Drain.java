/*
 * Drain.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package abilities;

import constants.LandMultipliers;
import constants.RaceMultiplier;
import constants.WizardConstants;
import player.Knight;
import player.Rogue;
import player.Pyromancer;
import player.Wizard;
import player.Player;
import terrain.TerrainType;

public class Drain extends Ability {
    private float drainPercentage;
    public Drain(final Player player) {
        super(player);
        setCasterLevel(player.getCasterLevel());
        setAbilityType(AbilityType.drain);
        setDrainPercentage(WizardConstants.DRAIN_STARTING_PERCENTAGE
        + WizardConstants.DRAIN_PERCENTAGE_ADDED_PER_LEVEL * getCasterLevel()
                + getStrategyMultiplyer() + getHelperModifier());

        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.dessert)) {
            setLandModifier(LandMultipliers.DESERT_MULTIPLIER);
            setDrainPercentage(getDrainPercentage() * getLandModifier()
                    + getStrategyMultiplyer() + getHelperModifier());
        }

    }
    /**/
    public float getDrainPercentage() {
        return drainPercentage;
    }
    /**/
    public void setDrainPercentage(final float drainPercentage) {
        this.drainPercentage = drainPercentage;
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_KNIGHT_DRAIN
                + getStrategyMultiplyer() + getHelperModifier());
        setDrainPercentage(getDrainPercentage() * getRaceModifier());
        int damageGiven = Math.round(getDrainPercentage()
               * Math.min(WizardConstants.DRAIN_HP_LIMIT_PERCENTAGE
               * player.getMaxHp(), player.getHp()));

        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_PYROMANCER_DRAIN
                + getStrategyMultiplyer() + getHelperModifier());
        setDrainPercentage(getDrainPercentage() * getRaceModifier());
        int damageGiven = Math.round(getDrainPercentage()
                * Math.min(WizardConstants.DRAIN_HP_LIMIT_PERCENTAGE
                * player.getMaxHp(), player.getHp()));
        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Wizard player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_WIZARD_DRAIN
                + getStrategyMultiplyer() + getHelperModifier());
        setDrainPercentage(getDrainPercentage() * getRaceModifier());
        int damageGiven = Math.round(getDrainPercentage()
                * Math.min(WizardConstants.DRAIN_HP_LIMIT_PERCENTAGE
                * player.getMaxHp(), player.getHp()));
        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_ROGUE_DRAIN
                + getStrategyMultiplyer() + getHelperModifier());
        setDrainPercentage(getDrainPercentage() * getRaceModifier());
        int damageGiven = Math.round(getDrainPercentage()
                * Math.min(WizardConstants.DRAIN_HP_LIMIT_PERCENTAGE
                * player.getMaxHp(), player.getHp()));
        player.setRecievedDamage(damageGiven);
    }
}
