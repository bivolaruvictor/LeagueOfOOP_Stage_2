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
        Drain drain = (Drain) getAbilityFactory().getAbilityType(AbilityType.drain, player);
        player.accept(drain);
        player.recieveDamage();
        Deflect deflect = (Deflect) getAbilityFactory().getAbilityType(AbilityType.deflect, player);
        player.accept(deflect);
        player.recieveDamage();
        this.setBruteDamage(player.getBruteDamage());
        super.fightPlayer(player);
    }
}
