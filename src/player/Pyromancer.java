/*
 * Pyromancer.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package player;

import abilities.AbilityType;
import abilities.Fireblast;
import abilities.Ignite;
import constants.LandMultipliers;
import constants.PyromancerConstants;
import abilities.Visitor;

public class Pyromancer extends Player {
    public Pyromancer() {
        super();
        setType(PlayerType.pyromancer);
        setHp(PyromancerConstants.PYROMANCER_STARTING_HP);
        setTerrainBonus(LandMultipliers.VOLCANIC_MULTIPLIER);
    }
    /**/
    @Override
    public int getMaxHp() {
        return PyromancerConstants.PYROMANCER_STARTING_HP
                + PyromancerConstants.PYROMANCER_HP_PER_LEVEL * getLevel();
    }
    /**/
    public void accept(final Visitor ability) {
        ability.interactWith(this);
    }
    /**/
    public void fightPlayer(final Player player) {
        player.setCasterLevel(getLevel());
        Fireblast fireblast = (Fireblast) getAbilityFactory()
                .getAbilityType(AbilityType.fireblast, player);
        fireblast.prepareForBattle(this);
        player.accept(fireblast);
        player.recieveDamage();

        Ignite ignite = (Ignite) getAbilityFactory().getAbilityType(AbilityType.ignite, player);
        ignite.prepareForBattle(this);
        player.accept(ignite);
        player.recieveDamage();

        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
    @Override
    /**/
    public void setStrategy() {
        if (getMaxHp() / PyromancerConstants.OFFENSE_MIN_HP_MULTIPLYER < getHp()
                && getHp() < getMaxHp() / PyromancerConstants.OFFENSE_MAX_HP_MULTIPLYER) {
            setHp(Math.round(getHp()
                    - Math.round(getHp() / PyromancerConstants.OFFENSE_HP_MULTIPLYER)));
            setStrategyMultiplyer(getStrategyMultiplyer()
                    + PyromancerConstants.OFFENSE_DAMAGE_MULTIPLYER);
        } else {
            if (getHp() < getMaxHp() / PyromancerConstants.DEFENSE_MAX_HP_MULTIPLYER) {
                setHp(Math.round(getHp()
                        + Math.round(getHp() / PyromancerConstants.DEFENSE_HP_MULTIPLYER)));
                setStrategyMultiplyer(getStrategyMultiplyer()
                        + PyromancerConstants.DEFENSE_DAMAGE_MULTIPLYER);
            }
        }
    }
}
