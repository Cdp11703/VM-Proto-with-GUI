import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;


public class MenuView {

    private JFrame frame;
    private JButton createBtn, exitBtn;
    private JLabel noteLabel;

    public MenuView() {
        this.frame = new JFrame("Vending Machine");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
        this.frame.setResizable(false);
        this.frame.setSize(300, 300);

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


        // Rest of the code remains the same
        this.createBtn = new JButton("Create a Vending Machine");
        this.createBtn.setPreferredSize(new Dimension(200, 30));

        this.exitBtn = new JButton("Exit");
        this.exitBtn.setPreferredSize(new Dimension(200, 30));

        this.noteLabel = new JLabel("<html>Note: If you choose to create a vending machine and choose a regular or a special one then you can test it yourself right away</html>");
        this.noteLabel.setPreferredSize(new Dimension(250, 60)); // Set the preferred size of the label
        
        
        JTextArea noteTextArea = new JTextArea("Note: If you choose to create a vending machine and choose a regular or a special one then you can test it yourself right away");
        noteTextArea.setLineWrap(true);
        noteTextArea.setWrapStyleWord(true);
        noteTextArea.setEditable(false);
        noteTextArea.setPreferredSize(new Dimension(250, 60));
        noteTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Set border for the text area

        // Sets the font to bold
        Font boldFont = new Font(noteTextArea.getFont().getFamily(), Font.BOLD, noteTextArea.getFont().getSize());
        noteTextArea.setFont(boldFont);

        // Create a JScrollPane to enable scrolling if needed
        JScrollPane scrollPane = new JScrollPane(noteTextArea);
        scrollPane.setPreferredSize(new Dimension(250, 80));
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove the border around the JScrollPane

       
        JPanel panel1 = new JPanel();
        panel1.setOpaque(false); // Set the panel to be transparent
        panel1.add(createBtn);
        panel1.setPreferredSize(new Dimension(300, 40));


        JPanel panel2 = new JPanel();
        panel2.setOpaque(false); // Set the panel to be transparent
        panel2.add(exitBtn);
        panel2.setPreferredSize(new Dimension(300, 40));

        
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(255, 192, 203)); // Set the background color to rose pink
        panel3.setPreferredSize(new Dimension(300, 100));
        panel3.add(scrollPane);

        this.frame.add(panel1);
        this.frame.add(panel2);
        this.frame.add(panel3);

        this.frame.setVisible(true);
    }

    public void setCreateBtnListener(ActionListener actn) {
        this.createBtn.addActionListener(actn);
    }


    public void setExitBtnListener(ActionListener actn) {
        this.exitBtn.addActionListener(actn);
    }
}
