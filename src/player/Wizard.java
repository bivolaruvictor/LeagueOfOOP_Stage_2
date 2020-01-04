package player;

import abilities.AbilityType;
import abilities.Deflect;
import abilities.Drain;
import constants.LandMultipliers;
import constants.WizardConstants;
import abilities.Visitor;

public class Wizard extends Player {
    public Wizard() {
        super();
        setType(PlayerType.wizard);
        setHp(WizardConstants.WIZARD_STARTING_HP);
        setTerrainBonus(LandMultipliers.DESERT_MULTIPLIER);
    }
    /**/
    @Override
    public int getMaxHp() {
        return WizardConstants.WIZARD_STARTING_HP
                + WizardConstants.WIZARD_HP_PER_LEVEL * getLevel();
    }
    /**/
    public void accept(final Visitor ability) {
        ability.interactWith(this);
    }
    /**/
    public void fightPlayer(final Player player) {
        this.setBruteDamage(player.getBruteDamage());
        Drain drain = (Drain) getAbilityFactory().getAbilityType(AbilityType.drain, player);
        drain.setStrategyMultiplyer(getStrategyMultiplyer());
        drain.setHelperModifier(getHelperMultiplyer());
        player.accept(drain);
        player.recieveDamage();
        System.out.println(player.typeToString() + " " + player.getId()
                + " got drain " + player.getRecievedDamage());
        Deflect deflect = (Deflect) getAbilityFactory().getAbilityType(AbilityType.deflect, player);
        deflect.setStrategyMultiplyer(getStrategyMultiplyer());
        deflect.setHelperModifier(getHelperMultiplyer());
        player.accept(deflect);
        player.recieveDamage();
        System.out.println(player.typeToString() + " " + player.getId()
                + " got deflect " + player.getRecievedDamage());
        System.out.println();
        super.fightPlayer(player);
    }
    /**/
    public void setStrategy() {
        if (getMaxHp() / WizardConstants.OFFENSE_MIN_HP_MULTIPLYER < getHp()
                && getHp() < getMaxHp() / WizardConstants.OFFENSE_MAX_HP_MULTIPLYER) {
            setHp(getHp() - getHp() / WizardConstants.OFFENSE_HP_MULTIPLYER);
            setStrategyMultiplyer(WizardConstants.OFFENSE_DAMAGE_MULTIPLYER);
        } else {
            if (getHp() < getMaxHp() / WizardConstants.DEFENSE_MAX_HP_MULTIPLYER) {
                setHp(getHp() + getHp() / WizardConstants.DEFENSE_HP_MULTIPLYER);
                setStrategyMultiplyer(WizardConstants.DEFENSE_DAMAGE_MULTIPLYER);
            } else {
                setStrategyMultiplyer(0f);
            }
        }
    }
}
