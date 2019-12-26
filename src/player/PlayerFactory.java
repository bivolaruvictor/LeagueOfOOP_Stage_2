package player;

public class PlayerFactory {
    /**/
    public Player getPlayerType(final PlayerType playerType) {
        if (playerType == null) {
            return null;
        }
        if (playerType.equals(PlayerType.pyromancer)) {
            return new Pyromancer();
        }
        if (playerType.equals(PlayerType.knight)) {
            return new Knight();
        }
        if (playerType.equals(PlayerType.wizard)) {
            return new Wizard();
        }
        if (playerType.equals(PlayerType.rogue)) {
            return new Rogue();
        }
        return null;
    }
}
