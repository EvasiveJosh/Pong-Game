
// Imports
import javax.swing.JFrame;

import java.awt.Color; 

public class Main 
{
    // Create draw object and menu object
     static Draw draw = new Draw();
     static Menu menu = new Menu();
    public static void main(String[] args)
    {
        // Display menu screen
        menuScreen();
    }

    public static void gameLoop()
    {
        // Start game update loop
        while(true)
        {
            draw.update();
            try
            {
                Thread.sleep(28);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void gameScreen(Draw draw)
    {
        // Reset menu object
        menu = new Menu();
        // Create game window
        draw.jframe = new JFrame("PONG");
        draw.jframe.setBackground(Color.BLACK);    
        draw.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        draw.jframe.setSize(514, 337);

        draw.jframe.add(draw);
        draw.jframe.setVisible(true);
    }

    public static void menuScreen()
    {

        draw.jframe.setVisible(false);
        draw = new Draw();

        draw.button = false;
        draw.singlePlayer = false;
        draw.twoPlayer = false;

        // Create menu window
        draw.jframe = new JFrame("PONG");
        draw.jframe.setBackground(Color.WHITE);
        draw.jframe.setSize(514, 337);
        draw.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Displays draw menu JPanel layout
        menu.drawMenu(draw);        
        
        draw.jframe.setVisible(true);

        // Runs the game loop
        gameLoop();
    }
}