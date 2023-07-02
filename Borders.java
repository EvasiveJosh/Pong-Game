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
public class Borders extends JPanel
{
    
    // Assigns positions for different borders
    public int xT;
    public int yT;

    public int xL;
    public int yL;

    public int xB;
    public int yB;

    public int xR;
    public int yR;

    public int mid;
    public int midY;

    public int p1Score;
    public int p2Score;

    public Borders()
    {
        this.xT = 0;
        this.yT = 0;

        this.xL = 0;
        this.yL = 0;

        this.xB = 0;
        this.yB = 295;

        this.xR = 495;
        this.yR = 0;

        this.mid = 248;
        this.midY = 0;

        this.p1Score = 0;
        this.p2Score = 0;
    }
   
    // Draws non-moving borders
    public void drawBorder(Graphics g)
    {
        // Draws side borders
        g.setColor(Color.BLUE);
        g.fillRect(xL,yL,5,300);
        g.fillRect(xR,yR,5,300);

        // Draws top and bottom borders
        g.setColor(Color.GRAY);
        g.fillRect(xT,yT,500,5);
        g.fillRect(xB,yB,500,5);

        // Draws dotted line down middle of play area
        g.setColor(Color.DARK_GRAY);
        g.fillRect(mid, midY, 4, 10);
        g.fillRect(mid, midY+15, 4, 10);
        g.fillRect(mid, midY+30, 4, 10);
        g.fillRect(mid, midY+45, 4, 10);
        g.fillRect(mid, midY+60, 4, 10);
        g.fillRect(mid, midY+75, 4, 10);
        g.fillRect(mid, midY+90, 4, 10);
        g.fillRect(mid, midY+105, 4, 10);
        g.fillRect(mid, midY+120, 4, 10);
        g.fillRect(mid, midY+135, 4, 10);
        g.fillRect(mid, midY+150, 4, 10);
        g.fillRect(mid, midY+165, 4, 10);
        g.fillRect(mid, midY+180, 4, 10);
        g.fillRect(mid, midY+195, 4, 10);
        g.fillRect(mid, midY+210, 4, 10);
        g.fillRect(mid, midY+225, 4, 10);
        g.fillRect(mid, midY+240, 4, 10);
        g.fillRect(mid, midY+255, 4, 10);
        g.fillRect(mid, midY+270, 4, 10);
        g.fillRect(mid, midY+285, 4, 10);

        String score1 = Integer.toString(p1Score);
        String score2 = Integer.toString(p2Score);
        // Draws score
        g.drawString(score1, 230, 20);
        g.drawString(score2, 262, 20);
    }
}