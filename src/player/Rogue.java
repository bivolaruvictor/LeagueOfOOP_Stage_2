package player;

import abilities.AbilityType;
import abilities.Backstab;
import abilities.Paralysis;
import constants.LandMultipliers;
import constants.RogueConstants;
import abilities.Visitor;

public class Rogue extends Player {
    private int numberOfBackstabs;
    public Rogue() {
        super();
        setType(PlayerType.rogue);
        setHp(RogueConstants.ROGUE_STARTING_HP);
        setTerrainBonus(LandMultipliers.WOODS_MULTIPLIER);
    }
    /**/
    @Override
    public int getMaxHp() {
        return RogueConstants.ROGUE_STARTING_HP
                + RogueConstants.ROGUE_HP_PER_LEVEL * getLevel();
    }
    /**/
    public void accept(final Visitor ability) {
        ability.interactWith(this);
    }
    /**/
    @Override
    public void fightPlayer(final Player player) {
        player.setCasterLevel(getLevel());
        Backstab backstab = (Backstab) getAbilityFactory()
                .getAbilityType(AbilityType.backstab, player);
        backstab.setStrategyMultiplyer(getStrategyMultiplyer());
        backstab.setHelperModifier(getHelperMultiplyer());
        player.accept(backstab);
        player.recieveDamage();
        System.out.println(player.typeToString() + " " + player.getId()
                + " got backstab "
                + player.getRecievedDamage());
        Paralysis paralysis = (Paralysis) getAbilityFactory()
                .getAbilityType(AbilityType.paralysis, player);
        paralysis.setStrategyMultiplyer(getStrategyMultiplyer());
        paralysis.setHelperModifier(getHelperMultiplyer());
        player.accept(paralysis);
        player.recieveDamage();
        System.out.println(player.typeToString() + " " + player.getId()
                + " got paralysis " + player.getRecievedDamage());
        System.out.println();
        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
    @Override
    /**/
    public void setStrategy() {
        if (getMaxHp() / RogueConstants.OFFENSE_MIN_HP_MULTIPLYER < getHp()
                && getHp() < getMaxHp() / RogueConstants.OFFENSE_MAX_HP_MULTIPLYER) {
            setHp(Math.round(getHp() - Math.round(getHp() / RogueConstants.OFFENSE_HP_MULTIPLYER)));
            setStrategyMultiplyer(getStrategyMultiplyer()
                    + RogueConstants.OFFENSE_DAMAGE_MULTIPLYER);
        } else {
            if (getHp() < getMaxHp() / RogueConstants.DEFENSE_MAX_HP_MULTIPLYER) {
                setHp(Math.round(getHp()
                        + Math.round(getHp() / RogueConstants.DEFENSE_HP_MULTIPLYER)));
                setStrategyMultiplyer(getStrategyMultiplyer()
                        + RogueConstants.DEFENSE_DAMAGE_MULTIPLYER);
            }
        }
    }
}
