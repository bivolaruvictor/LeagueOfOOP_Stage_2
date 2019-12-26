package main;
import player.Player;

import java.util.List;

public class Input {

    private List<Player> players;
    private int numberOfRounds;

    public Input() {
        players = null;
        numberOfRounds = -1;
    }

    public Input(final List<Player> players, final int numberOfRounds) {
        this.players = players;
        this.numberOfRounds = numberOfRounds;
    }

    /**/
    public List<Player> getPlayers() {
        return players;
    }

    /**/
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = players != null;
        boolean membersNotEmpty = players.size() > 0 && getNumberOfRounds() >= 0;
        return membersInstantiated && membersNotEmpty;
    }
}
