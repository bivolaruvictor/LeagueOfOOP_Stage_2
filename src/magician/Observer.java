package magician;

import angel.Angel;

import player.Player;

public interface Observer {
    void update(Player player);
    void update(Angel angel);
}
