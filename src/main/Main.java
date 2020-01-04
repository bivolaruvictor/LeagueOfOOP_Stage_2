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

            for (int k = 0; k < input.getNumberOfRounds(); ++k) {
                fs.writeWord("~~ Round " + (k + 1) + " ~~");
                fs.writeNewLine();
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t \t \t \t \t \t \t Round " + (k + 1));
                System.out.println();
                System.out.println("---Initial---");
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
                    if (player.isAlive()) {
                        System.out.println(player.typeToString() + " " + player.getId() + " "
                                + " Level: " + player.getLevel() + " Hp: "
                                + player.getHp() + " Strategy: " +  player.getStrategyMultiplyer()
                                + " Helper: " + player.getHelperMultiplyer());
                    } else {
                        System.out.println(player.typeToString() + " " + player.getId() + " "
                                + " dead");
                    }
                }
                System.out.println();
                System.out.println("---Fight---");
                for (int i = 0; i < input.getPlayers().size() - 1; ++i) {
                    for (int j = i + 1; j < input.getPlayers().size(); ++j) {
                        input.getPlayers().get(i).simulateFight(input.getPlayers().get(j));
                    }
                }
                System.out.println();
                System.out.println("---After Fight---");
//                for (Player player : input.getPlayers()) {
//                    if (player.isAlive()) {
//                        System.out.println(player.typeToString() + " " + player.getId() + " "
//                                + " Level: " + player.getLevel() + " Hp: "
//                                + player.getHp());
//                        Magician.getInstance().update(player);
//                    } else {
//                        System.out.println(player.typeToString() + " dead");
//                        Magician.getInstance().update(player);
//                    }
//                }
                System.out.println();
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
                fs.writeWord(Magician.getInstance().getObservations());
                Magician.getInstance().setObservations("");
                fs.writeNewLine();
                System.out.println();
                System.out.println("---After Angels---");
                for (Player player: input.getPlayers()) {
                    if (player.isAlive()) {
                        System.out.println(player.typeToString() + " " + player.getId() + " "
                                + " Level: " + player.getLevel() + " Hp: "
                                + player.getHp() + " Strategy: " + player.getStrategyMultiplyer()
                                + " Helper: " + player.getHelperMultiplyer());
                    } else {
                        System.out.println(player.typeToString() + " " + player.getId() + " "
                                + " dead");
                    }
                }
            }
            fs.writeWord("~~ Results ~~");
            fs.writeNewLine();
            System.out.println();
            System.out.println("Results");
            for (Player player: input.getPlayers()) {
                if (player.isAlive()) {
                    System.out.println(player.typeToString() + " " + player.getId() + " "
                            + " Level: " + player.getLevel() + " Hp: "
                            + player.getHp() + " Strategy: " +  player.getStrategyMultiplyer()
                            + " Helper: " + player.getHelperMultiplyer());
                } else {
                    System.out.println(player.typeToString() + " " + player.getId() + " "
                            + " dead");
                }
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
