package org.card.uno;

public class AIPlayer extends UnoPlayer {

    private static int aiCounter = 1;

    public AIPlayer() {
        super(generateAIName());
    }

    private static String generateAIName() {
        String name = "AI-" + aiCounter;
        aiCounter++;

        return name;
    }

    @Override
    public UnoCard playTurn(UnoCard currentUnoCard) {
        for (UnoCard card : hand) {
            // 找出可以出的牌
            if (hasValidCard(card, currentUnoCard)) {
                return card;
            }
        }
        return null;
    }

    private boolean hasValidCard(UnoCard card, UnoCard currentUnoCard) {
        return card.getColor().equals(currentUnoCard.getColor()) || card.getValue() == currentUnoCard.getValue();
    }
}
