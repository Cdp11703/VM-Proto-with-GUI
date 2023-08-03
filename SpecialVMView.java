import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;


public class SpecialVMView{
    //private JButton submitBtn, cancelBtn;
    private JFrame frameVend;
    private JPanel panel2, panel3;

    public SpecialVMView(){

        this.frameVend = new JFrame("Special Vending Machine");
        this.frameVend.setResizable(false);
        this.frameVend.setSize(600, 300);
    
        JTextArea welcomeVend = new JTextArea("Welcome to your new special vending machine!");
        welcomeVend.setLineWrap(true);
        welcomeVend.setWrapStyleWord(true);
        welcomeVend.setEditable(false);
        welcomeVend.setPreferredSize(new Dimension(275, 60));
        welcomeVend.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        panel1.add(welcomeVend);
        
    
        this.frameVend.setResizable(false);
        
        this.frameVend.setLocationRelativeTo(null);

        panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setLayout(new GridLayout(1, 4, 10, 10));
        

        JButton Patty = new JButton("Patty");
            panel2.add(Patty);
        JButton Bun = new JButton("Bun");
            panel2.add(Bun);
        JButton Lettuce = new JButton("Lettuce");
            panel2.add(Lettuce);
        JButton Tomato = new JButton("Tomato");
            panel2.add(Tomato);
        JButton Pickles = new JButton("Pickles");
            panel2.add(Pickles);
        JButton Onions = new JButton ("Onions");
            panel2.add(Onions);

        


        

        //updateButtonsPanel2();

        panel3 = new JPanel();
        panel3.setBackground(Color.BLUE);
        

        this.frameVend.setLayout(new BorderLayout());
        this.frameVend.add(panel1, BorderLayout.NORTH);
        this.frameVend.add(panel2, BorderLayout.CENTER);
        this.frameVend.add(panel3, BorderLayout.SOUTH);
    


    }

    public JFrame getFrame() {
        return this.frameVend;
    }

}