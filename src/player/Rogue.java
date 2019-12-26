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
        Backstab backstab = (Backstab) getAbilityFactory()
                .getAbilityType(AbilityType.backstab, player);
        player.accept(backstab);
        player.recieveDamage();
        Paralysis paralysis = (Paralysis) getAbilityFactory()
                .getAbilityType(AbilityType.paralysis, player);
        player.accept(paralysis);
        player.recieveDamage();
        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
}
