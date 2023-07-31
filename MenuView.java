import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * The MenuView class will represent the main menu view of the vending machine app.
 * It extends the BaseView class to inherit common features and functionalities of the view.
 */
public class MenuView extends BaseView {

    private JButton createBtn, exitBtn;
    private JLabel noteLabel;

    /**
     * This will construct a new MenuView object.
     * It initializes the main menu view components and sets their properties.
     * The view is displayed using the parent BaseView class constructor.
     */
    public MenuView() {
        super();

        // This will create and configure the buttons
        this.createBtn = new JButton("Create a Vending Machine");
        this.createBtn.setPreferredSize(new Dimension(200, 30));
        this.exitBtn = new JButton("Exit");
        this.exitBtn.setPreferredSize(new Dimension(200, 30));

        // This will create and configure the note label as a JTextArea to enable line wrapping
        JTextArea noteTextArea = new JTextArea("Note: If you choose to create a vending machine and choose a regular or a special one then you can test it yourself right away");
        noteTextArea.setLineWrap(true);
        noteTextArea.setWrapStyleWord(true);
        noteTextArea.setEditable(false);
        noteTextArea.setPreferredSize(new Dimension(250, 60));
        noteTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Set border for the text area

        // This sets the font to bold
        Font boldFont = new Font(noteTextArea.getFont().getFamily(), Font.BOLD, noteTextArea.getFont().getSize());
        noteTextArea.setFont(boldFont);

        // This will create a JScrollPane to enable scrolling if needed
        JScrollPane scrollPane = new JScrollPane(noteTextArea);
        scrollPane.setPreferredSize(new Dimension(250, 80));
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove the border around the JScrollPane

        // This will create panels to organize the components
        JPanel panel1 = new JPanel();
        panel1.setOpaque(false); // This sets the panel to be transparent
        panel1.add(createBtn);
        panel1.setPreferredSize(new Dimension(300, 40));

        JPanel panel2 = new JPanel();
        panel2.setOpaque(false); // This sets the panel to be transparent
        panel2.add(exitBtn);
        panel2.setPreferredSize(new Dimension(300, 40));

        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(255, 192, 203)); // This sets the background color to rose pink
        panel3.setPreferredSize(new Dimension(300, 100));
        panel3.add(scrollPane);

        // This adds the panels to the main frame and make it visible
        super.getFrame().add(panel1);
        super.getFrame().add(panel2);
        super.getFrame().add(panel3);
        super.getFrame().setVisible(true);
    }

    /**
     * This will set an ActionListener for the "Create a Vending Machine" button.
     *
     * @param actn The ActionListener to be set for the "Create a Vending Machine" button.
     */
    public void setCreateBtnListener(ActionListener actn) {
        this.createBtn.addActionListener(actn);
    }

    /**
     * This will set an ActionListener for the "Exit" button.
     *
     * @param actn The ActionListener to be set for the "Exit" button.
     */
    public void setExitBtnListener(ActionListener actn) {
        this.exitBtn.addActionListener(actn);
    }
}
