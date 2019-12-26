package abilities;

import main.GameMap;
import player.Player;

public abstract class Ability implements Visitor {
    private AbilityFactory abilityFactory;
    private int baseDamage;
    private int damage;
    private float landModifier;
    private float raceModifier;
    private AbilityType abilityType;
    private Integer casterLevel;
    private GameMap gameMap = GameMap.getInstance();


    public Ability(final Player player) {
        landModifier = 1.0f;
        raceModifier = 1.0f;
    }
    /**/
    public int getDamage() {
        return damage;
    }
    /**/
    public float getLandModifier() {
        return landModifier;
    }
    /**/
    public float getRaceModifier() {
        return raceModifier;
    }
    /**/
    public int getBaseDamage() {
        return baseDamage;
    }
    /**/
    public AbilityType getAbilityType() {
        return abilityType;
    }
    /**/
    public Integer getCasterLevel() {
        return casterLevel;
    }
    /**/
    public GameMap getGameMap() {
        return gameMap;
    }
    /**/
    public AbilityFactory getAbilityFactory() {
        return abilityFactory;
    }
    /**/
    public void setAbilityFactory(final AbilityFactory abilityFactory) {
        this.abilityFactory = abilityFactory;
    }
    /**/
    public void setDamage(final int damage) {
        this.damage = damage;
    }
    /**/
    public void setLandModifier(final float landModifier) {
        this.landModifier = landModifier;
    }
    /**/
    public void setRaceModifier(final float raceModifier) {
        this.raceModifier = raceModifier;
    }
    /**/
    public void setAbilityType(final AbilityType abilityType) {
        this.abilityType = abilityType;
    }
    /**/
    public void setBaseDamage(final int baseDamage) {
        this.baseDamage = baseDamage;
    }
    /**/
    public void setCasterLevel(final Integer casterLevel) {
        this.casterLevel = casterLevel;
    }
    /**/
    public void hurt(final Player player) {
        player.setRecievedDamage(getDamage());
    }
}
