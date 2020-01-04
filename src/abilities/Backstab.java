package abilities;

import constants.GameConstants;
import constants.LandMultipliers;
import constants.RaceMultiplier;
import constants.RogueConstants;
import player.Knight;
import player.Rogue;
import player.Pyromancer;
import player.Wizard;
import player.Player;
import terrain.TerrainType;

public class Backstab extends Ability {
    private float critical;
    public Backstab(final Player player) {
        super(player);
        setAbilityType(AbilityType.backstab);
        setBaseDamage(RogueConstants.BACKSTAB_STARTING_DAMAGE);
        setCasterLevel(player.getCasterLevel());
        critical = 1.0f;
        if (getGameMap().getMap().get(player.getxCoordinate()).
                get(player.getyCoordinate()).getTerrainType().equals(TerrainType.woods)) {
            setLandModifier(LandMultipliers.WOODS_MULTIPLIER);
            if (player.getRound() % RogueConstants.BACKSTAB_CRITICAL_CHARGE == 0) {
                setCritical(RogueConstants.BACKSTAB_CRITICAL_MULTIPLYER);
            }
        }
        player.setBruteDamage(Math.round((getBaseDamage()
                + RogueConstants.BACKSTAB_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                *  getLandModifier() * getCritical()));
    }
    /**/
    public float getCritical() {
        return critical;
    }
    /**/
    public void setCritical(final float critical) {
        this.critical = critical;
    }
    /**/
    public void interactWith(final Knight player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_KNIGHT_BACKSTAB
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.BACKSTAB_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical()
                - GameConstants.MAGIC_NUMBER);

        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Pyromancer player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_PYROMANCER_BACKSTAB
                + getStrategyMultiplyer() + getHelperModifier());

        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.BACKSTAB_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical()
                - GameConstants.MAGIC_NUMBER);
        System.out.println(damageGiven);
        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Wizard player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_WIZARD_BACKSTAB
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round(((getBaseDamage()
                + RogueConstants.BACKSTAB_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical())
                - GameConstants.MAGIC_NUMBER);
        player.setRecievedDamage(damageGiven);
    }
    /**/
    public void interactWith(final Rogue player) {
        setRaceModifier(RaceMultiplier.ROGUE_ON_ROGUE_BACKSTAB
                + getStrategyMultiplyer() + getHelperModifier());
        int damageGiven = Math.round((getBaseDamage()
                + RogueConstants.BACKSTAB_DAMAGE_ADDED_PER_LEVEL * getCasterLevel())
                * getRaceModifier() * getLandModifier() * getCritical()
                - GameConstants.MAGIC_NUMBER);
        player.setRecievedDamage(damageGiven);
    }
}
