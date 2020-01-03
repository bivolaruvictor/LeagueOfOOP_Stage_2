package angel;

import constants.SpawnerConstants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Spawner extends Angel {
    public Spawner() {
        super();
        setAngelType(AngelType.Spawner);
    }
    /**/
    @Override
    public void interactWith(final Knight knight) {
        knight.setHelpedBy(AngelType.Spawner);
        knight.respawned();
        knight.setHp(SpawnerConstants.SPAWNER_ON_KNIGHT);
        super.interactWith(knight);
    }
    /**/
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHelpedBy(AngelType.Spawner);
        pyromancer.respawned();
        pyromancer.setHp(SpawnerConstants.SPAWNER_ON_PYROMANCER);
        super.interactWith(pyromancer);
    }
    /**/
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHelpedBy(AngelType.Spawner);
        wizard.respawned();
        wizard.setHp(SpawnerConstants.SPAWNER_ON_WIZARD);
        super.interactWith(wizard);
    }
    /**/
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHelpedBy(AngelType.Spawner);
        rogue.respawned();
        rogue.setHp(SpawnerConstants.SPAWNER_ON_ROGUE);
        super.interactWith(rogue);
    }
}
