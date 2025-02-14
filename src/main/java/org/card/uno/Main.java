package org.card.uno;

import org.card.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfHumanPlayer;
        while (true) {
            System.out.print("請輸入真人玩家數量 1-4:");
            if (scanner.hasNextLine()) {
                numOfHumanPlayer = scanner.nextInt();
                if (numOfHumanPlayer >= 1 && numOfHumanPlayer <= 4) {
                    break;
                }
            }
        }

        List<UnoPlayer> players = new ArrayList<>();
        for (int i = 1; i < numOfHumanPlayer + 1; i++) {
            System.out.print("請輸入玩家" + i + "的姓名:");
            String name = scanner.next();
            players.add(new HumanPlayer(name));
        }

        while (players.size() != 4) {
            players.add(new AIPlayer());
        }

        Uno uno = new Uno(players);
        System.out.println("-----------牌局開始-----------");
        uno.play();
    }
}
