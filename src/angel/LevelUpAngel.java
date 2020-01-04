package angel;

import constants.LevelUpAngelConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LevelUpAngel extends Angel {
    public LevelUpAngel() {
        super();
        setAngelType(AngelType.LevelUpAngel);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.LevelUpAngel);
        knight.setHelperMultiplyer(knight.getHelperMultiplyer()
                + LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_KNIGHT);
        knight.levelUp();
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.LevelUpAngel);
        pyromancer.setHelperMultiplyer(pyromancer.getHelperMultiplyer()
                + LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_PYROMANCER);
        pyromancer.levelUp();
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.LevelUpAngel);
        wizard.setHelperMultiplyer(wizard.getHelperMultiplyer()
                + LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_WIZARD);
        wizard.levelUp();
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.LevelUpAngel);
        rogue.setHelperMultiplyer(rogue.getHelperMultiplyer()
                + LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_ROGUE);
        rogue.levelUp();
        super.interactWith(rogue);
    }
}
