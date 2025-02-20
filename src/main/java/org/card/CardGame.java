package org.card;

public abstract class CardGame {

    public void playGame(){
        initialDeck();
        deal();
        play();
        announceWinner();
    }

    protected abstract void deal();

    protected abstract void play();

    protected abstract void initialDeck();

    protected abstract void announceWinner();
}
