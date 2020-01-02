package angel;

import constants.DraculaConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Dracula extends Angel {
    public Dracula() {
        super();
        setAngelType(AngelType.Dracula);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.Dracula);
        knight.setHp(knight.getHp() - DraculaConstants.DRACULA_ON_KNIGHT_HP);
        knight.setHelperMultiplyer(DraculaConstants.DRACULA_ON_KNIGHT_DAMAGE);
        System.out.println(knight.getHelperMultiplyer());
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.Dracula);
        pyromancer.setHp(pyromancer.getHp() - DraculaConstants.DRACULA_ON_PYROMANCER_HP);
        pyromancer.setHelperMultiplyer(DraculaConstants.DRACULA_ON_PYROMANCER_DAMAGE);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.Dracula);
        wizard.setHp(wizard.getHp() - DraculaConstants.DRACULA_ON_WIZARD_HP);
        wizard.setHelperMultiplyer(DraculaConstants.DRACULA_ON_WIZARD_DAMAGE);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.Dracula);
        rogue.setHp(rogue.getHp() - DraculaConstants.DRACULA_ON_ROGUE_HP);
        rogue.setHelperMultiplyer(DraculaConstants.DRACULA_ON_ROGUE_DAMAGE);
        super.interactWith(rogue);
    }
}
