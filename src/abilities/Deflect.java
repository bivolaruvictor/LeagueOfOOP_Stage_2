/*
 * Deflect.java
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

public class Deflect extends Ability {
    private float deflectPercentage;
    private int casterDamage;
    public Deflect(final Player player) {
        super(player);
        setCasterLevel(player.getCasterLevel());
        setAbilityType(AbilityType.deflect);
        setDeflectPercentage(Math.min(WizardConstants.DEFLECT_STARTING_PERCENTAGE
                + WizardConstants.DEFLECT_PERCENTAGE_ADDED_PER_LEVEL
                * getCasterLevel() + getStrategyMultiplyer()
                + getHelperModifier(), WizardConstants.DEFLECT_MAXIMUM_PERCENTAGE));
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.dessert)) {
            setLandModifier(LandMultipliers.DESERT_MULTIPLIER);
            setDeflectPercentage(getDeflectPercentage() * getLandModifier());
        }
        setCasterDamage(player.getBruteDamage());
    }
    /**/
    public float getDeflectPercentage() {
        return deflectPercentage;
    }
    /**/
    public int getCasterDamage() {
        return casterDamage;
    }
    /**/
    public void setCasterDamage(final int casterDamage) {
        this.casterDamage = casterDamage;
    }
    /**/
    public void setDeflectPercentage(final float deflectPercentage) {
        this.deflectPercentage = deflectPercentage;
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_KNIGHT_DEFLECT
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round(player.getBruteDamage()
                * getDeflectPercentage() * getRaceModifier());
        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_PYROMANCER_DEFLECT
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round(player.getBruteDamage()
                * getDeflectPercentage() * getRaceModifier());
        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Wizard player) {
        player.setRecievedDamage(0);
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.WIZARD_ON_ROGUE_DEFLECT
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round(player.getBruteDamage()
                * getDeflectPercentage() * getRaceModifier());
        player.setRecievedDamage(damageGiven);
    }
}
