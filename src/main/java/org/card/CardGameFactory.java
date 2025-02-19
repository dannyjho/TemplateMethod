package org.card;

import org.card.showdown.AIPlayer;
import org.card.showdown.HumanPlayer;
import org.card.showdown.PokerPlayer;
import org.card.showdown.Showdown;
import org.card.uno.Uno;
import org.card.uno.UnoPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGameFactory {

    private final Scanner scanner;

    public CardGameFactory(Scanner scanner) {
        this.scanner = scanner;
    }


    public CardGame createPokerGame() {
        List<PokerPlayer> players = createPokerPlayers();
        Showdown showdown = new Showdown(players);
        return showdown;
    }

    public CardGame createUnoGame() {
        List<UnoPlayer> players = createUnoPlayers();
        Uno uno = new Uno(players);

        return uno;
    }

    private List<PokerPlayer> createPokerPlayers() {
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

        List<PokerPlayer> players = new ArrayList<>();
        for (int i = 1; i < numOfHumanPlayer + 1; i++) {
            System.out.print("請輸入玩家" + i + "的姓名:");
            String name = scanner.next();
            players.add(new HumanPlayer(name));
        }

        while (players.size() != 4) {
            players.add(new AIPlayer());
        }

        return players;
    }

    private List<UnoPlayer> createUnoPlayers() {
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
            players.add(new org.card.uno.HumanPlayer(name));
        }

        while (players.size() != 4) {
            players.add(new org.card.uno.AIPlayer());
        }
        return players;
    }


}
