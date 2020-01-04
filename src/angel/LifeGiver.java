package angel;

import constants.LifeGiverConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LifeGiver extends Angel {
    public LifeGiver() {
        super();
        setAngelType(AngelType.LifeGiver);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.LifeGiver);
        knight.setHp(Math.min(
                knight.getHp() + LifeGiverConstants.LIFE_GIVER_ON_KNIGHT, knight.getMaxHp()));
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.LifeGiver);
        pyromancer.setHp(Math.min(
                pyromancer.getHp()
                        + LifeGiverConstants.LIFE_GIVER_ON_PYROMANCER, pyromancer.getMaxHp()));
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.LifeGiver);
        wizard.setHp(Math.min(
                wizard.getHp() + LifeGiverConstants.LIFE_GIVER_ON_WIZARD, wizard.getMaxHp()));
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.LifeGiver);
        rogue.setHp(Math.min(
                rogue.getHp() + LifeGiverConstants.LIFE_GIVER_ON_ROGUE, rogue.getMaxHp()));
        super.interactWith(rogue);
    }
}
