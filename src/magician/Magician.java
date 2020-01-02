package magician;

import angel.Angel;
import angel.AngelType;
import player.Player;

public final class Magician implements Observer {
    private String updatedAngel;
    private String updatedPlayer;
    private Magician() {
        updatedPlayer = "";
        updatedAngel = "";
    }
    private static Magician singleInstance = null;
    public static Magician getInstance() {
        if (singleInstance == null) {
            singleInstance = new Magician();
        }
        return singleInstance;
    }
    /**/
    public String getUpdatedAngel() {
        return updatedAngel;
    }
    /**/
    public void setUpdatedAngel(final String updatedAngel) {
        this.updatedAngel = updatedAngel;
    }
    /**/
    public String getUpdatedPlayer() {
        return updatedPlayer;
    }
    /**/
    public void setUpdatedPlayer(final String updatedPlayer) {
        this.updatedPlayer = updatedPlayer;
    }
    /**/
    @Override
    public void update(final Player player) {
        if (player.getKilledBy() == null) {
            if (player.isHelpedBy().equals(AngelType.TheDoomer)) {
                setUpdatedPlayer("TheDoomer hit " + player.getTypeString() + " " + player.getId()
                        + "\n" + "Player " + player.getTypeString() + " " + player.getId()
                        + " was killed by an angel");
            }
            if (player.isHelpedBy().equals(AngelType.DamageAngel)) {
                setUpdatedPlayer("DamageAngel helped " + player.getTypeString() + " "
                        + player.getId());
            }
            if (player.isHelpedBy().equals(AngelType.Dracula)) {
                setUpdatedPlayer("Dracula hit " + player.getTypeString() + " "
                        + player.getId());
            }
            if (player.isHelpedBy().equals(AngelType.XPAngel)) {
                setUpdatedPlayer("XPAngel helped " + player.getTypeString() + " "
                        + player.getId());
            }
            if (player.isHelpedBy().equals(AngelType.SmallAngel)) {
                setUpdatedPlayer("SmallAngel helped " + player.getTypeString() + " "
                        + player.getId());
            }
            if (player.isHelpedBy().equals(AngelType.GoodBoy)) {
                setUpdatedPlayer("GoodBoy helped " + player.getTypeString() + " "
                        + player.getId());
            }
            if (player.isHelpedBy().equals(AngelType.LifeGiver)) {
                setUpdatedPlayer("LifeGiver helped " + player.getTypeString() + " "
                        + player.getId());
            }
            if (player.isHelpedBy().equals(AngelType.LevelUpAngel)) {
                setUpdatedPlayer("LevelUpAngel helped " + player.getTypeString() + " "
                        + player.getId());
            }
        }
//        else {
//            setUpdatedPlayer("Player " + player.getTypeString() + " "
//                    + player.getId() + " was killed by " + player.getKilledBy().getTypeString() + " "
//                    + player.getKilledBy().getId());
//        }
    }

    /**/
    @Override
    public void update(final Angel angel) {
        setUpdatedAngel("Angel " + angel.getAngelType() + " was spawned at "
                + angel.getxCoordinate() + " " + angel.getyCoordinate());
    }
}
