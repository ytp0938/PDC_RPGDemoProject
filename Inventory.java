/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.textrpgcollab;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vcs4803
 */
/**
 * TODO: When gold is used in a shop, decrement from total amount in inventory.
 *
 *
 */
public class Inventory {

    public static void main(String[] args) {
        boolean openInven = true;
        String[] inventory = {"[Wooden Sword]", "[Rusty Shield]", "[Potion]", "[Gold]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]"};

        int gold = 20;
        String item = null;

        while (openInven != false) {
            boolean valid = false;
            int equipped = -1;

            //Replace null values with item aquired (from Enemy or Shop)
            //Item + gold added to inventory
            if (item != null) {
                addItem(inventory, "[  ]", item, 2);
            }

            if (gold != 0) {
                addGold(inventory, "[Gold]", gold);
            }

            //Display Inventory
            for (String inventory1 : inventory) {
                System.out.print(inventory1);
            }
            System.out.println();

            //Equipping Equipment
            while (valid != true) {
                try {
                    System.out.println("Choose an equpiment [1], [2], [3], [4], [5], [6], [7], [8], [9]");
                    Scanner select = new Scanner(System.in);
                    equipped = select.nextInt() - 1;
                    System.out.println("Currently Equipped: " + inventory[equipped]);
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input, select an item within your inventory.");
                }
                valid = !(equipped < 0 || equipped >= inventory.length);
            }

            //Test if gold is 0
            if (equipped == 3) {
                System.out.println("Would you like to use all gold? [Y] [N]");
                Scanner input = new Scanner(System.in);
                String answer = input.nextLine();

                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("You've used 20 Gold!");
                    useItem(inventory, "Gold", 20, 20);
                    item = null;
                } else {
                    openInven = true;
                }
            }

            //Exiting Inventory
            boolean validExit = false;
            Scanner exitPrompt = new Scanner(System.in);
            System.out.println("Exit Inventory? [Y] [N]");
            String exit = exitPrompt.nextLine();

            //Only Y or N input
            while (validExit != true) {
                if (exit.equalsIgnoreCase("Y")) {
                    openInven = false;
                    validExit = true;
                } else if (exit.equalsIgnoreCase("N")) {
                    openInven = true;
                    validExit = true;
                } else {
                    System.out.println("Invalid input. Please answer [Y] or [N].");
                    System.out.println("Exit Inventory? [Y] [N]");
                    validExit = false;
                    exit = exitPrompt.nextLine();
                }
            }
        }
    }

    //Item gets added to inventory
    static void addItem(String[] inventory, String itemSpace, String item, int amount) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals("[" + item + "]")) {
                if (amount <= 1) {
                    inventory[i] = "[" + item + "]";
                    return;
                }
                inventory[i] = "[" + item + "(" + amount + ")" + "]";
                return;
            }
            if (inventory[i].equals("[  ]")) {
                inventory[i] = "[" + item + "]";
                return;
            }
        }
    }

    //Gold gets added to more gold
    static void addGold(String[] inventory, String goldSpace, int gold) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals("[Gold]")) {
                inventory[i] = "[Gold" + "(" + gold + ")" + "]";
                return;
            }
        }
    }

    //When item is used, deplete total no. that/those item/s
    //currentAmount = how much in possession
    //usage = how much you want/need to use
    static void useItem(String[] inventory, String item, int currentAmount, int usage) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals("[" + item + "(" + currentAmount + ")" + "]")) {
                currentAmount -= usage;
                if (currentAmount < 2) {
                    if (currentAmount < 1) {
                        inventory[i] = "[  ]";
                        return;
                    }
                    inventory[i] = "[" + item + "]";
                    return;
                }
                inventory[i] = "[" + item + "(" + currentAmount + ")" + "]";
                return;
            }
        }
    }

}
