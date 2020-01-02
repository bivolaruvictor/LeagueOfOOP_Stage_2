package angel;

public class AngelFactory {
    /**/
    public Angel getAngelType(final AngelType angelType) {
        if (angelType == null) {
            return null;
        }
        if (angelType.equals(AngelType.DamageAngel)) {
            return new DamageAngel();
        }
        if (angelType.equals(AngelType.DarkAngel)) {
            return new DarkAngel();
        }
        if (angelType.equals(AngelType.Dracula)) {
            return new Dracula();
        }
        if (angelType.equals(AngelType.GoodBoy)) {
            return new GoodBoy();
        }
        if (angelType.equals(AngelType.LevelUpAngel)) {
            return new LevelUpAngel();
        }
        if (angelType.equals(AngelType.LifeGiver)) {
            return new LifeGiver();
        }
        if (angelType.equals(AngelType.XPAngel)) {
            return new XPAngel();
        }
        if (angelType.equals(AngelType.TheDoomer)) {
            return new TheDoomer();
        }
        if (angelType.equals(AngelType.Spawner)) {
            return new Spawner();
        }
        if (angelType.equals(AngelType.SmallAngel)) {
            return new SmallAngel();
        }
        return null;
    }
}
