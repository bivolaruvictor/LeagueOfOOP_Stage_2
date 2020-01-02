package angel;

import constants.DarkAngelConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DarkAngel extends Angel {
    public DarkAngel() {
        super();
        setAngelType(AngelType.DarkAngel);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHp(knight.getHp() - DarkAngelConstants.DARK_ANGEL_ON_KNIGHT);
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() - DarkAngelConstants.DARK_ANGEL_ON_PYROMANCER);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHp(wizard.getHp() - DarkAngelConstants.DARK_ANGEL_ON_WIZARD);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHp(rogue.getHp() - DarkAngelConstants.DARK_ANGEL_ON_ROGUE);
        super.interactWith(rogue);
    }
}
