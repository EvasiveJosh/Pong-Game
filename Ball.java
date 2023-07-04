
// Imports
import javax.swing.*;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color; 
public class Ball extends JPanel
{
    // Parameters for ball
    public int y;
    public int x;
    public int width;
    public int height;
    public double xVelocity;
    public double yVelocity;
    public int goCrazy;

    public Random rand;

    // Constructs ball position and size
    public Ball()
    {
        this.y = 145;
        this.x = 245;
        this.width = 10;
        this.height = 10;

        this.xVelocity = 0;
        this.yVelocity = 0;
        this.goCrazy = 0;

        this.rand = new Random();

        randomSpeed();
        
    }

    // Draws ball on screen
    public void drawBall(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval(x,y,width,height);
    }

    // Gives the ball a random speed and direction when round starts
    public void randomSpeed()
    {
        while(xVelocity == 0 || yVelocity == 0 || xVelocity == 1 || yVelocity == 1 || xVelocity == -1 || yVelocity == -1)
        {
            this.xVelocity = rand.nextInt(4 + 4)-4;
            this.yVelocity = rand.nextInt(2 + 2)-2;
        }
    }

    // Increases speed on each paddle hit
    public void speedIncrease()
    {
        if(xVelocity == 2 || xVelocity == -2)
        {
            if(xVelocity < 0)
            {
                this.xVelocity = -3;
            }
            else
            {
                this.xVelocity = 3;
            }
            
        }
        else if(xVelocity == 3 || xVelocity == -3)
        {
            if(xVelocity < 0)
            {
                this.xVelocity = -4;
            }
            else
            {
                this.xVelocity = 4;
            }
        }
        else if(xVelocity == 4 || xVelocity == -4)
        {
            if(xVelocity < 0)
            {
                this.xVelocity = -5;
            }
            else
            {
                this.xVelocity = 5;
            }
        }
        else if(xVelocity == 5 || xVelocity == -5)
        {
            if(xVelocity < 0)
            {
                this.xVelocity = -6;
            }
            else
            {
                this.xVelocity = 6;
            }
        }
        
        // If paddles get 10 sucessful consecutive hits speed increases
        if(goCrazy == 10)
        {
            if(xVelocity < 0)
            {
                this.xVelocity = -8;
            }
            else
            {
                this.xVelocity = 8;
            }
        }
        else if(xVelocity == 6 || xVelocity == -6)
        {
            goCrazy++;
        }

        // If paddles get 6 more sucessful consecutive hits speed increases
        if(goCrazy == 16)
        {
            if(xVelocity < 0)
            {
                this.xVelocity = -10;
            }
            else
            {
                this.xVelocity = 10;
            }
        }
        else if(xVelocity == 8 || xVelocity == -8)
        {
            goCrazy++;
        }
    }
}