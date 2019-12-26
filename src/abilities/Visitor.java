package abilities;

import player.Knight;
import player.Rogue;
import player.Pyromancer;
import player.Wizard;

public interface Visitor {
    void interactWith(Knight knight);
    void interactWith(Pyromancer pyromancer);
    void interactWith(Wizard wizard);
    void interactWith(Rogue rogue);
}
