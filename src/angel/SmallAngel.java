/*
 * SmallAngel.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package angel;

import constants.SmallAngelConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class SmallAngel extends Angel {
    public SmallAngel() {
        super();
        setAngelType(AngelType.SmallAngel);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.SmallAngel);
        knight.setStrategyMultiplyer(SmallAngelConstants.SMALL_ANGEL_ON_KNIGHT_DAMAGE);
        knight.setHp(knight.getHp() + SmallAngelConstants.SMALL_ANGEL_ON_KNIGHT_HP);
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.SmallAngel);
        pyromancer.setStrategyMultiplyer(SmallAngelConstants.SMALL_ANGEL_ON_PYROMANCER_DAMAGE);
        pyromancer.setHp(pyromancer.getHp() + SmallAngelConstants.SMALL_ANGEL_ON_PYROMANCER_HP);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.SmallAngel);
        wizard.setStrategyMultiplyer(SmallAngelConstants.SMALL_ANGEL_ON_WIZARD_DAMAGE);
        wizard.setHp(wizard.getHp() + SmallAngelConstants.SMALL_ANGEL_ON_WIZARD_HP);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.SmallAngel);
        rogue.setStrategyMultiplyer(SmallAngelConstants.SMALL_ANGEL_ON_ROGUE_DAMAGE);
        rogue.setHp(rogue.getHp() + SmallAngelConstants.SMALL_ANGEL_ON_ROGUE_HP);
        super.interactWith(rogue);
    }
}
