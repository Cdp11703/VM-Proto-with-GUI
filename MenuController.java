import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MenuController class is responsible for controlling the actions and interactions in the main menu view.
 * It handles button click events and performs corresponding actions, such as creating a new vending machine or exiting the program.
 */
public class MenuController {
    
    private MenuView MV;

    /**
     * This will construct a new MenuController object with the provided MenuView.
     * This sets up action listeners for the buttons in the main menu view.
     *
     * @param menuView The MenuView object representing the main menu view.
     */
    public MenuController(MenuView menuView) {
        this.MV = menuView;

        // The ActionListener for the "Create Vending Machine" button
        this.MV.setCreateBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// It will create a new CreateVMView and CreateVMController to handle vending machine creation
				CreateVMView createView = new CreateVMView();
				CreateVMController createController = new CreateVMController(createView);
				MV.getFrame().setVisible(false); // This will hide the main menu view after clicking the "Create Vending Machine" button
			}
		});
		
        // The ActionListener for the "Exit" button
        this.MV.setExitBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// This will exit the program when the "Exit" button is clicked
				System.exit(0);
			}
		});
    }

    /**
     * Main method to start the application.
     * Initializes the MenuView and MenuController objects to display the main menu.
     *
     * @param args Command-line arguments (not used in this application).
     */
    
}
