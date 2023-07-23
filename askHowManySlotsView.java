import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;

public class askHowManySlotsView{
    
    private JFrame frame;
    private JButton submitBtn;
    private JLabel askSlotLabel;
    private JTextField askSlotText;

    public askHowManySlotsView() {
        this.frame = new JFrame("Vending Machine");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
        this.frame.setResizable(false);
        this.frame.setSize(300, 150);

        // Set the icon image
        try {
            InputStream iconStream = MenuView.class.getResourceAsStream("VM-removebg-preview.png");
            Image iconImage = ImageIO.read(iconStream);
            this.frame.setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the background image
        try {
            InputStream bgStream = MenuView.class.getResourceAsStream("Vending Machine Pattern.jpg");
            Image bgImage = ImageIO.read(bgStream);
            JLabel background = new JLabel(new ImageIcon(bgImage));
            background.setLayout(new FlowLayout(FlowLayout.CENTER));

            this.frame.setContentPane(background);
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.askSlotLabel = new JLabel(" How many number of Slots ?:");
        this.askSlotLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.askSlotText  = new JTextField();
        this.askSlotText.setColumns(10);

        this.submitBtn = new JButton("Submit");
        this.submitBtn.setBackground(Color.PINK);
        this.submitBtn.setPreferredSize(new Dimension(200, 30));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 0, 0));
        panel.setBackground(Color.PINK);
        panel.add(askSlotLabel);
        panel.add(askSlotText);
        panel.add(submitBtn);

        this.frame.add(panel);
       

        this.frame.setVisible(true);
    }

    public void setSubmitBtnListener(ActionListener actn) {
        this.submitBtn.addActionListener(actn);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                askHowManySlotsView view = new askHowManySlotsView();

                view.setSubmitBtnListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the number of slots from the text field
                        String input = view.askSlotText.getText();
                        try {
                            int numSlots = Integer.parseInt(input);
                            JOptionPane.showMessageDialog(view.frame, "Number of Slots: " + numSlots);
                        } catch (NumberFormatException ex) {
                            // Handle invalid input
                            JOptionPane.showMessageDialog(view.frame, "Invalid input. Please enter a valid number.");
                        }
                    }
                });
            }
        });
    }
}