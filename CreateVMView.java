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

public class CreateVMView extends BaseView {

    private JButton RegularVMBtn, SpecialVMBtn;

    public CreateVMView() {
        
        super();

        // Rest of the code remains the same
        this.RegularVMBtn = new JButton("Regular Vending Machine");
        this.RegularVMBtn.setPreferredSize(new Dimension(200, 30));

        this.SpecialVMBtn = new JButton("Special Vending Machine");
        this.SpecialVMBtn.setPreferredSize(new Dimension(200, 30));


        JPanel panel1 = new JPanel();
        panel1.setOpaque(false); // Set the panel to be transparent
        panel1.add(RegularVMBtn);
        panel1.setPreferredSize(new Dimension(300, 40));

        JPanel panel2 = new JPanel();
        panel2.setOpaque(false); // Set the panel to be transparent
        panel2.add(SpecialVMBtn);
        panel2.setPreferredSize(new Dimension(300, 40));

        super.getFrame().add(panel1);
        super.getFrame().add(panel2);

        super.getFrame().setVisible(true);
    }

    public void setRegularVMBtnListener(ActionListener actn) {
        this.RegularVMBtn.addActionListener(actn);
    }

    public void setSpecialVMBtnListener(ActionListener actn) {
        this.SpecialVMBtn.addActionListener(actn);
    }
}