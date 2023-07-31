import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;

public abstract class BaseView{

    private JFrame frame;

    public BaseView(){
        this.frame = new JFrame("Vending Machine");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
        this.frame.setResizable(false);
        this.frame.setSize(300, 300);
        this.frame.setLocationRelativeTo(null);

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
    }

    public JFrame getFrame() {
        return this.frame;
    }

}