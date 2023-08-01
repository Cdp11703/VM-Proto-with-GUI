import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;

/**
 * The BaseView class represents a base class for views in the Vending Machine application.
 * It provides common functionality and properties for all views in the application.
 */
public class BaseView{

    private JFrame frame;

    /**
     * This will construct a new BaseView object and initializes the JFrame with common properties.
     * The JFrame is set up with an icon image and a background image.
     */
    public BaseView(){
        this.frame = new JFrame("Vending Machine");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
        this.frame.setResizable(false);
        this.frame.setSize(300, 300);
        this.frame.setLocationRelativeTo(null);

        // This sets the icon image
        try {
            InputStream iconStream = MenuView.class.getResourceAsStream("VM-removebg-preview.png");
            Image iconImage = ImageIO.read(iconStream);
            this.frame.setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This sets the background image
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

    /**
     * This will get the JFrame associated with the BaseView.
     * 
     * @return The JFrame object.
     */
    public JFrame getFrame() {
        return this.frame;
    }
}
