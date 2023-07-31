import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The CreateVMController class is a controller class that handles user interactions with the CreateVMView.
 * It will listen to events from the view and responds accordingly by creating new views and controllers.
 */
public class CreateVMController {
    private CreateVMView createVMView;

    /**
     * This constructs a new CreateVMController object with the specified CreateVMView.
     * It sets up listeners for buttons in the view and responds to button clicks accordingly.
     *
     * @param createVMView The CreateVMView associated with this controller.
     */
    public CreateVMController(CreateVMView createVMView) {
        this.createVMView = createVMView;

        // This will set up the regular vending machine button listener
        this.createVMView.setRegularVMBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                // Create and display the "askHowManySlots" view and its controller
                askHowManySlotsView askSlotsView = new askHowManySlotsView();
                askHowManySlotsController askSlotController = new askHowManySlotsController(askSlotsView);
                
                // Hide the current view
                createVMView.getFrame().setVisible(false);
            }
        });

        // This will set up the special vending machine button listener
        this.createVMView.setSpecialVMBtnListener(new ActionListener() {
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
