package org.card.showdown;

import org.card.CardGame;
import org.card.Player;

import java.util.*;

public class Showdown extends CardGame {
    private final List<PokerPlayer> players;
    private final HashMap<PokerPlayer, Integer> scores;
    private int currentRound;
    private Deck deck;

    public Showdown(List<PokerPlayer> players) {
        currentRound = 1;
        this.players = players;

        //初始化計分
        scores = new HashMap<>();
        players.forEach(player -> scores.put(player, 0));
    }

    @Override
    protected void initialDeck() {
        // 產生一副新牌
        deck = new Deck();
        // 洗牌
        deck.shuffle();
    }

    @Override
    protected void deal() {
        for (int i = 0; i < 13; i++) {
            for (PokerPlayer player : players) {
                player.addHand(deck.drawCard());
            }
        }
    }

    @Override
    public void play() {
        // 進行13局遊戲
        for (int i = 0; i < 13; i++) {
            playRound();
            displayCurrentScores();
        }
    }

    @Override
    protected void announceWinner() {
        Player winner = null;
        int maxScore = -1;

        for (Map.Entry<PokerPlayer, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\n遊戲結束！");
        System.out.println("勝利者是: " + Objects.requireNonNull(winner).getName() + " 總分: " + maxScore);
    }


    private void playRound() {
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
        PokerPlayer roundWinner = null;
        PokerCard maxCard = null;
        for (Map.Entry<PokerPlayer, PokerCard> entry : roundCards.entrySet()) {
            if (maxCard == null || entry.getValue().compareTo(maxCard) > 0) {
                maxCard = entry.getValue();
                roundWinner = entry.getKey();
            }
        }

        // 更新分數
        scores.put(roundWinner, scores.get(roundWinner) + 1);

        System.out.println(Objects.requireNonNull(roundWinner).getName() + " 贏得此局！\n");

        currentRound++;
    }

    private void displayCurrentScores() {
        System.out.println("當前分數:");
        scores.forEach((player, score) ->
                System.out.println(player.getName() + ": " + score + "分")
        );
        System.out.println();
    }
}
