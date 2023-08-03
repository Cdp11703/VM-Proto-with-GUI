import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;


public class RegularVMView{
    //private JButton submitBtn, cancelBtn;
    private JFrame frameVend;
    private int numSlots = 0;
    private JPanel panel2, panel3;

    public RegularVMView(){

        this.frameVend = new JFrame("Regular Vending Machine");
        this.frameVend.setResizable(false);
        this.frameVend.setSize(600, 300);
    
        JTextArea welcomeVend = new JTextArea("Welcome to your new regular vending machine!");
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
        panel2.setLayout(new GridLayout(numSlots/4, 4, 10, 10));

        

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

    public void setSlots(int numSlots){
        this.numSlots = numSlots;
        updateButtonsPanel2();
    }


    public void updateButtonsPanel2(){
        for (int i = 1; i <= numSlots; i++) {
            JButton btn = new JButton("Item " + i);

            // Add the button to the panel
            panel2.add(btn);
            btn.addActionListener(new addActionsToButtons(i));
            
        }
    }

    

    class addActionsToButtons implements ActionListener {
        private int buttonIndex;
    
        // Constructor to initialize the buttonIndex when creating the ActionListener
        public addActionsToButtons(int buttonIndex) {
            this.buttonIndex = buttonIndex;
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            // The code inside this method will be executed when the button is clicked
        
            String[] options = {
                    "Set Item(Name, Price, Calories) for Slot",
                    "Set Quantity for Slot",
                    "Buy from this Slot"
            };
        
            int choice = JOptionPane.showOptionDialog(
                    frameVend,                                   // Parent component
                    "You have chosen\n Slot:" + buttonIndex + "\n\nWhat would you want to do with it?", // Message
                    "Options",                                  // Title
                    JOptionPane.YES_NO_CANCEL_OPTION,            // Option type (Yes, No, and Cancel buttons)
                    JOptionPane.QUESTION_MESSAGE,               // Message type (Question icon)
                    null,                                      // Use default icon for custom options
                    options,                                   // Custom options
                    options[0]                                 // Default selected option
            );
        
            if (choice == JOptionPane.YES_OPTION) {
                // User chose "Set Item(Name, Price, Calories) for Slot"
                // Add your code here for handling this choice
            } else if (choice == JOptionPane.NO_OPTION) {
                // User chose "Set Quantity for Slot"
                // Add your code here for handling this choice
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                // User chose "Buy from Slot"
                // Add your code here for handling this choice
            }
        }

    }
   
    public int getSlots(){
        return numSlots;
    }


}