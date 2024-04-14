/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdcproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Uni
 */

/*TO-DO LIST
add in unimplemented classes
*/
public class RPGDemo 
{
    private final Player pn = new Player();
    private int playerProgress = 0; //depending on how far the player has progressed the counter will increment by one
    private boolean questStarted = false; //once the player has started the quest it will become true
    private final Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        RPGDemo start;
        start = new RPGDemo();

        start.gameStart();
    }

    public void gameStart() 
    {
        System.out.println("Please enter your name:");
        pn.setPlayerName(scan.nextLine());
        pause(1);
        System.out.println("Greetings " + pn.getPlayerName() + " welcome to Faba town where rookie"
                + " adventurers such as yourself come to start their journey!");
        pause(2);
        townSquare();
    }

    public void townSquare() 
    {
        try 
        {
            System.out.println("(where would like to go?) \n[1]Adventurers guild"
                    + "\n[2]Shops \n[3]The plains \n[4]Inventory \n[5]Save/exit game");
            Choice();
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("\n\n\n\nPlease enter a number(1-5)");
            pause(3);
            scan.next();
            System.out.println("\n\n\n\n");
            townSquare();
        }
    }

    public void Choice() 
    {
        int test = scan.nextInt();

        try 
        {
            switch (test) 
            {
                case 1:
                    if(playerProgress == 0) 
                    {
                        System.out.println("Welcome to the Faba Adventurers Guild! is this your first time here?");
                        System.out.println("If so I have the perfect quest for a beginner like you!");
                        pause(5);
                        System.out.println("Recently there has been a Kobold causing issues for the incoming merchants");
                        System.out.println("They aren't that strong so i'm sure you take one on!");
                        pause(5);
                        System.out.println("just head on over to 'The plains' to get started on you quest!");
                        playerProgress += 1;
                        System.out.println("(you have started quest "+1+")");
                        questStarted = true;
                        pause(5);
                        System.out.println("\n\n\n\n");
                        townSquare();
                    } 
                    else if (playerProgress == 1) 
                    {
                        System.out.println("Hmmm? you're back already? if you want to start a new quest come back when you've "
                                + "finished your previous quest!");
                        pause(5);
                        System.out.println("\n\n\n\n");
                        townSquare();
                    }
                    else if(playerProgress == 2)
                    {
                        System.out.println("Hey! look at you! it seems that you've gotten stronger!");
                        pause(2);
                        System.out.println("Must mean that you've finished you quest!");
                        pause(2);
                        System.out.println("With that I can make you a member of the guild!"
                                + " just sign your name right here!");
                        System.out.print(".");
                        pause(1);
                        System.out.print(".");
                        pause(1);
                        System.out.print(".\n");
                        pause(2);
                        System.out.println("(you became a member of the Faba Adventurers Guild!)");
                        pause(2);
                        System.out.println("Well then "+pn.getPlayerName()+". I wish you the best of luck "
                                + "on your journey!");
                        pause(3);
                        System.out.println("See ya around kid!\n\n\n\n\n\n");
                        pause(2);
                        thanksForPlaying();
                    }
                    break;
                case 2:
                    System.out.println("(call shop class)");
                    townSquare();
                    break;
                case 3:
                    if(questStarted == false) 
                    {
                        System.out.println("(not much to do here)");
                        System.out.print(".");
                        pause(1);
                        System.out.print(".");
                        pause(1);
                        System.out.print(".\n");
                        pause(2);
                        System.out.println("(you returned to town)\n\n\n");
                        pause(2);
                        townSquare();
                    }
                    else if(playerProgress == 1)
                    {
                        Player player = new Player(pn.getPlayerName(), 30);
                        KoboldEnemy kobold = new KoboldEnemy();
                        Combat c = new Combat(player, kobold);
                        c.playerCombat();
                        if (!player.isAlive()) 
                        {
                            System.out.println("YOU DIED!\nGAME OVER");
                            return;
                        }
                        
                        playerProgress += 1;
                        System.out.println("\nQuest Complete!");
                        questStarted = false;
                        townSquare();
                    }
                    break;
                case 4:
                    System.out.println("(you checked your inventory!)\n\n\n");
                    //insert Inventory class
                    townSquare();
                    break;
                case 5:
                    //add GameSave class here
                    System.out.println(pn.getPlayerName() + " has saved their game!\n\n\n");
                    townSquare();
                    break;
                default:
                    System.out.println("\n\n\n\nPlease choose from one of the options above:");
                    pause(2);
                    System.out.println("\n\n\n\n");
                    townSquare();
            }
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Not an integer");
            scan.next();
            townSquare();
        }
    }

    public void pause(int seconds) 
    {
        try 
        {
            Thread.sleep(seconds * 1000);
        } 
        catch (InterruptedException e) 
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public void thanksForPlaying()
    {
        System.out.println("This is the end of our RPG Demo! I hope that you enjoyed"
                + " our game!");
        pause(3);
        System.out.println("THE END!");
    }
}
