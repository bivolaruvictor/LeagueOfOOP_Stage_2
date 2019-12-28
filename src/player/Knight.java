package player;

import abilities.AbilityType;
import abilities.Execute;
import abilities.Slam;
import constants.KnightConstants;
import constants.LandMultipliers;
import abilities.Visitor;

public class Knight extends Player {

    public Knight() {
        super();
        setType(PlayerType.knight);
        setHp(KnightConstants.KNIGHT_STARTING_HP);
        setTerrainBonus(LandMultipliers.LAND_MULTIPLIER);
    }
    /**/
    @Override
    public int getMaxHp() {
        return KnightConstants.KNIGHT_STARTING_HP
                + KnightConstants.KNIGHT_HP_PER_LEVEL * getLevel();
    }
    /**/
    public void accept(final Visitor ability) {
        ability.interactWith(this);
    }
    /**/
    @Override
    public void fightPlayer(final Player player) {
        Execute execute = (Execute) getAbilityFactory().getAbilityType(AbilityType.execute, player);
        player.accept(execute);
        player.recieveDamage();
        Slam slam = (Slam) getAbilityFactory().getAbilityType(AbilityType.slam, player);
        player.accept(slam);
        player.recieveDamage();
        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }

    @Override
    /**/
    public void setStrategy() {
        if (getMaxHp() / KnightConstants.OFFENSE_MIN_HP_MULTIPLYER < getHp()
                && getHp() < getMaxHp() / KnightConstants.OFFENSE_MAX_HP_MULTIPLYER) {
            setHp(getHp() - getHp() / KnightConstants.OFFENSE_HP_MULTIPLYER);
            setStrategyMultiplyer(KnightConstants.OFFENSE_DAMAGE_MULTIPLYER);
        } else {
            if (getHp() < getMaxHp() / KnightConstants.DEFENSE_MAX_HP_MULTIPLYER) {
                setHp(getHp() + getHp() / KnightConstants.DEFENSE_HP_MULTIPLYER);
                setStrategyMultiplyer(KnightConstants.DEFENSE_DAMAGE_MULTIPLYER);
            }
        }
    }
}
