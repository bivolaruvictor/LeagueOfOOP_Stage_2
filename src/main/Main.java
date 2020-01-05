package main;
import java.io.IOException;
import java.util.List;

import angel.Angel;
import angel.AngelType;
import fileio.FileSystem;
import magician.Magician;
import player.Player;

public final class Main {
    private Main() {
        //to trick checkstyle
    }

    public static void main(final String[] args) {
        Loader loader = new Loader(args[0], args[1]);
        Input input = loader.load();
        try {
            FileSystem fs = new FileSystem(args[0], args[1]);

            for (int round = 0; round < input.getNumberOfRounds(); ++round) {
                fs.writeWord("~~ Round " + (round + 1) + " ~~");
                fs.writeNewLine();
                prepareFighters(input.getPlayers(), round);

                fight(input.getPlayers());

                /*Jucatorii primesc ajutor de la ingeri in runda curenta */
                getAngelHelp(input.getAngels(), input.getPlayers(), round);

                fs.writeWord(Magician.getInstance().getObservations());
                Magician.getInstance().setObservations("");
                fs.writeNewLine();
            }
            fs.writeWord("~~ Results ~~");
            fs.writeNewLine();
            for (Player player: input.getPlayers()) {
                fs.writeWord(player.toString());
                fs.writeNewLine();
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**/
    public static void prepareFighters(final List<Player> players, final int round) {
        for (Player player : players) {
            player.recieveOvertimeDamage();
            if (player.getHp() <= 0) {
                player.setAlive(false);
            }
            if (player.getBlock() == 0) {
                player.setStrategy();
            }
            player.setRound(round);
            if (player.isAlive()) {
                player.movePlayer();
            }
            player.setHelpedBy(null);
        }
    }

    public static void fight(final List<Player> players) {
        for (int i = 0; i < players.size() - 1; ++i) {
            for (int j = i + 1; j < players.size(); ++j) {
                players.get(i).simulateFight(players.get(j));
            }
        }
    }

    public static void getAngelHelp(final List<List<Angel>> angels, final List<Player> players,
                                    final int round) {
        if (angels.get(round) != null) {
            for (Angel angel : angels.get(round)) {
                Magician.getInstance().update(angel);
                for (Player player : players) {
                    if (player.isAlive() && angel.getAngelType() != AngelType.Spawner) {
                        player.getHelp(angel);
                    } else {
                        if (!player.isAlive()
                                && angel.getAngelType() == AngelType.Spawner) {
                            player.getHelp(angel);
                        }
                    }
                    Magician.getInstance().update(player);
                    player.setHelpedBy(null);
                }
            }
        }
    }
}
