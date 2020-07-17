package BrickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartGame extends JPanel implements KeyListener, ActionListener {

    StartGame(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);

        g.setColor(Color.CYAN);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("WELCOME TO BRICK BREAKER ",135,100);

        g.setColor(Color.GREEN);
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Press Enter to Play",250,200);

        g.setColor(Color.GRAY);
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Created by Suraj",500,470);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            JFrame ob=new JFrame();
            GamePlay gp=new GamePlay();
            ob.setBounds(10,10,710,600);
            ob.setTitle("Brick Breaker");
            ob.setResizable(true);
            ob.setVisible(true);
            ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main m=new Main();
            m.obj.setVisible(false);

            ob.add(gp);


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
