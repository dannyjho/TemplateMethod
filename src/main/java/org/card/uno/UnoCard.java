package org.card.uno;

public class UnoCard {
    Color color;
    int value;

    public UnoCard(Color color, int value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color.getName();
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getColor() + " " + getValue();
    }
}
