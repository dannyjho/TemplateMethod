package org.card.uno;

import java.util.Scanner;

public class HumanPlayer extends UnoPlayer {

    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }


    @Override
    public UnoCard playTurn(UnoCard currentCard) {
        System.out.println("你的手牌:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.print("[" + i + ": " + hand.get(i) + "]");
            if (i < hand.size() - 1) {
                System.out.print(" | ");  // 用 | 分隔每張牌
            }
        }

        int choice;
        do {
            System.out.print("\n請選擇要出的牌 (0-" + (hand.size() - 1) + ")，如果沒有牌請輸入 -1 抽牌:");
            while (!scanner.hasNextInt()) {
                System.out.println("請輸入有效的數字！");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice != -1 && (choice < 0 || choice >= hand.size()));

        if (choice == -1) {
            return null;
        }

        return hand.get(choice);
    }
}
