package org.card.showdown;

import org.card.Player;

import java.util.Random;

public class AIPlayer extends PokerPlayer {
    private static int aiCounter = 1;


    protected AIPlayer() {
        super(generateAIName());
    }

    private static String generateAIName() {
        String aiName = "AI-" + aiCounter;
        aiCounter++;
        return aiName;
    }

    @Override
    public PokerCard playTurn() {
        // 簡單AI：隨機出一張牌
        if (hand.isEmpty()) {
            throw new IllegalStateException("沒有牌可以出");
        }
        int randomIndex = new Random().nextInt(hand.size());
        return hand.remove(randomIndex);
    }
}
