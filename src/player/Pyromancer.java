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
        Fireblast fireblast = (Fireblast) getAbilityFactory()
                .getAbilityType(AbilityType.fireblast, player);
        fireblast.setStrategyMultiplyer(getStrategyMultiplyer());
        fireblast.setHelperModifier(getHelperMultiplyer());
        player.accept(fireblast);
        player.recieveDamage();
        System.out.println(player.toString() + " fireblast " + player.getRecievedDamage());

        Ignite ignite = (Ignite) getAbilityFactory().getAbilityType(AbilityType.ignite, player);
        ignite.setStrategyMultiplyer(getStrategyMultiplyer());
        ignite.setHelperModifier(getHelperMultiplyer());
        player.accept(ignite);
        player.recieveDamage();
        System.out.println(player.toString() + " ignite " + player.getRecievedDamage());

        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
}
