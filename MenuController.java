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


public class MenuController {
    
    private MenuView MV;

    public MenuController(MenuView menuView) {
        this.MV = menuView;

        this.MV.setCreateBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateVMView createView = new CreateVMView();
				CreateVMController createController = new CreateVMController(createView);
			}
			
		});

        this.MV.setExitBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
    
    }

    public static void main(String[] args) {
        MenuView menuView = new MenuView();
		MenuController menuController = new MenuController(menuView);
    }
}
