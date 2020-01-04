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
        fireblast.setStrategyMultiplyer(getStrategyMultiplyer());
        fireblast.setHelperModifier(getHelperMultiplyer());
        player.accept(fireblast);
        player.recieveDamage();
        System.out.println(player.typeToString() + " " + player.getId()
                + " got fireblast " + player.getRecievedDamage());
        Ignite ignite = (Ignite) getAbilityFactory().getAbilityType(AbilityType.ignite, player);
        ignite.setStrategyMultiplyer(getStrategyMultiplyer());
        ignite.setHelperModifier(getHelperMultiplyer());
        player.accept(ignite);
        player.recieveDamage();
        System.out.println(player.typeToString() + " " + player.getId()
                + " got ignite " + player.getRecievedDamage());
        System.out.println();
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
