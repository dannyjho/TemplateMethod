package org.card;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardGameFactory factory = new CardGameFactory(scanner);

        boolean exitProgram = false;
        while (!exitProgram) {
            displayMainMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    playGame(factory.createPokerGame());
                    break;
                case 2:
                    playGame(factory.createUnoGame());
                    break;
                case 0:
                    exitProgram = true;
                    System.out.println("感謝使用卡牌遊戲系統，再見！");
                    break;
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n===== 卡牌遊戲選單 =====");
        System.out.println("1. 撲克牌比大小");
        System.out.println("2. UNO卡牌遊戲");
        System.out.println("0. 退出程式");
        System.out.println("=====================");
        System.out.print("請選擇: ");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 0 || choice > 2) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 2) {
                    System.out.print("無效選項，請重新輸入 (" + 0 + "-" + 2 + "): ");
                }
            } catch (NumberFormatException e) {
                System.out.print("請輸入有效數字: ");
            }
        }
        return choice;
    }

    private static void playGame(CardGame game) {
        try {
            // 使用樣板方法啟動遊戲
            game.play();

            // 遊戲結束後的處理
            System.out.println("\n遊戲已結束，按 Enter 返回主選單...");
            System.in.read();
        } catch (Exception e) {
            System.out.println("遊戲進行中發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
