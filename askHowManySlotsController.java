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

/**
 * This is the controller class for the askHowManySlotsView.
 */
public class askHowManySlotsController {

    private askHowManySlotsView askView;
    private RegularVMController regVend;

    /**
     * This will construct an askHowManySlotsController with the given askHowManySlotsView.
     * 
     * @param askView The askHowManySlotsView instance to associate with the controller.
     */
    public askHowManySlotsController(askHowManySlotsView askView, RegularVMView regView) {
        this.askView = askView;
        this.regVend = regVend;


        // ActionListener for the submitBtn
        this.askView.setSubmitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numSlotsStr = askView.getNumSlot();
                try {
                    int numSlots = Integer.parseInt(numSlotsStr);
                    if (numSlots >= 8) {
                        
                        JOptionPane.showMessageDialog(askView.getFrame(), "Number of Slots: " + numSlots);
                        askView.getFrame().setVisible(false);
                        regView.setSlots(numSlots);
                        regView.getFrame().setVisible(true);
                        
                    } else {
                        JOptionPane.showMessageDialog(askView.getFrame(), "Number of Slots should be at least 8.");
                    }

                } catch (NumberFormatException ex) {
                    // Handles invalid input
                    JOptionPane.showMessageDialog(askView.getFrame(), "Invalid input. Please enter a valid number.");
                } catch (IllegalArgumentException ex) {
                    // Handles input less than 8
                    JOptionPane.showMessageDialog(askView.getFrame(), "Number of Slots should be at least 8.");
                }
            }
        });

        // ActionListener for the cancelBtn
        this.askView.setCancelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the CreateVMView
                CreateVMView createView = new CreateVMView();
                CreateVMController createController = new CreateVMController(createView);
                // Hide the askHowManySlotsView
                askView.getFrame().setVisible(false);
            }
        });
    }

    /**
     * a main method to launch the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        askHowManySlotsView askView = new askHowManySlotsView();
        
        RegularVMView regView = new RegularVMView();
        
        RegularVMController regControl = new RegularVMController(regView);
        askHowManySlotsController askController = new askHowManySlotsController(askView, regView);
    }
}

