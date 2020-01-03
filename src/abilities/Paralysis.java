package abilities;

import constants.LandMultipliers;
import constants.RaceMultiplier;
import constants.RogueConstants;
import player.Knight;
import player.Rogue;
import player.Pyromancer;
import player.Wizard;
import player.Player;
import terrain.TerrainType;

public class Paralysis extends Ability {
    private int blockMovement;
    public Paralysis(final Player player) {
        super(player);
        setBlockMovement(RogueConstants.PARALYSIS_EFFECT_ALL_TERRAIN);
        setAbilityType(AbilityType.paralysis);
        setBaseDamage(RogueConstants.PARALYSIS_STARTING_DAMAGE);
        setCasterLevel(player.getLevel());
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.woods)) {
            setLandModifier(LandMultipliers.WOODS_MULTIPLIER + getStrategyMultiplyer() + getHelperModifier());
            setBlockMovement(RogueConstants.PARALYSIS_EFFECT_WOODS);
        }
        player.setBruteDamage(player.getBruteDamage() + Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                *  getLandModifier()));
    }
    /**/
    public int getBlockMovement() {
        return blockMovement;
    }
    /**/
    public void setBlockMovement(final int blockMovement) {
        this.blockMovement = blockMovement;
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_KNIGHT_PARALISYS + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() - 0.00001f);

        player.setRecievedDamage(damageGiven);
        player.setOvertimeDamage(damageGiven);
        player.setOvertimeRounds(getBlockMovement());
        player.setBlock(getBlockMovement());
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_PYROMANCER_PARALISYS + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier()- 0.00001f);

        player.setRecievedDamage(damageGiven);
        player.setOvertimeDamage(Math.round((RogueConstants.PARALYSIS_STARTING_DAMAGE
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getLandModifier() * getRaceModifier()));
        player.setOvertimeRounds(getBlockMovement());
        player.setBlock(getBlockMovement());
    }
    /**/
    public void interactWith(final Wizard player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_WIZARD_PARALISYS + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier()- 0.00001f);

        player.setRecievedDamage(damageGiven);
        player.setOvertimeDamage(Math.round((RogueConstants.PARALYSIS_STARTING_DAMAGE
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getLandModifier() * getRaceModifier()));
        player.setOvertimeRounds(getBlockMovement());
        player.setBlock(getBlockMovement());
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_ROGUE_PARALISYS + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() - 0.00001f);

        player.setRecievedDamage(damageGiven);
        player.setOvertimeDamage(Math.round((RogueConstants.PARALYSIS_STARTING_DAMAGE
                + RogueConstants.PARALYSIS_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getLandModifier() * getRaceModifier()));
        player.setOvertimeRounds(getBlockMovement());
        player.setBlock(getBlockMovement());
    }
}
