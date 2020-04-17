import java.util.Scanner;

public class CoffeeMachine {
    static String action;
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        startMachine();
    }

    public static void startMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        action = scanner.nextLine();

        switch (action) {
            case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                String buyOption = scanner.nextLine();
                switch (buyOption) {
                    case "1": // espresso

                        if (water >= 250 && beans >= 16 && cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250;
                            beans -= 16;
                            cups = cups--;
                            money += 4;
                        } else if (water < 250) {
                            System.out.println("Sorry, not enough water!");
                        } else if (beans < 16) {
                            System.out.println("Sorry, not enough beans!");
                        } else {
                            System.out.println("Sorry, not enough cups!");
                        }
                        break;

                    case "2": // latte
                        if (water >= 350 && beans >= 20 && cups >= 1 && milk >= 75) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            cups--;
                            money += 7;
                        } else if (water < 350) {
                            System.out.println("Sorry, not enough water!");
                        } else if (beans < 20) {
                            System.out.println("Sorry, not enough beans!");
                        } else if (cups < 1) {
                            System.out.println("Sorry, not enough cups!");
                        } else {
                            System.out.println("Sorry, not enough milk!");
                        }
                        break;
                    case "3": // cappuccino

                        if (water >= 200 && beans >= 12 && cups >= 1 && milk >= 100) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            cups--;
                            money += 6;
                        } else if (water < 200) {
                            System.out.println("Sorry, not enough water!");
                        } else if (beans < 12) {
                            System.out.println("Sorry, not enough beans!");
                        } else if (cups < 1) {
                            System.out.println("Sorry, not enough cups!");
                        } else {
                            System.out.println("Sorry, not enough milk!");
                        }
                        break;
                    case "back":
                        break;
                }
                startMachine();
                break;
            }

            case "fill": {
                System.out.println("Write how many ml of water do you want to add: ");
                water += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                beans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                cups += scanner.nextInt();
                startMachine();
                break;
            }

            case "take": {
                System.out.println("I gave you $" + money);
                money = 0;
                startMachine();
                break;
            }

            case "remaining": {
                printAmount(water, milk, beans, cups, money);
                startMachine();
                break;
            }

            case "exit": {
                break;
            }
            default:
                break;
        }
    }

    public static void printAmount(int water, int milk, int beans, int cups, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
