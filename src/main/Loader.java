package main;
import angel.Angel;
import angel.AngelFactory;
import angel.AngelType;
import fileio.FileSystem;
import magician.Magician;
import player.Player;
import player.PlayerFactory;
import player.PlayerType;
import terrain.Terrain;
import terrain.TerrainFactory;
import terrain.TerrainType;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    private final String mInputPath;
    private final String mOutputPath;

    public Loader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }
    /**/
    public Input load() {
        PlayerFactory playerFactory = new PlayerFactory();
        TerrainFactory terrainFactory = new TerrainFactory();
        AngelFactory angelFactory = new AngelFactory();
        List<Player> players = new ArrayList<Player>();
        List<List<Angel>> angels = new ArrayList<>();
        List<Terrain> terrains = new ArrayList<>();
        GameMap gamemap = new GameMap();
        int noRows = 0;
        int noColumns = 0;
        int noPlayers = 0;
        int noAngels = 0;
        int noRounds = 0;
        String pType = null;
        String aType = null;
        PlayerType playerType = null;
        AngelType angelType = null;
        int initialXCoordinate = -1;
        int initialYCoordinate = -1;
        int angelXCoordinate = -1;
        int angelYCoordinate = -1;
        String move = null;
        String terrain = null;
        String tType = null;
        TerrainType terrainType = null;


        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            noRows = fs.nextInt();
            noColumns = fs.nextInt();
            GameMap gameMap = GameMap.getInstance(noRows, noColumns);
            Magician grandMagician = Magician.getInstance();

            for (int i = 0; i < noRows; ++i) {
                tType = fs.nextWord();

                for (int j = 0; j < noColumns; ++j) {
                    Terrain dummy = terrainFactory.getTerrainType(checkTerrain(tType.charAt(j)));
                    terrains.add(dummy);
                    gameMap.getMap().get(i).add(dummy);
                }
            }

            noPlayers = fs.nextInt();

            for (int i = 0; i < noPlayers; ++i) {
                pType = fs.nextWord();
                initialXCoordinate = fs.nextInt();
                initialYCoordinate = fs.nextInt();
                Player dummy = playerFactory.getPlayerType(checkPlayer(pType));
                dummy.setStartingPosition(initialXCoordinate, initialYCoordinate);
                dummy.setId(i);
                players.add(dummy);
                Player observed = playerFactory.getPlayerType(checkPlayer(pType));
                observed.setStartingPosition(initialXCoordinate, initialYCoordinate);
                observed.setId(i);
                Magician.getInstance().getObserved().add(observed);
            }

            noRounds = fs.nextInt();

            for (int i = 0; i < noRounds; ++i) {
                move = fs.nextWord();
                for (int j = 0; j < noPlayers; ++j) {
                    players.get(j).addMove(move.charAt(j));
                }
            }
            for (int i = 0; i < noRounds; ++i) {
                noAngels = fs.nextInt();
                List<Angel> angelsToAdd = new ArrayList<>();
                if (noAngels != 0) {
                    for (int j = 0; j < noAngels; ++j) {
                        String buff = fs.nextWord();
                        String[] result = buff.split(",");
                        aType = result[0];
                        String x = result[1];
                        String y = result[2];
                        angelXCoordinate = x.charAt(0) - '0';
                        angelYCoordinate = y.charAt(0) - '0';
                        Angel dummy = angelFactory.getAngelType(checkAngel(aType));
                        dummy.setPosition(angelXCoordinate, angelYCoordinate);
                        angelsToAdd.add(dummy);
                    }
                    angels.add(angelsToAdd);
                } else {
                    angels.add(null);
                }
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return new Input(players, noRounds, angels);
    }

    /**/
    public TerrainType checkTerrain(final char terrain) {
        switch (terrain) {
            case ('V') :
                return TerrainType.volcanic;
            case ('L') :
                return TerrainType.land;
            case ('W') :
                return TerrainType.woods;
            case ('D') :
                return TerrainType.dessert;
            default:
                return null;
        }
    }
    /**/
    public PlayerType checkPlayer(final String player) {
        switch (player) {
            case ("K") :
                return PlayerType.knight;
            case ("P") :
                return PlayerType.pyromancer;
            case ("W") :
                return PlayerType.wizard;
            case ("R") :
                return PlayerType.rogue;
            default:
                return null;
        }
    }
    /**/
    public AngelType checkAngel(final String angel) {
        switch (angel) {
            case("DamageAngel"):
                return AngelType.DamageAngel;
            case("DarkAngel"):
                return AngelType.DarkAngel;
            case("Dracula"):
                return AngelType.Dracula;
            case("GoodBoy"):
                return AngelType.GoodBoy;
            case("LevelUpAngel"):
                return AngelType.LevelUpAngel;
            case("LifeGiver"):
                return AngelType.LifeGiver;
            case("SmallAngel"):
                return AngelType.SmallAngel;
            case("Spawner"):
                return AngelType.Spawner;
            case("TheDoomer"):
                return  AngelType.TheDoomer;
            case("XPAngel"):
                return AngelType.XPAngel;
            default:
               return null;
        }
    }
}
