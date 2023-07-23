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

public class CreateVMView {

    private JFrame frame;
    private JButton RegularVMBtn, SpecialVMBtn;

    public CreateVMView() {
        this.frame = new JFrame("Choose a VM to create");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
        this.frame.setResizable(false);
        this.frame.setSize(300, 200);

        // Set the icon image
        try {
            InputStream iconStream = CreateVMView.class.getResourceAsStream("VM-removebg-preview.png");
            Image iconImage = ImageIO.read(iconStream);
            this.frame.setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the background image
        try {
            InputStream bgStream = CreateVMView.class.getResourceAsStream("Vending Machine Pattern.jpg");
            Image bgImage = ImageIO.read(bgStream);
            JLabel background = new JLabel(new ImageIcon(bgImage));
            background.setLayout(new FlowLayout(FlowLayout.CENTER));

            this.frame.setContentPane(background);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        this.frame.add(panel1);
        this.frame.add(panel2);

        this.frame.setVisible(true);
    }

    public void setRegularVMBtnListener(ActionListener actn) {
        this.RegularVMBtn.addActionListener(actn);
    }

    public void setSpecialVMBtnListener(ActionListener actn) {
        this.SpecialVMBtn.addActionListener(actn);
    }
}