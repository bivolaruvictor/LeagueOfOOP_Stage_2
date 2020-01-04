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

public class Fireblast extends Ability {
    public Fireblast(final Player player) {
        super(player);
        setAbilityType(AbilityType.fireblast);
        setBaseDamage(PyromancerConstants.FIREBLAST_STARTING_DAMAGE);
        setCasterLevel(player.getCasterLevel());
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.volcanic)) {
            setLandModifier(LandMultipliers.VOLCANIC_MULTIPLIER
                    + getStrategyMultiplyer() + getHelperModifier());
        }
        player.setBruteDamage(Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                *  getLandModifier()));
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_KNIGHT_FIREBLAST
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_PYROMANCER_FIREBLAST
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Wizard player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_WIZARD_FIREBLAST
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.PYROMANCER_ON_ROGUE_FIREBLAST
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + PyromancerConstants.FIREBLAST_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
    }
}
