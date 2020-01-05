/*
 * GoodBoy.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package angel;

import constants.GoodBoyConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class GoodBoy extends Angel {
    public GoodBoy() {
        super();
        setAngelType(AngelType.GoodBoy);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.GoodBoy);
        knight.setHp(knight.getHp() + GoodBoyConstants.GOOD_BOY_ON_KNIGHT_HP);
        knight.setHelperMultiplyer(knight.getHelperMultiplyer()
                + GoodBoyConstants.GOOD_BOY_ON_KNIGHT_DAMAGE);
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.GoodBoy);
        pyromancer.setHp(pyromancer.getHp() + GoodBoyConstants.GOOD_BOY_ON_PYROMANCER_HP);
        pyromancer.setHelperMultiplyer(pyromancer.getHelperMultiplyer()
                + GoodBoyConstants.GOOD_BOY_ON_PYROMANCER_DAMAGE);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.GoodBoy);
        wizard.setHp(wizard.getHp() + GoodBoyConstants.GOOD_BOY_ON_WIZARD_HP);
        wizard.setHelperMultiplyer(wizard.getHelperMultiplyer()
                + GoodBoyConstants.GOOD_BOY_ON_WIZARD_DAMAGE);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.GoodBoy);
        rogue.setHp(rogue.getHp() + GoodBoyConstants.GOOD_BOY_ON_ROGUE_HP);
        rogue.setHelperMultiplyer(rogue.getHelperMultiplyer()
                + GoodBoyConstants.GOOD_BOY_ON_ROGUE_DAMAGE);
        super.interactWith(rogue);
    }
}
