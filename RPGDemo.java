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
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter your name:");
        Player pn = new Player();
        pn.playerName = scan.nextLine();
        
        System.out.println("Greetings "+pn.playerName+" welcome to (town name) where rookie"
                + " adventurers such as yourself come to start their journey!");
        
    }
    
}
