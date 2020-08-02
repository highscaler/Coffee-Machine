package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int dispCups = 9;
    static int money = 550;

    public static void main(String[] args) {

        label:
        while (true) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buy();
                    continue;
                case "fill":
                    fill();
                    continue;
                case "take":
                    take();
                    continue;
                case "remaining":
                    state();
                    continue;
                case "exit":
                    break label;
                default:
                    System.out.println("You entered the wrong name!");
                    break label;
            }
        }
    }

    public static void state() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(dispCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String typeOfCoffee = scanner.next();
        switch (typeOfCoffee) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                }

                if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                }

                if (dispCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }

                if (water >= 250 && coffeeBeans >= 16 && dispCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeeBeans -= 16;
                    dispCups--;
                    money += 4;
                }
                break;
            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                }

                if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                }

                if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                }

                if (dispCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }

                if (water >= 250 && coffeeBeans >= 16 && dispCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    dispCups--;
                    money += 7;
                }
                break;
            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                }

                if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                }

                if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                }

                if (dispCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }

                if (water >= 250 && coffeeBeans >= 16 && dispCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    dispCups--;
                    money += 6;
                }
                break;
            case "back":
                break;
            default:
                System.out.println("You entered the wrong name!");
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        dispCups += scanner.nextInt();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }
}