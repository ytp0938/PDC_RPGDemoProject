/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdcproject;

import java.util.Scanner;

/**
 *
 * @author Uni
 */
public class RPGDemo 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter your name:");
        Player pn = new Player();
        pn.playerName = scan.nextLine();
        Thread.sleep(1000);
        System.out.println("Greetings "+pn.playerName+" welcome to (town name) where rookie"
                + " adventurers such as yourself come to start their journey!");
        Thread.sleep(2500);
        System.out.println("(where would like to go?) \n[1]Adventurers guild"
                + "\n[2]Blacksmith \n[3]Potion seller \n[4]The plains \n[5]Inventory"
                + "\n[6] Save your game");
        
        
    }
    
}
