package org.card.showdown;

import org.card.CardGame;
import org.card.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Showdown extends CardGame {
    private final List<PokerPlayer> players;
    private final HashMap<Player, Integer> scores;
    private int currentRound;

    public Showdown(List<PokerPlayer> players) {
        currentRound = 1;
        this.players = players;

        //初始化計分
        scores = new HashMap<>();
        players.forEach(player -> scores.put(player, 0));
    }

    private static void initialDeck(List<PokerPlayer> players) {
        // 產生一副新牌
        Deck deck = new Deck();
        // 洗牌
        deck.shuffle();
        // 發牌
        deal(players, deck);
    }

    private static void deal(List<PokerPlayer> players, Deck deck) {
        for (int i = 0; i < 13; i++) {
            for (PokerPlayer player : players) {
                player.addHand(deck.drawCard());
            }
        }
    }

    public void play() {
        initialDeck(players);
        // 進行13局遊戲
        for (int i = 0; i < 13; i++) {
            playRound();
            displayCurrentScores();
        }
        determineWinner();
    }

    private Player playRound() {
        System.out.println("第 " + currentRound + " 局開始");
        // 開始 13 局遊戲
        // 收集每位玩家出的牌
        Map<PokerPlayer, PokerCard> roundCards = new LinkedHashMap<>();
        for (PokerPlayer player : players) {
            System.out.println("\n輪到" + player.getName() + "了");
            PokerCard playedCard = player.playTurn();
            roundCards.put(player, playedCard);
            System.out.println(player.getName() + " 出牌: " + playedCard);
        }

        // 找出最大的牌和對應的玩家
        Player roundWinner = null;
        PokerCard maxCard = null;
        for (Map.Entry<PokerPlayer, PokerCard> entry : roundCards.entrySet()) {
            if (maxCard == null || entry.getValue().compareTo(maxCard) > 0) {
                maxCard = entry.getValue();
                roundWinner = entry.getKey();
            }
        }

        // 更新分數
        scores.put(roundWinner, scores.get(roundWinner) + 1);
        System.out.println(roundWinner.getName() + " 贏得此局！\n");

        currentRound++;
        return roundWinner;
    }

    private void displayCurrentScores() {
        System.out.println("當前分數:");
        scores.forEach((player, score) ->
                System.out.println(player.getName() + ": " + score + "分")
        );
        System.out.println();
    }

    // 決定最終勝利者
    private Player determineWinner() {
        Player winner = null;
        int maxScore = -1;

        for (Map.Entry<Player, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\n遊戲結束！");
        System.out.println("勝利者是: " + winner.getName() + " 總分: " + maxScore);
        return winner;
    }
}
