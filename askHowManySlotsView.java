import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;

public class askHowManySlotsView extends BaseView{
    
    private JButton submitBtn, cancelBtn;
    private JLabel askSlotLabel;
    private JTextField askSlotText;

    public askHowManySlotsView() {
       
        super();

        this.askSlotLabel = new JLabel(" How many number of Slots ?:");
        this.askSlotLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.askSlotText  = new JTextField();
        this.askSlotText.setColumns(10);

        this.submitBtn = new JButton("Submit");
        this.submitBtn.setBackground(Color.PINK);
        this.submitBtn.setPreferredSize(new Dimension(200, 30));

        this.cancelBtn = new JButton("Cancel");
        this.cancelBtn.setBackground(Color.PINK);
        this.cancelBtn.setPreferredSize(new Dimension(200, 30));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 1, 1));
        panel.setBackground(Color.PINK);
        panel.add(askSlotLabel);
        panel.add(askSlotText);
        panel.add(submitBtn);
        panel.add(cancelBtn);

        super.getFrame().add(panel);
        super.getFrame().setVisible(true);
    }

    public void setSubmitBtnListener(ActionListener actn) {
        this.submitBtn.addActionListener(actn);
    }

    public void setCancelBtnListener(ActionListener actn) {
        this.cancelBtn.addActionListener(actn);
    }

    public String getNumSlot(){
        return this.askSlotText.getText();
    }

}
