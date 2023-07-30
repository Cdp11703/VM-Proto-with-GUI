import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class CreateVMController {
    private CreateVMView CreateVMV;

    public CreateVMController(CreateVMView CreateVMView) {
        this.CreateVMV = CreateVMView;

        this.CreateVMV.setRegularVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                askHowManySlotsView askSlotsV = new askHowManySlotsView();
                askHowManySlotsController askSlotC = new askHowManySlotsController(askSlotsV);
            }
        });

        this.CreateVMV.setSpecialVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of CreateVMView and CreateVMController
        CreateVMView createView = new CreateVMView();
        CreateVMController createController = new CreateVMController(createView);
    }
}
