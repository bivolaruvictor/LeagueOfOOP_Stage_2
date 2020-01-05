/*
 * Execute.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package abilities;

import constants.KnightConstants;
import constants.LandMultipliers;
import constants.RaceMultiplier;
import player.Knight;
import player.Rogue;
import player.Pyromancer;
import player.Wizard;
import player.Player;
import terrain.TerrainType;

public class Execute extends Ability {
    public Execute(final Player player) {
        super(player);
        setAbilityType(AbilityType.execute);
        setBaseDamage(KnightConstants.EXECUTE_STARTING_DAMAGE);
        setCasterLevel(player.getCasterLevel());
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.land)) {
            setLandModifier(LandMultipliers.LAND_MULTIPLIER);
        }
        player.setBruteDamage(Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                *  getLandModifier()));
    }
    /**/
    public int givenDamage(final Player player) {
        return Math.round(KnightConstants.EXECUTE_HP_LIMIT_PERCENTAGE * (player.getMaxHp())
                + Math.min(KnightConstants.EXECUTE_HP_LIMIT_PERCENTAGE_RISE_PER_LEVEL
                * getCasterLevel(),  KnightConstants.EXECUTE_HP_MAXIMUM_PERCENTAGE));
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_KNIGHT_EXECUTE);
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        if (givenDamage(player) >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_PYROMANCER_EXECUTE
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
    if (givenDamage(player)  >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }
    /**/
    public void interactWith(final Wizard player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_WIZARD_EXECUTE
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        if (givenDamage(player) >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_ROGUE_EXECUTE
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.EXECUTE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        if (givenDamage(player) >= player.getHp()) {
            player.setRecievedDamage(player.getHp());
        } else {
            player.setRecievedDamage(damageGiven);
        }
    }
}
