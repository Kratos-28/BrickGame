package BrickBreaker;

import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame obj =new JFrame();
    static  Container con;
    static JPanel buttonPanel;
    public static void main(String[] args) {
	// write your code here


        StartGame start=new StartGame();
       // GamePlay gamePlay=new GamePlay();
        obj.setBounds(10,10,710,600);
        obj.setTitle("Brick Breaker");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(start);

    }
}
