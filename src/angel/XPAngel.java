/*
 * XPAngel.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package angel;

import constants.XPAngelConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class XPAngel extends Angel {
    public XPAngel() {
        super();
        setAngelType(AngelType.XPAngel);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.XPAngel);
        knight.addXp(XPAngelConstants.XPANGEL_ON_KNIGHT);
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.XPAngel);
        pyromancer.addXp(XPAngelConstants.XPANGEL_ON_PYROMANCER);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.XPAngel);
        wizard.addXp(XPAngelConstants.XPANGEL_ON_WIZARD);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.XPAngel);
        rogue.addXp(XPAngelConstants.XPANGEL_ON_ROGUE);
        super.interactWith(rogue);
    }
}
