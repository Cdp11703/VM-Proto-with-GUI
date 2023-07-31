import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionListener;


/**
 * The CreateVMView class represents the view for creating a new vending machine.
 * It extends the BaseView class and provides buttons to choose between a regular and special vending machine.
 */
public class CreateVMView extends BaseView {

    private JButton RegularVMBtn, SpecialVMBtn;

    /**
     * This will construct a new CreateVMView object by setting up the UI components for the view.
     * It adds buttons to choose between a regular and special vending machine.
     * The UI components are placed on transparent panels to overlay them on the background image.
     */
    public CreateVMView() {
        super();

        this.RegularVMBtn = new JButton("Regular Vending Machine");
        this.RegularVMBtn.setPreferredSize(new Dimension(200, 30));

        this.SpecialVMBtn = new JButton("Special Vending Machine");
        this.SpecialVMBtn.setPreferredSize(new Dimension(200, 30));

        JPanel panel1 = new JPanel();
        panel1.setOpaque(false); // This sets the first panel to be transparent
        panel1.add(RegularVMBtn);
        panel1.setPreferredSize(new Dimension(300, 40));

        JPanel panel2 = new JPanel();
        panel2.setOpaque(false); // This sets the second panel to be transparent
        panel2.add(SpecialVMBtn);
        panel2.setPreferredSize(new Dimension(300, 40));

        super.getFrame().add(panel1);
        super.getFrame().add(panel2);

        super.getFrame().setVisible(true);
    }

    /**
     * This will set the ActionListener for the Regular Vending Machine button.
     *
     * @param actn The ActionListener to be set for the Regular Vending Machine button.
     */
    public void setRegularVMBtnListener(ActionListener actn) {
        this.RegularVMBtn.addActionListener(actn);
    }

    /**
     * This will set the ActionListener for the Special Vending Machine button.
     *
     * @param actn The ActionListener to be set for the Special Vending Machine button.
     */
    public void setSpecialVMBtnListener(ActionListener actn) {
        this.SpecialVMBtn.addActionListener(actn);
    }
}