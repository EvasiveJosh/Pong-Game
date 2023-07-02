/*
 * Name: Dean, Josh, Barry
 * Teacher: Mr. Naccarato
 * Date: December 14, 2021
 * Module Due Date: December 17, 2021
*/

// Imports
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class Paddle extends JPanel
{
    // Parameters for paddles
    public int x;
    public int y;
    public int width;
    public int height;

    // Constructs paddles position and size
    public Paddle(int xValue, int yValue)
    {
        this.x = xValue;
        this.y = yValue;
        this.width = 8;
        this.height = 30;
    }

    // Draws paddle on screen
    public void drawPaddle(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,width,height);
    }
}