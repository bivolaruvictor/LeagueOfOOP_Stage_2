/*
 * Visitable.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package player;

import abilities.Visitor;

public interface Visitable {
    void accept(Visitor v);
}
