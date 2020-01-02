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
        knight.setHp(knight.getHp() + LifeGiverConstants.LIFE_GIVER_ON_KNIGHT);
        knight.setAlive(true);
        knight.setShowedKilled(false);
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.LifeGiver);
        pyromancer.setHp(pyromancer.getHp() + LifeGiverConstants.LIFE_GIVER_ON_PYROMANCER);
        pyromancer.setAlive(true);
        pyromancer.setShowedKilled(false);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.LifeGiver);
        wizard.setHp(wizard.getHp() + LifeGiverConstants.LIFE_GIVER_ON_WIZARD);
        wizard.setAlive(true);
        wizard.setShowedKilled(false);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.LifeGiver);
        rogue.setHp(rogue.getHp() + LifeGiverConstants.LIFE_GIVER_ON_ROGUE);
        rogue.setAlive(true);
        rogue.setShowedKilled(false);
        super.interactWith(rogue);
    }
}
