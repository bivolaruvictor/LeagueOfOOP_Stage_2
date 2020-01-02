package angel;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer() {
        super();
        setAngelType(AngelType.TheDoomer);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.doomed();
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.doomed();
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.doomed();
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.doomed();
        super.interactWith(rogue);
    }
}
