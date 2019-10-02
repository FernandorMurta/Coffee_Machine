package machine;

import java.util.Scanner;

public class CoffeeMachine {
        final static String BUY = "buy";

        final static String FILL = "fill";

        final static String TAKE = "take";

        final static String REMAINING = "remaining";

        final static String EXIT = "exit";

        final static String BACK = "back";

        public static void main(String[] args) {
            Machine machine = new Machine(400, 540, 120, 9, 550);
            action(machine);
        }

        static void state(Machine machine) {
            System.out.println("The coffee machine has:");
            System.out.println(machine.getWater() + " of water");
            System.out.println(machine.getMilk() + " of milk");
            System.out.println(machine.getCoffee() + " of coffee beans");
            System.out.println(machine.getCups() + " of disposable cups");
            System.out.println(machine.getMoney() + " of money");
        }

        static void action(Machine machine) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String response = scanner.nextLine();

            switch (response) {
                case BUY: {
                    buy(machine);
                    break;
                }

                case FILL: {
                    fill(machine);
                    break;
                }

                case TAKE: {
                    take(machine);
                    break;
                }

                case REMAINING: {
                    state(machine);
                    action(machine);
                    break;
                }

                case EXIT:{

                }
            }
        }

        static void buy(Machine machine) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: , back - tom main menu:");
            String response = scanner.nextLine();

            switch (response) {

                case "1": {
                    machine.espresso();
                    action(machine);
                    break;
                }

                case "2": {
                    machine.latte();
                    action(machine);
                    break;
                }

                case "3": {
                    machine.cappuccino();
                    action(machine);
                    break;
                }

                case BACK: {
                    action(machine);
                    break;
                }
            }
        }

        static void fill(Machine machine) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write how many ml of water do you want to add:");
            int fill = scanner.nextInt();
            machine.setWater(machine.getWater() + fill);

            System.out.println("Write how many ml of milk do you want to add:");
            fill = scanner.nextInt();
            machine.setMilk(machine.getMilk() + fill);

            System.out.println("Write how many grams of coffee beans do you want to add:");
            fill = scanner.nextInt();
            machine.setCoffee(machine.getCoffee() + fill);

            System.out.println("Write how many disposable cups of coffee do you want to add:");
            fill = scanner.nextInt();
            machine.setCups(machine.getCups() + fill);

            action(machine);
        }

        static void take(Machine machine) {
            System.out.println("I gave you $" + machine.getMoney());
            machine.setMoney(0);
            action(machine);
        }
    }


    class Machine {
        int water;
        int milk;
        int coffee;
        int cups;
        int money;

        public Machine(int water, int milk, int coffee, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.coffee = coffee;
            this.cups = cups;
            this.money = money;
        }

        public Machine() {
        }

        public int getWater() {
            return water;
        }

        public void setWater(int water) {
            this.water = water;
        }

        public int getMilk() {
            return milk;
        }

        public void setMilk(int milk) {
            this.milk = milk;
        }

        public int getCoffee() {
            return coffee;
        }

        public void setCoffee(int coffee) {
            this.coffee = coffee;
        }

        public int getCups() {
            return cups;
        }

        public void setCups(int cups) {
            this.cups = cups;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        void espresso() {
            if (this.water >= 250 && this.coffee >= 16 && this.cups >= 1) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 250;
                this.coffee -= 16;
                this.cups--;
                this.money += 4;
            } else {
                haveWater(250);
                haveCoffee(16);
                haveCup();
            }
        }

        void latte() {
            if (this.water >= 350 && this.milk >= 75 && this.coffee >= 20 && this.cups >= 1) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 350;
                this.milk -= 75;
                this.coffee -= 20;
                this.cups--;
                this.money += 7;
            } else {
                haveWater(350);
                haveMilk(75);
                haveCoffee(20);
                haveCup();
            }
        }

        void cappuccino() {
            if (this.water >= 200 && this.milk >= 100 && this.coffee >= 12 && this.cups >= 1) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 200;
                this.milk -= 100;
                this.coffee -= 12;
                this.cups--;
                this.money += 6;
            } else {
                haveWater(200);
                haveMilk(100);
                haveCoffee(12);
                haveCup();
            }
        }

        void haveWater(int water) {
            if (this.water < water) {
                System.out.println("Sorry, not enough water!");
            }
        }

        void haveMilk(int milk) {
            if (this.milk < milk) {
                System.out.println("Sorry, not enough milk!");
            }
        }

        void haveCoffee(int coffee) {
            if (this.coffee < coffee) {
                System.out.println("Sorry, not enough coffee!");
            }
        }

        void haveCup() {
            if (this.cups < 1) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }