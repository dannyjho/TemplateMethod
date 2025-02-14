package org.card.showdown;

public class PokerCard implements Comparable<PokerCard> {
    private final Suit suit;
    private final Rank rank;

    public PokerCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return suit.getSymbol() + rank.getSymbol();
    }


    @Override
    public int compareTo(PokerCard other) {
        if (this.rank.getValue() != other.rank.getValue()) {
            return this.rank.getValue() - other.rank.getValue();
        }
        return this.suit.getValue() - other.suit.getValue();
    }
}
