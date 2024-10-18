import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class GUI {
    static App app;
    public static void main(String[] args) {
        app = new App();
        new GUI(app);
    }

    public GUI(App app){
        JFrame frame;
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel(app, frame);
    }

    static void mainPanel(App app,JFrame frame){
        
        JPanel panel = new JPanel();
        ArrayList<JButton> buttonList = new ArrayList<JButton>(9);
        for (int i = 0; i < 9; i++) {
            JButton  button = new JButton(Integer.toString(i+1));
            button.setFocusable(false);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton)e.getSource();
                    int playerMove = Integer.parseInt(clickedButton.getText().strip());
                    int player;
                    if (App.nTruns % 2 == 0){
                        //player 2 turn
                        player = 2;
                    }
                    else{
                        //player 1 turn
                        player = 1;
                    }
                    
                    if (player == 1) {
                        clickedButton.setText("X");
                    }
                    else{
                        clickedButton.setText("O");
                    }
                    clickedButton.setEnabled(false);
                    int gameResult = App.afterClick(playerMove, player);
                    if(gameResult == 1){
                        JOptionPane.showMessageDialog(frame, "Player " + player + " wins!");
                        System.exit(0);
                        return;
                    }
                    else if (gameResult == 2) {
                        JOptionPane.showMessageDialog(frame, "Draw!");                        
                        System.exit(0);
                        return;
                    }

                }
                
            });
            buttonList.add(button);
            panel.add(button);
        }
        
        panel.setLayout(new GridLayout(3, 3));
        frame.add(panel);
        frame.setVisible(true);
    }
}