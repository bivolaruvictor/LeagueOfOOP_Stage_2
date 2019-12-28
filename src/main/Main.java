package main;

import java.io.IOException;
import fileio.FileSystem;
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
                fs.writeWord("~~ Round " + (k + 1) + "  ~~");
                fs.writeNewLine();
                for (Player player : input.getPlayers()) {
                    player.setRound(k);
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
                    }
                }
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
