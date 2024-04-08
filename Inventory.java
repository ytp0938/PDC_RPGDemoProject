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
 * ✓ List or array of items Search list, empty element in list, DON'T fill in
 * gaps with other items ✓ Exit Inventory Prompt
 *
 * TODO: 
 * Save inventory to GameSave data (FileReader)
 * When inventory is selected (in RPGDemo class) opens inventory
 * Update inventory slot when item has been purchased, swapped, or moved over
 *
 */
public class Inventory {

    public static void main(String[] args) {
        boolean openInven = true;

        while (openInven != false) {
            boolean valid = false;
            int equipped = -1;

            String[] inventory = {"[Wooden Sword]", "[Rusty Shield]", "[Bow]", "[Arrow]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]"};

            //Display Inventory
            for (String inventory1 : inventory) {
                System.out.print(inventory1);
            }
            System.out.println();

            while (valid != true) {
                try {
                    System.out.println("Choose an equpiment [1], [2], [3], [4], [5], [6], [7], [8], [9]");
                    Scanner select = new Scanner(System.in);
                    equipped = select.nextInt() - 1;
                    System.out.println("Currently Equipped: " + inventory[equipped]);
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input, select an item within your inventory.");
                }
                if (equipped < 0 || equipped >= inventory.length) {
                    valid = false;
                } else {
                    valid = true;
                }
            }

            //Exitting Inventory
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
    
    public void addItem() {
        
    }
    
    public void moveItem() {
        
    }
}
