package player;

import abilities.AbilityFactory;
import abilities.Visitor;
import angel.Angel;
import angel.AngelType;
import constants.PlayerConstants;
import magician.Magician;
import magician.Observer;
import main.GameMap;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Visitable {
    private int id;
    private int round;
    private int hp;
    private PlayerType type;
    private int xp;
    private int level;
    private int xCoordinate;
    private int yCoordinate;
    private List<Character> moves;
    private Float terrainBonus;
    private Float raceBonus;
    private GameMap gameMap = GameMap.getInstance();
    private int recievedDamage;
    private int overtimeRounds;
    private int overtimeDamage;
    private int block;
    private AbilityFactory abilityFactory;
    private boolean isAlive;
    private int bruteDamage;
    private float strategyMultiplyer;
    private float helperMultiplyer;
    private ArrayList<Observer> observers;
    private boolean isDoomed;
    private AngelType helpedBy;
    private Player killedBy;
    private boolean showedKilled;
    Player() {
        round = 0;
        xp = 0;
        level = 0;
        xCoordinate = -1;
        yCoordinate = -1;
        moves = new ArrayList<>();
        terrainBonus = 1.0f;
        raceBonus = 1.0f;
        recievedDamage = 0;
        block = 0;
        abilityFactory = new AbilityFactory();
        isAlive = true;
        overtimeRounds = 0;
        overtimeDamage = 0;
        strategyMultiplyer = 0f;
        helpedBy = null;
        killedBy = null;
        showedKilled = false;
    }
    /**/
    public boolean isShowedKilled() {
        return showedKilled;
    }
    /**/
    public void setShowedKilled(final boolean showedKilled) {
        this.showedKilled = showedKilled;
    }
    /**/
    public Player getKilledBy() {
        return killedBy;
    }
    /**/
    public void setKilledBy(final Player killedBy) {
        this.killedBy = killedBy;
    }
    /**/
    public int getId() {
        return id;
    }
    /**/
    public void setId(final int id) {
        this.id = id;
    }
    /**/
    public AngelType isHelpedBy() {
        return helpedBy;
    }
    /**/
    public void setHelpedBy(final AngelType helpedBy) {
        this.helpedBy = helpedBy;
    }
    /**/
    public float getHelperMultiplyer() {
        return helperMultiplyer;
    }
    /**/
    public void setHelperMultiplyer(final float helperMultiplyer) {
        this.helperMultiplyer = helperMultiplyer;
    }
    /**/
    public void resetHelperMultiplyer() {
        helperMultiplyer = 0f;
    }
    /**/
    public void addObserver() {
        observers.add(Magician.getInstance());
    }
    /**/
    public AbilityFactory getAbilityFactory() {
        return abilityFactory;
    }
    /**/
    public void setType(final PlayerType type) {
        this.type = type;
    }
    /**/
    public void setHp(final int hp) {
        if (hp > 0) {
            this.hp = hp;
        } else {
            this.hp = hp;
            isDead();
        }
    }
    /**/
    public void setLevel(final int level) {
        this.level = level;
    }
    /**/
    public void setXp(final int xp) {
        this.xp = xp;
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
    public void setStartingPosition(final int x, final int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    /**/
    public void setTerrainBonus(final Float terrainBonus) {
    }
    /**/
    public void setRecievedDamage(final int recievedDamage) {
        this.recievedDamage = recievedDamage;
    }
    /**/
    public void setOvertimeRounds(final int overtimeRounds) {
        this.overtimeRounds = overtimeRounds;
    }
    /**/
    public void setOvertimeDamage(final int overtimeDamage) {
        this.overtimeDamage = overtimeDamage;
    }
    /**/
    public void setBlock(final int block) {
        this.block = block;
    }
    /**/
    public void setRound(final int round) {
        this.round = round;
    }
    /**/
    public boolean isAlive() {
        return isAlive;
    }
    /**/
    void isDead() {
        isAlive = false;
    }
    /**/
    public void setAlive(final boolean alive) {
        isAlive = alive;
    }
    /**/
    public void respawned() {
        isAlive = true;
    }
    /**/
    public Float getRaceBonus() {
        return raceBonus;
    }
    /**/
    public void setRaceBonus(final Float raceBonus) {
        this.raceBonus = raceBonus;
    }
    /**/
    public int getBruteDamage() {
        return bruteDamage;
    }
    /**/
    public void setBruteDamage(final int bruteDamage) {
        this.bruteDamage = bruteDamage;
    }
    /**/
    public void addMove(final Character movement) {
        getMoves().add(movement);
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
    public List<Character> getMoves() {
        return moves;
    }

    /**/
    public PlayerType getType() {
        return type;
    }
    /**/
    public String getTypeString() {
        if (getType().equals(PlayerType.knight)) {
            return "Knight";
        } else {
            if (getType().equals(PlayerType.pyromancer)) {
                return "Pyromancer";
            } else {
                if (getType().equals(PlayerType.wizard)) {
                    return "Wizard";
                } else {
                    if (getType().equals(PlayerType.rogue)) {
                        return "Rogue";
                    }
                }
            }
        }
        return null;
    }
    /**/
    public int getHp() {
        return hp;
    }
    /**/
    public int getMaxHp() {
        return 0;
    }
    /**/
    public int getXp() {
        return xp;
    }
    /**/
    public int getLevel() {
        return level;
    }
    /**/
    public Float getTerrainBonus() {
        return terrainBonus;
    }
    /**/
    public int getRecievedDamage() {
        return recievedDamage;
    }
    /**/
    public int getOvertimeRounds() {
        return overtimeRounds;
    }
    /**/
    public int getOvertimeDamage() {
        return overtimeDamage;
    }
    /*block este parametrul care dicteaza cate runde de "stat pe bara" mai are*/
    public int getBlock() {
        return block;
    }
    /**/
    public int getRound() {
        return round;
    }
    /**/
    public String typeToString() {
        switch (getType()) {
            case knight :
                return "K";
            case pyromancer:
                return "P";
            case wizard :
                return "W";
            case rogue :
                return "R";
            default :
                return null;
        }
    }
    /**/
    public void accept(final Visitor visitor) {
    }
    /*Se poate bate cu un jucator doar daca au aceleasi coordonate*/
    public boolean fight(final Player player) {
        if (this.getxCoordinate() == player.getxCoordinate()
        && this.getyCoordinate() == player.getyCoordinate()) {
            return true;
        }
        return false;
    }
    /*Conditiile suplimentare sunt puse ca in cazul in care un jucator care nu este wizard
    * se intalneste cu un wizard sa atace el primul, pentru ca altfel wizard nu are la ce sa
    * dea deflect*/
    public void simulateFight(final Player attacked) {
        if (this.fight(attacked) && this.isAlive() && attacked.isAlive()) {
            if (this.getType().equals(PlayerType.wizard)
                    && !attacked.getType().equals(PlayerType.wizard)) {
                attacked.fightPlayer(this);
                this.fightPlayer(attacked);
            } else {
                this.fightPlayer(attacked);
                attacked.fightPlayer(this);
            }
            /* Se adauga Xp celui care isi omoara adversarul
            * Este astfel acoperit si cazul mortii simultane*/
            if (!attacked.isAlive && !this.isAlive) {
                attacked.setKilledBy(this);
                this.setKilledBy(attacked);
                Magician.getInstance().update(attacked);
                Magician.getInstance().update(this);
            } else {
                if (!attacked.isAlive()) {
                    this.addKilledXp(attacked);
                    attacked.setKilledBy(this);
                    Magician.getInstance().update(attacked);
                    Magician.getInstance().update(this);
                } else {
                    if (!this.isAlive()) {
                        attacked.addKilledXp(this);
                        this.setKilledBy(attacked);
                        Magician.getInstance().update(this);
                        Magician.getInstance().update(attacked);
                    } else {
                        Magician.getInstance().update(this);
                        Magician.getInstance().update(attacked);
                    }
                }
            }
        }
    }
    /**/
    public void fightPlayer(final Player player) {
        if (player.getHp() <= 0) {
            player.isDead();
        }
    }
    /*Calculez xp ul ce trebuie dat invingatorului, si i-l dau*/
    public void addKilledXp(final Player player) {
        addXp(Math.max(0, (PlayerConstants.XP_WINNING_BASE
                - (this.getLevel() - player.getLevel()) * PlayerConstants.XP_WINNING_MULTIPLYER)));
    }
    /**/
    public void movePlayer() {
        /*Pentru cazul in care nu trebuie sa stea pe bara
        * alfel se trece peste miscarea curenta*/
        if (getBlock() == 0) {
            switch (getMoves().get(getRound())) {
                case ('U'):
                    setxCoordinate(getxCoordinate() - 1);
                    break;
                case ('D'):
                    setxCoordinate(getxCoordinate() + 1);
                    break;
                case ('L'):
                    setyCoordinate(getyCoordinate() - 1);
                    break;
                case ('R'):
                    setyCoordinate(getyCoordinate() + 1);
                    break;
                case ('_'):
                    break;
                default:
                    break;
            }
        } else {
            setBlock(getBlock() - 1);
        }
    }
    /**/
    public void recieveDamage() {
        setHp(getHp() - getRecievedDamage());
    }
    /*Daca are overtime damage, il primeste*/
    public void recieveOvertimeDamage() {
        if (getOvertimeRounds() > 0) {
            setHp(getHp() - getOvertimeDamage());
            setOvertimeRounds(getOvertimeRounds() - 1);
        }
    }
    /**/
    public void addXp(final int xP) {
        setXp(getXp() + xP);
        levelUp();
    }
    /**/
    public void levelUp() {
        if (this.helpedBy != AngelType.LevelUpAngel) {
            int oldLevel = getLevel();
            int newLevel = (getXp() - PlayerConstants.XP_LEVEL_UP_BASE);
            if (newLevel >= 0) {
                newLevel = newLevel / PlayerConstants.XP_LEVEL_UP_MULTIPLYER + 1;
                if (newLevel != oldLevel) {
                    setLevel(newLevel);
                    setHp(getMaxHp());
                }
            }
        } else {
            setXp(PlayerConstants.XP_LEVEL_UP_BASE + getLevel()
                    * PlayerConstants.XP_LEVEL_UP_MULTIPLYER);
            setLevel(getLevel() + 1);
            setHp(getMaxHp());
        }
    }
    /**/
    public String alive() {
        if (isAlive()) {
            return "alive";
        }
        return "dead";
    }
    /**/
    public void setStrategy() {
    }
    /**/
    public float getStrategyMultiplyer() {
        return strategyMultiplyer;
    }
    /**/
    public void setStrategyMultiplyer(final float strategyMultiplyer) {
        this.strategyMultiplyer = strategyMultiplyer;
    }
    /**/
    public void resetStrategyMultiplyer() {
        this.strategyMultiplyer = 0f;
    }
    /**/
    public boolean canBeHelped(final Angel angel) {
        if (this.getxCoordinate() == angel.getxCoordinate()
                && this.getyCoordinate() == angel.getyCoordinate()) {
            return true;
        }
        return false;
    }
    /**/
    public void getHelp(final Angel angel) {
        if (canBeHelped(angel)) {
            this.accept(angel);
        }
    }
}
