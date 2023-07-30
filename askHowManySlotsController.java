import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.BoxLayout;

public class askHowManySlotsController {

    private askHowManySlotsView askView;

    public askHowManySlotsController(askHowManySlotsView askView) {
        this.askView = askView;

        this.askView.setSubmitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numSlotsStr = askView.getNumSlot();
                try {
                    int numSlots = Integer.parseInt(numSlotsStr);
                    JOptionPane.showMessageDialog(askView.getFrame(), "Number of Slots: " + numSlots);
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(askView.getFrame() , "Invalid input. Please enter a valid number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        askHowManySlotsView askView = new askHowManySlotsView();
        askHowManySlotsController askController = new askHowManySlotsController(askView);
    }
}

