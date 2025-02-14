package org.card.uno;

public enum Color {
    BLUE("藍色"), RED("紅色"), YELLOW("黃色"), GREEN("綠色");


    final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
