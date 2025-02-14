package org.card.showdown;

import java.util.Scanner;

public class HumanPlayer extends PokerPlayer {

    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public PokerCard playTurn() {
        System.out.print("你的手牌:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.print(i + ": " + hand.get(i) + " ");
        }

        int choice;
        do {
            System.out.print("\n請選擇要出的牌 (0-" + (hand.size() - 1) + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("請輸入有效的數字！");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 0 || choice >= hand.size());

        return hand.remove(choice);
    }
}
