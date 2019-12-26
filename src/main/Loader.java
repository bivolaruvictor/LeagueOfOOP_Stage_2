package main;
import fileio.FileSystem;
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
        List<Player> players = new ArrayList<Player>();
        List<Terrain> terrains = new ArrayList<>();
        GameMap gamemap = new GameMap();
        int noRows = 0;
        int noColumns = 0;
        int noPlayers = 0;
        int noRounds = 0;
        String pType = null;
        PlayerType playerType = null;
        int initialXCoordinate = -1;
        int initialYCoordinate = -1;
        String move = null;
        String terrain = null;
        String tType = null;
        TerrainType terrainType = null;


        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            noRows = fs.nextInt();
            noColumns = fs.nextInt();
            GameMap gameMap = GameMap.getInstance(noRows, noColumns);
            for (int i = 0; i < noRows; ++i) {
                tType = fs.nextWord();
                for (int j = 0; j < noColumns; ++j) {
                    switch (tType.charAt(j)) {
                        case ('V') :
                            terrainType = TerrainType.volcanic;
                            break;
                        case ('L') :
                            terrainType = TerrainType.land;
                            break;
                        case ('W') :
                            terrainType = TerrainType.woods;
                            break;
                        case ('D') :
                            terrainType = TerrainType.dessert;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + tType);
                    }

                    Terrain dummy = terrainFactory.getTerrainType(terrainType);
                    terrains.add(dummy);
                    gameMap.getMap().get(i).add(dummy);
                }
            }

            noPlayers = fs.nextInt();

            for (int i = 0; i < noPlayers; ++i) {
                pType = fs.nextWord();
                initialXCoordinate = fs.nextInt();
                initialYCoordinate = fs.nextInt();

                switch (pType) {
                    case ("K") :
                        playerType = PlayerType.knight;
                        break;
                    case ("P") :
                        playerType = PlayerType.pyromancer;
                        break;
                    case ("W") :
                        playerType = PlayerType.wizard;
                        break;
                    case ("R") :
                        playerType = PlayerType.rogue;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + pType);
                }

                Player dummy = playerFactory.getPlayerType(playerType);
                dummy.setStartingPosition(initialXCoordinate, initialYCoordinate);
                players.add(dummy);
            }

            noRounds = fs.nextInt();

            for (int i = 0; i < noRounds; ++i) {
                move = fs.nextWord();
                for (int j = 0; j < noPlayers; ++j) {
                    players.get(j).addMove(move.charAt(j));
                }
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new Input(players, noRounds);
    }
}
