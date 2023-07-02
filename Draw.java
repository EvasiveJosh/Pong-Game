/*
 * Name: Dean, Josh, Barry
 * Teacher: Mr. Naccarato
 * Date: December 14, 2021
 * Module Due Date: December 17, 2021
*/

// Imports
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Draw extends JPanel implements KeyListener
{
    
    // Create booleans to check for keys held down
    boolean wKey;
    boolean sKey;
    boolean upKey;
    boolean downKey;
    boolean singlePlayer, twoPlayer, button;

    // Menu JFrame is located in Draw for easy access and change throughout classes
    JFrame jframe;


    // Create 2 paddle, 1 ball, and border objects
    Paddle paddleL;
    Paddle paddleR;
    Ball ball;
    Borders border;

    // Constructor
    public Draw()
    {
        super();
        super.setFocusable(true);
        super.addKeyListener(this);

        // Create booleans to check for keys held down
        this.wKey = false;
        this.sKey = false;
        this.upKey = false;
        this.downKey = false;
        this.singlePlayer = false;
        this.twoPlayer = false;
        this.button = false;

        this.jframe = new JFrame("PONG");


        // Create 2 paddle, 1 ball, and border objects
        this.paddleL = new Paddle(22, 125);
        this.paddleR = new Paddle(470, 125);
        this.ball = new Ball();
        this.border = new Borders();

    }
    
    // Paints graphics on window
    public void paint(Graphics g)
    {
        // Clear the space
        g.clearRect(0, 0, getWidth(), getHeight());

        // Draw border
        border.drawBorder(g);
        
        // Draw paddles
        paddleL.drawPaddle(g);
        paddleR.drawPaddle(g);


        // Draw ball
        ball.drawBall(g);
    }

    // Check for key presses
    // If pressing a key for the first time, ball gets sent in a random direction
    @Override
    public void keyPressed(KeyEvent arg0)
    {
        // Check "s" key
        if(arg0.getKeyCode() == KeyEvent.VK_S)
        {
            sKey = true;
        }
        // Check "w" key
        if(arg0.getKeyCode() == KeyEvent.VK_W)
        {
            wKey = true;
        }
        // Check "up" key
        if(arg0.getKeyCode() == KeyEvent.VK_UP)
        {
            if (twoPlayer)
            {
                upKey = true;
            }
        }
        // Check "down" key
        if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if (twoPlayer)
            {
                downKey = true;
            }
        }
    }

    // Checks if a key has been released
    @Override
    public void keyReleased(KeyEvent arg0)
    {
        if(arg0.getKeyCode() == KeyEvent.VK_S)
        {
            sKey = false;
        }
        if(arg0.getKeyCode() == KeyEvent.VK_W)
        {
            wKey = false;
        }
        if(arg0.getKeyCode() == KeyEvent.VK_UP)
        {
            upKey = false;
        }
        if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
        {
            downKey = false;
        }    
    }

    @Override
    public void keyTyped(KeyEvent arg0)
    {
    }

    // update checks necessary checks
    // paints the next frame
    public void update()
    {
        // checks if the user is still in the main menu
        // because the game loop has to be running while that is open
        // so it just passes through the update loop without executing anything
        if(button)
        {
            if (singlePlayer == true)
            {
                AIPaddle();
            }

            collision();
            paddleCollision();

            keyChecker();

            victoryCheck();
                    
            repaint();
        }
    }

    // Checks which keys are held down and increases or decreases the y position accordingly
    public void keyChecker()
    {
        if(sKey)
        {
            paddleL.y += 3;
        }
        if(wKey)
        {
            paddleL.y -= 3;
        }
        if(upKey)
        {
            paddleR.y -= 3;
        }
        if(downKey)
        {
            paddleR.y += 3;
        }
    }
    
    public void collision()
    {
        //celing and floor colision
        if(ball.y == 5 || ball.y == 300-15)
        {
            playSound("Fart.wav");
            ball.yVelocity *= -1;
        }
        
        //wall collision
        if(ball.x == 5 || ball.x == 4 || ball.x == 3 || ball.x == 2 || ball.x == 1 || ball.x == 0)
        {
            playSound("point.wav");
            // Adds score to players total
            border.p2Score += 1;
            repaint();

            resetObjects();

            // Checks if player got 10 points
            victoryCheck();
            
        }
        else if(ball.x == 500-15 || ball.x == 500-14 || ball.x == 500-13 || ball.x == 500-12 || ball.x == 500-11 || ball.x == 500-10)
        {
            playSound("point.wav");
            // Adds score to players total
            border.p1Score += 1;
            repaint();

            resetObjects();

            // Checks if player got 10 points
            victoryCheck();
           
        }

        //paddle collisions
        //left paddle ball collision
        if(ball.xVelocity < 0)
        {
            if(ball.x == paddleL.x+5 || ball.x == paddleL.x+4 || ball.x == paddleL.x+6 || ball.x == paddleL.x+7|| ball.x == paddleL.x+8 || ball.x == paddleL.x+3)
            {
                // Goes through each y-point on the paddle
                for(int i = 0; i <= 30; i++)
                {
                    if(ball.y == paddleL.y + i)
                    {
                        playSound("bonk.wav");
                        // Increases speed on paddle hit
                        ball.xVelocity *= -1;
                        ball.speedIncrease();
                        
                        break;
                        
                    }
                }
            }
        }
        // Right Paddle Ball Collistion
        else if(ball.xVelocity > 0)
        {
            if(ball.x == paddleR.x-10 || ball.x == paddleR.x-9 || ball.x == paddleR.x-8|| ball.x == paddleR.x-11 || ball.x == paddleR.x-12)
            {
                // Goes through each y-point on the paddle
                for(int j = 0; j <= 30; j++)
                {
                    if(ball.y == paddleR.y + j)
                    {
                        playSound("bonk.wav");
                        // Increases speed on paddle hit
                        ball.xVelocity *= -1;
                        ball.speedIncrease();
                        
                        break;
                    }
                }
            }
        }
        //Insert Ball Movement
        ball.x += ball.xVelocity;
        ball.y += ball.yVelocity;
    }

    // Checks if paddle hits top or bottom border and stops it
    public void paddleCollision()
    {
        if(paddleL.y == 4 || paddleL.y == 5 || paddleL.y == 6)
        {
            wKey = false;
        }
        if(paddleL.y == 295-paddleL.height || paddleL.y == 294-paddleL.height || paddleL.y == 296-paddleL.height)
        {
            sKey = false;
        }

        if(paddleR.y == 4 || paddleR.y == 5 || paddleR.y == 6)
        {
            upKey = false;
        }
        if(paddleR.y == 295-paddleR.height || paddleR.y == 294-paddleR.height || paddleR.y == 296-paddleR.height)
        {
            downKey = false;
        }
    }  

    
    public void resetObjects()
    {
        // Adds delay between goal and next round
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Resets ball and paddle positions
        ball = new Ball();
        paddleL = new Paddle(22, 125);
        paddleR = new Paddle(470, 125);
    }



    // Checks if player gets 10 points
    public void victoryCheck()
    {
        if(border.p1Score == 3)
        {
            winnerReset("One");
        }
        else if(border.p2Score == 3)
        {
            if(singlePlayer)
            {
                winnerReset("AI");
            }
            else
            {
                winnerReset("Two");
            }
        }
    }

    public void winnerReset(String player)
    {

        playSound("win.wav");
        // Pop up window declaring winner
        JFrame popUp = new JFrame("Winner!");

        JPanel panel = new JPanel();

        JLabel label = new JLabel();
        label.setText("Player " + player + " Wins");

        panel.add(label);

        popUp.add(panel);
        popUp.setSize(250, 100);
        popUp.setVisible(true);
        popUp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Adds delay between pop-up before displaying main menu
        try 
        {
            Thread.sleep(5000);
            popUp.setVisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Displays main menu
        Main.menuScreen();
    }

    // Controls AI Paddle
    public void AIPaddle()
    {
        // Only tracks the ball within a certain range
        if((paddleR.y+3 - ball.y)>0 && ball.x>150 && ball.x <470)
        {
            if(paddleR.y <= 5)
            {
            }
            else
            {
                paddleR.y -= 3;
            }
        }
        else if((paddleR.y+3 - ball.y)<0 && ball.x>150 && ball.x <470)
        {
            if(paddleR.y >= 265)
            {
            }
            else
            {
                paddleR.y += 3;
            }
        }
    }

    public void playSound(String fileName) {
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } 
        catch(Exception ex) 
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}