package main;
import java.io.IOException;

import angel.Angel;
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
                for (Player player : input.getPlayers()) {
                    player.setRound(k);
                    player.setHelpedBy(null);
                    if (player.getBlock() == 0) {
                        player.setStrategy();
                    }
                }
                for (Player player : input.getPlayers()) {
                    player.recieveOvertimeDamage();
                    if (player.getHp() <= 0) {
                        player.setAlive(false);
                    }
                    if (player.isAlive()) {
                        player.movePlayer();
                    }
                }
                for (int i = 0; i < input.getPlayers().size() - 1; ++i) {
                    for (int j = i + 1; j < input.getPlayers().size(); ++j) {
                        input.getPlayers().get(i).simulateFight(input.getPlayers().get(j));
                        Player player1 = input.getPlayers().get(j);
                        if (player1.getKilledBy() != null && !player1.isShowedKilled()) {
                            player1.setShowedKilled(true);
                            fs.writeWord("Player " + player1.getTypeString() + " "
                                    + player1.getId() + " was killed by "
                                    + player1.getKilledBy().getTypeString() + " " + player1.getKilledBy().getId());
                            fs.writeNewLine();
                        }
                        Player player2 = input.getPlayers().get(i);
                        if (player2.getKilledBy() != null && !player2.isShowedKilled()) {
                            player2.setShowedKilled(true);
                            fs.writeWord("Player " + player2.getTypeString() + " "
                                    + player2.getId() + " was killed by "
                                    + player2.getKilledBy().getTypeString() + " " + player2.getKilledBy().getId());
                            fs.writeNewLine();
                        }
                        input.getPlayers().get(i).resetHelperMultiplyer();
                        input.getPlayers().get(i).resetStrategyMultiplyer();
                    }
                }
                if (input.getAngels().get(k) != null) {
                    for (Angel angel : input.getAngels().get(k)) {
                        Magician.getInstance().update(angel);
                        fs.writeWord(Magician.getInstance().getUpdatedAngel());
                        fs.writeNewLine();
                    }
                }
                /*Jucatorii primesc ajutor*/
                for (Player player : input.getPlayers()) {
                    if (input.getAngels().get(k) != null && player.isAlive()) {
                        for (Angel angel : input.getAngels().get(k)) {
                            player.getHelp(angel);
                            fs.writeWord(Magician.getInstance().getUpdatedPlayer());
                            fs.writeNewLine();
                        }
                    }
                }
                fs.writeNewLine();
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
            fs.writeNewLine();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
