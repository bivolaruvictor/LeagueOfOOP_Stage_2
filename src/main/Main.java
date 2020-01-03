package main;
import java.io.IOException;

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
            for (Player player : input.getPlayers()) {
                System.out.println(player.getTypeString() + player.getId() + " " + player.getMoves().toString());
            }
            for (int k = 0; k < input.getNumberOfRounds(); ++k) {
                fs.writeWord("~~ Round " + (k + 1) + " ~~");
                fs.writeNewLine();
                System.out.println("Round " + k);
                for (Player player : input.getPlayers()) {
                    player.recieveOvertimeDamage();
                    if (player.getHp() <= 0) {
                        player.setAlive(false);
                    }
                    if (player.getBlock() == 0) {
                        player.setStrategy();
                    }
                    player.setRound(k);
                    if (player.isAlive()) {
                        player.movePlayer();
                    }
                    player.setHelpedBy(null);
                    System.out.println(player.typeToString() + " " + player.getId() + " " + player.getHp());
                }
                for (int i = 0; i < input.getPlayers().size() - 1; ++i) {
                    for (int j = i + 1; j < input.getPlayers().size(); ++j) {
                        input.getPlayers().get(i).simulateFight(input.getPlayers().get(j));
                    }
                }
                for (Player player : input.getPlayers()) {
                    Magician.getInstance().update(player);
                }
                /*Jucatorii primesc ajutor*/
                if (input.getAngels().get(k) != null) {
                    for (Angel angel : input.getAngels().get(k)) {
                        Magician.getInstance().update(angel);
                        for (Player player : input.getPlayers()) {
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
                for (Player player : input.getPlayers()) {
                    System.out.println(player.typeToString() + " " + player.getId() + " " + player.getHelperMultiplyer());
                }
                fs.writeWord(Magician.getInstance().getObservations());
                Magician.getInstance().setObservations("");
                fs.writeNewLine();
                System.out.println();
            }
            fs.writeWord("~~ Results ~~");
            fs.writeNewLine();
            for (Player player: input.getPlayers()) {
                if (player.isAlive()) {
                    fs.writeWord(player.typeToString() + " " + player.getLevel()
                            + " " + player.getXp() + " " + player.getHp() + " "
                            + player.getxCoordinate() + " "
                            + player.getyCoordinate());
                } else {
                    fs.writeWord(player.typeToString() + " " + "dead");
                }
                fs.writeNewLine();
            }

            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
