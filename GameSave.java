/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdcproject;

/**
 *
 * @author Uni
 */
import java.io.*;

public class GameSave {
    public static void saveGame(Player player, Inventory inventory, int playerProgress, boolean questStarted) {
        try {
            FileOutputStream fileOut = new FileOutputStream("gameSave.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.writeObject(inventory);
            out.writeInt(playerProgress);
            out.writeBoolean(questStarted);
            out.close();
            fileOut.close();
            System.out.println("Game data has been saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Figure out how to load the saved file
    /*
    public static void loadGame() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("gameSave.txt"));
            String playerName = reader.readLine();
            int playerHP = Integer.parseInt(reader.readLine());
            int playerLevel = Integer.parseInt(reader.readLine());
            boolean questStarted = Boolean.parseBoolean(reader.readLine());

            // Close the reader
            reader.close();

            Player player = new Player(playerName, playerHP);
            player.level(playerLevel);
            player.setQuestStarted(questStarted);

            System.out.println("Loaded Player Data:");
            System.out.println("Name: " + player.getPlayerName());
            System.out.println("HP: " + player.getHP());
            System.out.println("Level: " + player.getPlayerLevel());
            System.out.println("Quest Started: " + player.isQuestStarted(questStarted));

            System.out.println("Game data has been loaded.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
}
