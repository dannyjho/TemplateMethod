package org.card.uno;

import org.card.CardGame;
import org.card.Player;

import java.util.List;
import java.util.Objects;

public class Uno extends CardGame {

    List<UnoPlayer> players;
    UnoCard currentCard;
    private UnoDeck unoDeck;
    private Player winner;

    public Uno(List<UnoPlayer> players) {
        this.players = players;
    }

    @Override
    protected void initialDeck() {
        unoDeck = new UnoDeck();

        unoDeck.shuffle();
    }

    @Override
    protected void deal() {
        for (int i = 0; i < 5; i++) {
            for (UnoPlayer player : players) {
                player.addHand(unoDeck.draw());
            }
        }
        // 翻開第一張牌
        currentCard = unoDeck.showFirstCard();
    }

    @Override
    public void play() {
        boolean gameOver = false;

        while (!gameOver) {
            for (UnoPlayer player : players) {
                System.out.println("輪到" + player.getName());
                System.out.println("最上面的牌爲: " + currentCard.toString());

                processPlayerTurn(player);

                if (player.getHand().isEmpty()) {
                    winner = player;
                    gameOver = true;
                    break;
                }
            }
        }
    }

    @Override
    protected void announceWinner() {
        System.out.println("玩家" + winner.getName() + "獲勝");
    }

    private void processPlayerTurn(UnoPlayer player) {
        while (true) {
            UnoCard playerChooseCard = player.playTurn(currentCard);

            if (playerChooseCard == null) {
                System.out.println(player.getName() + "選擇抽牌");
                player.addHand(unoDeck.draw());
                break;
            }

            if (!isValidPlay(playerChooseCard)) {
                System.out.println("這張牌不能出！請重新選擇");
                continue;
            }

            player.playCard(playerChooseCard);
            // 更新檯面上的牌
            currentCard = playerChooseCard;
            break;
        }
    }

    private boolean isValidPlay(UnoCard playerChooseCard) {
        return Objects.equals(playerChooseCard.getColor(), currentCard.getColor())
                || playerChooseCard.getValue() == currentCard.getValue();
    }
}
