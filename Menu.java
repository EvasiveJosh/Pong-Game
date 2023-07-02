/*
 * Name: Dean, Josh, Barry
 * Teacher: Mr. Naccarato
 * Date: December 14, 2021
 * Module Due Date: December 17, 2021
*/

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu
{

    public void drawMenu(Draw draw)
    {
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        
        ImageIcon image = new ImageIcon("pongTitle.png");

        JPanel menuPanel = new JPanel(layout);

        
        //image constraints
        JLabel menuImage = new JLabel(image);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,0,0,0);
        menuPanel.add(menuImage, constraints);
        
        
        //Two player Button
        JButton twoPlayer = new JButton("2 Player");
        constraints.gridx = 0;
        constraints.gridy = 1;
        
        constraints.insets = new Insets(30,10,10,10);
        menuPanel.add(twoPlayer, constraints);
        
        //button For Single player
        JButton singlePlayer = new JButton("vs Computer");
        constraints.gridx = 0;
        constraints.gridy = 2;
        
        constraints.insets = new Insets(10,10,10,10);
        menuPanel.add(singlePlayer, constraints);
        

        singlePlayer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // Sets game to single player against AI
                draw.button = true;
                draw.singlePlayer = true;
                draw.twoPlayer = false;

                // Removes menu panel
                draw.jframe.remove(menuPanel);
                draw.jframe.setVisible(false);

                // Displays game
                Main.gameScreen(draw);
            }
        });
        twoPlayer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // Sets game to single player against AI
                draw.button = true;
                draw.singlePlayer = false;
                draw.twoPlayer = true;
                
                // Removes menu panel
                draw.jframe.remove(menuPanel);
                draw.jframe.setVisible(false);

                // Displays game
                Main.gameScreen(draw);
                
            }
        });

        // Adds menu panel to jframe
        draw.jframe.add(menuPanel);
    }   
}
