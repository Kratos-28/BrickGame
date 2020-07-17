package BrickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private  boolean play=false;
    private int score=0;
    private int totalBricks=21;

    private Timer timer;
    private  int delay =8;

    private int playerx=310;
    private int ballposX=120;
    private int ballposY=350;
    private int ballXDir=-1;
    private int ballYDir=-2;
//Generating The Bricks
private Genertor mp;
    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer =new Timer(delay,this);
        timer.start();
        mp=new Genertor(3,7);

    }

    public void paint(Graphics g) {
        // BACKGROUND
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);

        // drawing mp


        mp.draw((Graphics2D)g);

        //Border

        g.setColor(Color.CYAN);
       g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(692, 0, 3, 591);

        //padle
        g.setColor(Color.LIGHT_GRAY);

        g.fillRect(playerx,550,100,8);

        //BALL CREATE
        g.setColor(Color.PINK);

        g.fillOval(ballposX,ballposY,20,20);

        //If you win
        if(totalBricks<=0){
            play=false;
            ballXDir=0;
            ballYDir=0;
            g.setColor(Color.GREEN);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("  YOU WON  ",190,300);

            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press Enter Restart",230,350);
        }

       //IF you Lose
        if(ballposY>570){
            play=false;
            ballXDir=0;
            ballYDir=0;
            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game Over  Your Score is :"+score,190,300);

            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press Enter Restart",230,350);

        }


        // scores
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("Score :"+score,590,30);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    timer.start();

    if(play){
        ballposX+=ballXDir;
        ballposY+=ballYDir;
        if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerx,550,100,8))){
            ballYDir=-ballYDir;
        }

        A: for(int i=0;i<mp.map.length;i++){
            for(int j=0;j<mp.map[0].length;j++){
                if(mp.map[i][j]>0){
                    int brickx=j*mp.brickWidth+80;
                    int bricky=i*mp.brickHeight+50;
                    int brickWidth=mp.brickWidth;
                    int brickHeight=mp.brickHeight;


                    Rectangle rect=new Rectangle(brickx,bricky,brickWidth,brickHeight);
                    Rectangle ballrect=new Rectangle(ballposX,ballposY,20,20);
                    Rectangle brickRect =rect;
                    if(ballrect.intersects(brickRect)){
                        mp.setBrickValue(0,i,j);
                        totalBricks--;
                        score+=5;
                        if(ballposX+19<=brickRect.x||ballposX+1>=brickRect.x+brickRect.width){
                            ballXDir=-ballXDir;
                        }else ballYDir=-ballYDir;
                        break A;
                    }
                }
            }
        }

        if(ballposX<0){
            ballXDir=-ballXDir;

        }
        if(ballposY<0){
            ballYDir=-ballYDir;

        }

        if(ballposX>670){
            ballXDir=-ballXDir;
        }
    }
    repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                if(playerx>=600){
                    playerx=600;
                }
                else{
                    moveRight();
                }
            }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerx<10){
                playerx=10;
            }
            else{
                moveLeft();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!play){
                play=true;
                ballposX=120;
                ballposY=350;
                ballXDir=-1;
                ballYDir=-2;
                score=0;
                playerx=310;
                totalBricks=21;
                mp=new Genertor(3,7);

                repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void moveRight(){
        play=true;
        playerx+=20;

    }
    public void moveLeft(){
        play=true;
        playerx-=20;

    }
}
