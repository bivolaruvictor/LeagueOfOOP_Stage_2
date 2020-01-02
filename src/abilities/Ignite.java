package abilities;

import constants.LandMultipliers;
import constants.PyromancerConstants;
import constants.RaceMultiplier;
import player.Player;
import player.Pyromancer;
import player.Knight;
import player.Wizard;
import player.Rogue;
import terrain.TerrainType;

public class Ignite extends Ability {
    public Ignite(final Player player) {
        super(player);
        setAbilityType(AbilityType.ignite);
        setBaseDamage(PyromancerConstants.IGNITE_STARTING_DAMAGE);
        setCasterLevel(player.getLevel());
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.volcanic)) {
            setLandModifier(LandMultipliers.VOLCANIC_MULTIPLIER + getStrategyMultiplyer() + getHelperModifier());
        }
        player.setBruteDamage(player.getBruteDamage() + Math.round((getBaseDamage()
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                *  getLandModifier()));
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_KNIGHT_IGNITE + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        player.setRecievedDamage(damageGiven);
        int secondaryDamage = Math.round((PyromancerConstants.IGNITE_SECONDARY_STARTING_DAMAGE
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setOvertimeDamage(secondaryDamage);
        player.setOvertimeRounds(PyromancerConstants.ROUNDS_OF_IGNITE_SECONDARY_DAMAGE);
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_PYROMANCER_IGNITE + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);

        int secondaryDamage = Math.round((PyromancerConstants.IGNITE_SECONDARY_STARTING_DAMAGE
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getLandModifier() * getRaceModifier());

        player.setOvertimeDamage(secondaryDamage);
        player.setOvertimeRounds(PyromancerConstants.ROUNDS_OF_IGNITE_SECONDARY_DAMAGE);
    }
    /**/
    public void interactWith(final Wizard player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_WIZARD_IGNITE + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);

        int secondaryDamage = Math.round((PyromancerConstants.IGNITE_SECONDARY_STARTING_DAMAGE
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getLandModifier() * getRaceModifier());

        player.setOvertimeDamage(secondaryDamage);
        player.setOvertimeRounds(PyromancerConstants.ROUNDS_OF_IGNITE_SECONDARY_DAMAGE);
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_ROGUE_IGNITE + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);

        int secondaryDamage = Math.round((PyromancerConstants.IGNITE_SECONDARY_STARTING_DAMAGE
                + PyromancerConstants.IGNITE_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getLandModifier() * getRaceModifier());

        player.setOvertimeDamage(secondaryDamage);
        player.setOvertimeRounds(PyromancerConstants.ROUNDS_OF_IGNITE_SECONDARY_DAMAGE);
    }
}
