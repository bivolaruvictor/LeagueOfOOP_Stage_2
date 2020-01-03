package magician;

import angel.Angel;
import angel.AngelType;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public final class Magician implements Observer {
    private String observations;
    private List<Player> observed;
    private Magician() {
        observed = new ArrayList<>();
        observations = "";
    }
    private static Magician singleInstance = null;
    public static Magician getInstance() {
        if (singleInstance == null) {
            singleInstance = new Magician();
        }
        return singleInstance;
    }
    /**/
    public List<Player> getObserved() {
        return observed;
    }
    /**/
    public void setObserved(final List<Player> observed) {
        this.observed = observed;
    }
    /**/
    public String getObservations() {
        return observations;
    }
    /**/
    public void setObservations(final String observations) {
        this.observations = observations;
    }
    /*La final updatez "baza de date"*/
    @Override
    public void update(final Player player) {
        Player dummy = getObserved().get(player.getId());
        if (player.getKilledBy() != null) {
            dummy.setKilledBy(player.getKilledBy());
            updateKilledBy(player);
            player.setKilledBy(null);
        }
        if (player.isHelpedBy() != null) {
            dummy.setHelpedBy(player.isHelpedBy());
            updateHelpedBy(player);
        }
        if (dummy.getLevel() != player.getLevel()) {
            int howMany = player.getLevel() - dummy.getLevel();
            dummy.setLevel(player.getLevel());
            updateLevelUp(player, howMany);
        }
    }
    /**/
    public void updateLevelUp(final Player player, final int howMany) {
        for (int i = howMany - 1; i >= 0; --i) {
            setObservations(getObservations() + player.getTypeString() + " "
                    + player.getId() + " reached level " + (player.getLevel() - i) + "\n");
        }
    }
    /**/
    public void updateKilledBy(final Player player) {
        if (player.getKilledBy() != null) {
            setObservations(getObservations() + "Player " + player.getTypeString() + " "
                    + player.getId() + " was killed by " + player.getKilledBy().getTypeString()
                    + " " + player.getKilledBy().getId() + "\n");
        }
    }
    /**/
    public void updateHelpedBy(final Player player) {
        if (player.isHelpedBy().equals(AngelType.TheDoomer)) {
            setObservations(getObservations() + "TheDoomer hit " + player.getTypeString() + " "
                    + player.getId() + "\n" + "Player " + player.getTypeString()
                    + " " + player.getId() + " was killed by an angel" + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.Spawner)) {
            setObservations(getObservations() + "Spawner helped " + player.getTypeString() + " "
                    + player.getId() + "\n" + "Player " + player.getTypeString()
                    + " " + player.getId() + " was brought to life by an angel" + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.DamageAngel)) {
            setObservations(getObservations() + "DamageAngel helped " + player.getTypeString() + " "
                    + player.getId() + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.Dracula)) {
            setObservations(getObservations() +  "Dracula hit " + player.getTypeString() + " "
                    + player.getId() + "\n");
            if (!player.isAlive()) {
                setObservations(getObservations() + "Player " + player.getTypeString()
                        + " " + player.getId() + " was killed by an angel" + "\n");
            }
        }
        if (player.isHelpedBy().equals(AngelType.XPAngel)) {
            setObservations(getObservations() +  "XPAngel helped " + player.getTypeString() + " "
                    + player.getId() + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.SmallAngel)) {
            setObservations(getObservations() + "SmallAngel helped " + player.getTypeString() + " "
                    + player.getId() + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.GoodBoy)) {
            setObservations(getObservations() + "GoodBoy helped " + player.getTypeString() + " "
                    + player.getId() + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.LifeGiver)) {
            setObservations(getObservations() + "LifeGiver helped " + player.getTypeString() + " "
                    + player.getId() + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.LevelUpAngel)) {
            setObservations(getObservations() + "LevelUpAngel helped "
                    + player.getTypeString() + " " + player.getId() + "\n");
        }
        if (player.isHelpedBy().equals(AngelType.DarkAngel)) {
            setObservations(getObservations() + "DarkAngel hit "
                    + player.getTypeString() + " " + player.getId() + "\n");
        }
    }
    /**/
    @Override
    public void update(final Angel angel) {
        setObservations(getObservations() + "Angel " + angel.getAngelType() + " was spawned at "
                + angel.getxCoordinate() + " " + angel.getyCoordinate() + "\n");
    }
}
