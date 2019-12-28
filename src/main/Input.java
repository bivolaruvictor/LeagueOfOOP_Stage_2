package main;
import angel.Angel;
import player.Player;

import java.util.List;

public class Input {

    private List<Player> players;
    private List<List<Angel>> angels;
    private int numberOfRounds;

    public Input() {
        players = null;
        numberOfRounds = -1;
        angels = null;
    }

    public Input(final List<Player> players, final int numberOfRounds,
                 final List<List<Angel>> angels) {
        this.players = players;
        this.numberOfRounds = numberOfRounds;
        this.angels = angels;
    }

    /**/
    public List<Player> getPlayers() {
        return players;
    }

    /**/
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    /**/
    public List<List<Angel>> getAngels() {
        return angels;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = players != null;
        boolean membersNotEmpty = players.size() > 0 && getNumberOfRounds() >= 0;
        return membersInstantiated && membersNotEmpty;
    }
}
