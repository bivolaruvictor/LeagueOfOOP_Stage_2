package angel;

import abilities.Visitor;
import magician.Magician;
import player.*;

public class Angel implements Visitor {
    private AngelType angelType;
    private int xCoordinate;
    private int yCoordinate;

    public Angel() {
    }

    /**/
    public AngelType getAngelType() {
        return angelType;
    }
    /**/
    public int getxCoordinate() {
        return xCoordinate;
    }
    /**/
    public int getyCoordinate() {
        return yCoordinate;
    }
    /**/
    public void setAngelType(final AngelType angelType) {
        this.angelType = angelType;
    }
    /**/
    public void setxCoordinate(final int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    /**/
    public void setyCoordinate(final int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    /**/
    public void setPosition(final int x, final int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
    @Override
    /**/
    public String toString() {
        return "Angel{" + "angelType=" + angelType
                + ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + '}';
    }

    @Override
    public void interactWith(final Knight knight) {
        Magician.getInstance().update(knight);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        Magician.getInstance().update(pyromancer);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        Magician.getInstance().update(wizard);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        Magician.getInstance().update(rogue);
    }
}
