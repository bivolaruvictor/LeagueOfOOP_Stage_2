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
        knight.setStrategyMultiplyer(LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_KNIGHT);
        knight.setLevelAngel();
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.LevelUpAngel);
        pyromancer.setStrategyMultiplyer(LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_PYROMANCER);
        pyromancer.setLevelAngel();
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.LevelUpAngel);
        wizard.setStrategyMultiplyer(LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_WIZARD);
        wizard.setLevelAngel();
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.LevelUpAngel);
        rogue.setStrategyMultiplyer(LevelUpAngelConstants.LEVEL_UP_ANGEL_ON_ROGUE);
        rogue.setLevelAngel();
        super.interactWith(rogue);
    }
}
