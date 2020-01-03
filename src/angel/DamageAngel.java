package angel;

import constants.DamageAngelConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DamageAngel extends Angel {
    public DamageAngel() {
        super();
        setAngelType(AngelType.DamageAngel);
    }

    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.DamageAngel);
        knight.setHelperMultiplyer(knight.getHelperMultiplyer()
                + DamageAngelConstants.DAMAGE_ANGEL_ON_KNIGHT);
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.DamageAngel);
        pyromancer.setHelperMultiplyer(pyromancer.getHelperMultiplyer()
                + DamageAngelConstants.DAMAGE_ANGEL_ON_PYROMANCER);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.DamageAngel);
        wizard.setHelperMultiplyer(wizard.getHelperMultiplyer()
                + DamageAngelConstants.DAMAGE_ANGEL_ON_WIZARD);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.DamageAngel);
        rogue.setHelperMultiplyer(rogue.getHelperMultiplyer()
                + DamageAngelConstants.DAMAGE_ANGEL_ON_ROGUE);
        super.interactWith(rogue);
    }
}
