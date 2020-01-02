package abilities;

import constants.KnightConstants;
import constants.LandMultipliers;
import constants.RaceMultiplier;
import player.Player;
import player.Pyromancer;
import player.Knight;
import player.Wizard;
import player.Rogue;
import terrain.TerrainType;

public class Slam extends Ability {
    public Slam(final Player player) {
        super(player);
        setCasterLevel(player.getLevel());
        setAbilityType(AbilityType.slam);
        setBaseDamage(KnightConstants.SLAM_STARTING_DAMAGE);
        setBaseDamage(getBaseDamage());
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType()
                .equals(TerrainType.land)) {
            setLandModifier(LandMultipliers.LAND_MULTIPLIER + getStrategyMultiplyer() + getHelperModifier());
        }
        player.setBruteDamage(player.getBruteDamage() + Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL
                * getCasterLevel()) * getLandModifier()));
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_KNIGHT_SLAM + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        player.setRecievedDamage(damageGiven);
        player.setBlock(KnightConstants.ROUNDS_OF_SLAM_STUN);
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_PYROMANCER_SLAM + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());
        player.setRecievedDamage(damageGiven);
        player.setBlock(KnightConstants.ROUNDS_OF_SLAM_STUN);
    }
    /**/
    public void interactWith(final Wizard player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_WIZARD_SLAM + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(KnightConstants.ROUNDS_OF_SLAM_STUN);
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.KNIGHT_ON_ROGUE_SLAM + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + KnightConstants.SLAM_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier());

        player.setRecievedDamage(damageGiven);
        player.setBlock(KnightConstants.ROUNDS_OF_SLAM_STUN);
    }
}
