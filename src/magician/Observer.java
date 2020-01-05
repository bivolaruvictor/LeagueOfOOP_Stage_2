/*
 * Observer.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package magician;

import angel.Angel;

import player.Player;

public interface Observer {
    void update(Player player);
    void update(Angel angel);
}
