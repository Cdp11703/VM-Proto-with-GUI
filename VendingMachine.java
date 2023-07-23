import java.util.ArrayList;
import java.util.*;

/**
 * The VendingMachine class represents a vending machine that contains slots with items, manages money and handles transactions, 
 */

public class VendingMachine {
    private String machineType;
    private ArrayList<Slot> slots;
    private int slotCount;

    private int[] denominations = {1, 5, 10, 20, 50, 100, 200, 500, 1000};

    private ArrayList<Money> machineMoneyCount;
    private ArrayList<Money> currentTransactionAmount;

    private ArrayList<Transaction> transactions;
    private int transactionCount;
    
    /**
     * This constructs a VendingMachine object with machineType, machineMoneyCount, currentTransactionAmount, slots, transactions, and transactionCount
     * 
     * @param machineType is either regular or special, identifies the type of machine
     * @param slotCount is how many slots the vending machine has
     * @param vendSlot 
     */
    public VendingMachine(String machineType, int slotCount, Slot vendSlot) {
        this.machineType = machineType;
        this.machineMoneyCount = new ArrayList<Money>();
        this.currentTransactionAmount = new ArrayList<Money>();
        this.slots = new ArrayList<Slot>();
        this.transactions = new ArrayList<Transaction>();
        this.transactionCount=0; 
    }

    /**
     * This initializes the machineMoneyCount arraylist with the quantities set as 0 for each denomination.
     */

    public void initializeMachineMoney(){
    int i=0;

        // This initializes the the denominations of the arraylists containing the money
        for (i = 0; i < denominations.length; i++) {
            Money money = new Money(this.denominations[i], 0);
            machineMoneyCount.add(i, money);
        }

    }

    /**
     * This initializes the currentTransactionAmount arraylist with quantities set as 0 for each denomination.
     */

    public void initializeUserMoney(){
    int i=0;

        // This initializes the the denominations of the arraylists containing the money
        for (i = 0; i < denominations.length; i++) {
            Money money = new Money(this.denominations[i], 0);
            currentTransactionAmount.add(i, money);
        }

    }

    /**
     * This initializes the slots int arraylist with the specified number of empty slots.
     * 
     * @param slotCount - the number of slots to be added
     * @param vendSlot - the initial vending slot to be added
     */

    public void initializeSlot(int slotCount, Slot vendSlot){
        int i=0;

        for (i=0; i<slotCount; i++){
            Slot newSlot = new Slot(null, 0);
            slots.add(i, newSlot);
        }
    }

    /**
     * This initializes the transactions arraylist with empty transaction objects.
     */

    public void initializeTransaction(){
        int i=0;

        for (i=0; i<20; i++){
            Transaction newTransact = new Transaction(null, 0, 0);
            transactions.add(i, newTransact);
        }
    }

    /**
     * This retrieves the amount of money the machine has a.k.a. the machineMoneyCount ArrayList.
     * 
     * @return the machineMoneyCount ArrayList
     */

    public ArrayList<Money> getMachineMoney(){
        return machineMoneyCount;
    }
    
    /**
     * This retrieves the amount of money the user has a.k.a. currentTransactionAmount ArrayList.
     * 
     * @return the currentTransactionAmount ArrayList
     */

    public ArrayList<Money> getTransactionAmount(){
        return currentTransactionAmount;
    }

    /**
     * This retrieves the arraylist of transactions.
     * 
     * @return the transactions ArrayList
     */

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    /**
     * This retrieves an ArrayList of slots
     * 
     * @return the slots arraylist
     */

    public ArrayList<Slot> getSlots(){
        return slots;
    }

    /**
     * This modifies the specified slot using the index in the vending machine by updating its quantity, calories, name, and price.
     * 
     * @param slotIndex - the index of the slot to modify
     * @param addStock - the quantity of items to add to the slot
     * @param slotCal - the new calorie value for the slot item
     * @param itemName - the new name for the slot item
     * @param slotPrice - the new price for the slot item
    */

    public void modifySlotArray(int slotIndex, int addStock, double slotCal, String itemName, int slotPrice){
        int slotChoice = slotIndex-1;
       getSlots().get(slotChoice).setItemQuantity(addStock);
       getSlots().get(slotChoice).getItem().setCalories(slotCal);
       getSlots().get(slotChoice).getItem().setItemName(itemName);
       getSlots().get(slotChoice).getItem().setItemPrice(slotPrice);
    }

   /*    
    public void receivePayment(ArrayList<Money> payment) {

        this.currentTransactionAmount = payment;

        for(int i=0; i < this.machineMoneyCount.size(); i++) { // checks the denominations with amount
            for(int j=0; j < this.currentTransactionAmount.size(); j++) {
                if(this.machineMoneyCount.get(i).getMoneyDenom() == this.currentTransactionAmount.get(j).getMoneyDenom()){ // Loops through all available denominations

                    int moneyTransaction = this.machineMoneyCount.get(i).getMoneyQuantity();
                    int moneyPayed = currentTransactionAmount.get(j).getMoneyQuantity();

                    this.currentTransactionAmount.get(i).setMoneyQuantity(moneyTransaction + moneyPayed);// If denomination is equal to one found in the machineMoneyAmount arraylist, then it will add the quantity
                }
            }
        }
    }
*/  

    /**
     * This will display the money denominations and their quantities for the current transaction.
     * 
     */

    public void displayUserDenominations(){
        int i=0;
        for (i=0; i<getTransactionAmount().size(); i++){
        System.out.println((i+1) + "."  + " Amount of " + getTransactionAmount().get(i).getMoneyDenom() + " peso denomination: " + getTransactionAmount().get(i).getMoneyQuantity());
        } 
    }

    /**
     * This will displays the breakdown of denominations and their quantities for the current transaction.
     * 
     */

    public void displayBreakdown(){
        int i=0, j=1, totalMoney;
        totalMoney=0;
        for (i=0; i<getTransactionAmount().size(); i++){
            if (getTransactionAmount().get(i).getMoneyQuantity()>0){
            System.out.println((j) + "."  + " Amount of " + getTransactionAmount().get(i).getMoneyDenom() + " peso denomination: " + getTransactionAmount().get(i).getMoneyQuantity());
            //totalMoney+=(getTransactionAmount().get(i).getMoneyDenom() * getTransactionAmount().get(i).getMoneyQuantity());
            //totalMoney+=getTransactionAmount().get(i).getMoneyTotal();;
            }  

        }  
        //getTransactionAmount().get(getTransactionAmount().size()-1).setTotalMoney(totalMoney);
        //System.out.println("Total Money: " + totalMoney);
    }

    /**
     * This will calculate the total amount of money for all transactions and sets it in the last transaction object.
     * 
     * @param totalTransactions - the total number of transactions to be considered
     */

    public void calculatingTotal(int totalTransactions){
        int totalMoney = 0;
        for (int i=0; i<totalTransactions; i++){
        totalMoney+=(getTransactionAmount().get(i).getMoneyDenom() * getTransactionAmount().get(i).getMoneyQuantity());
        totalMoney+=getTransactionAmount().get(i).getMoneyTotal();
        }

        getTransactionAmount().get(totalTransactions-1).setTotalMoney(totalMoney);
    }
    
    /**
     * This displays the denominations and their quantities available in the vending machine.
     * 
     */

    public void displayMachineMoney(){
        int i=0;

        for (i=0; i<getMachineMoney().size(); i++){
            System.out.println((i+1) + "."  + " Amount of " + getMachineMoney().get(i).getMoneyDenom() + " peso denomination: " + getMachineMoney().get(i).getMoneyQuantity());
        } 
    }

    /**
     * This dispenses an item from the specified slot index and displays its information.
     * 
     * @param indexDispense the index of the slot to dispense the item from
     */

    public void dispenseItem(int indexDispense){
        this.slots.get(indexDispense).setItemQuantity(slots.get(indexDispense).getItemQuantity() - 1);
        Item item = this.slots.get(indexDispense).getItem();

        System.out.println("Item:" + item.getItemName());
        System.out.println("Calories:" + item.getItemCalories());
    }

    /**
     * This will process the transaction. This will also check if there is enough change and storing the transaction details.
     * 
     * @param tx - the transaction to be processed
     */

    public void produceChange(Transaction tx){
        
        double change = 0.0;
        
        if(!isValidChange(tx)){

            Item itemBought = tx.getItemBought();

            change = (itemBought.getItemPrice() * itemBought.getItemPrice()) - addAllMoney(currentTransactionAmount);
        }

        System.out.format("Your change is %.2f", change);

        this.transactions.add(tx);
        this.transactionCount++;
    }
    
    /**
     * This will check if the change for the transaction is valid based on the amount of money denomination available in the vending machine.
     * 
     * @param tx - the transaction to be checked
     * @return true - if change is valid, false otherwise
     */

    public boolean isValidChange(Transaction tx){
        boolean isChange = true;

        if(addAllMoney(machineMoneyCount) - (int)tx.getAmountReceived() < 0){
            isChange = false;
        }


        return isChange;
    }

    /**
     * This calculates the total amount of money from the provided money ArrayList.
     * 
     * @param money - the list of money with denominations and quantities
     * @return the total amount of money
     */

    public double addAllMoney(ArrayList<Money> money){

        int Allmoney = 0;

        for(int i=0; i<money.size();i++){
            Allmoney += money.get(i).returnMoneyAmount();
        }

        return Allmoney;
    }

     /**
     * This will display the information about items available in the vending machine.
     * 
     */

    public void displayVendingMachine(){ // Item shows null if there is none; otherwise it will show the name and how many is the item

        for(int i=0; i<slots.size(); i++){
            
            Item item = this.slots.get(i).getItem();
            int  slotItemQuantity = this.slots.get(i).getItemQuantity();
            int priceDisplay = this.slots.get(i).getItem().getItemPrice();

            System.out.println("Slot no." + (i+1) + ": " + item.getItemName());
            System.out.println("Cost: " + priceDisplay);
            System.out.println(slotItemQuantity + " of this item left");
        }
    }

     /**
     * This will display the information about the available slots with items in the vending machine.
     * 
     */

    public void displayAvailableSlots(){ // Item shows null if there is none; otherwise it will show the name and how many is the item

        for(int i=0; i<slots.size(); i++){
            
            Item item = this.slots.get(i).getItem();
            int  slotItemQuantity = this.slots.get(i).getItemQuantity();
            int priceDisplay = this.slots.get(i).getItem().getItemPrice();

            if(this.slots.get(i).getItemQuantity()>0){
                System.out.println("Slot no." + (i+1) + ": " + item.getItemName());
                System.out.println("Cost: " + priceDisplay);
                System.out.println(slotItemQuantity + " of this item left");
            }

        }
    }
    
    /**
     * This will display the transaction details for the specified number of transactions.
     * 
     * @param amountTransactions - the number of transactions to display
     */

    public void displayTransaction(int amountTransactions){
        System.out.println("-----------------------------------------------");
        System.out.println("               TRANSACTION RECEIPT             ");
        for (int i=0; i<amountTransactions; i++){
        System.out.println("Item no. " + (i+1));
        System.out.println("Name: " + transactions.get(i).getItemBought().getItemName());
        System.out.println("Price: " + transactions.get(i).getItemBought().getItemPrice());
        System.out.println("Calories: " + transactions.get(i).getItemBought().getItemCalories());
        }

        System.out.println("-----------------------------------------------");
    }

    /**
     * This will calculates the total payment for the specified number of transactions and displays it.
     * 
     * @param transactionLimit - the number of transactions to consider for the total payment
     */


    public void calcTotal(int transactionLimit){
        int i=0, totalMoney;
        totalMoney=0;
        for (i=0; i<transactionLimit; i++){
            totalMoney+=(transactions.get(i).getItemBought().getItemPrice());
        }
        transactions.get(transactionLimit-1).setTotalPayment(totalMoney);
        System.out.println("Total: " + transactions.get(transactionLimit-1).getTotalPayment());
        System.out.println("-----------------------------------------------");
        
    }

    /**
     * This will restocks the amount of items specified vending slot with the specified quantity of items.
     * 
     * @param slotIndex - the index of the slot to restock
     * @param itemAmt the - quantity of items that will be added to the slot
     */

    public void restockItem (int slotIndex, int itemAmt){
        this.slots.get(slotIndex).setItemQuantity(this.slots.get(slotIndex).getItemQuantity() + itemAmt);
    }
    
    /*
    public void setPrice (Slot slot, int slotIndex, int slotPrice){
        this.slots.get(slotIndex).getItem().getItemPrice() = slotPrice;
    }
     */


    /**
     * This will calculate the change for the number of transactions that was specified. 
     * It will also check if the machine has enough money for the change.
     * 
     * @param transactionLimit - the number of transactions to consider for calculating change
    */

    public void calculateChange(int transactionLimit){
        int priceTotal = 0, amountPaid = 0, change, originalChange;
        int validCheck = 0;
        int[] changeArray = new int[denominations.length];

        amountPaid = getTransactionAmount().get(getTransactionAmount().size()-1).getMoneyTotal();
        priceTotal = transactions.get(transactionLimit-1).getTotalPayment();
        originalChange = priceTotal-amountPaid;
        change = amountPaid-priceTotal;
        
        for (int i = 7 ; i>=0; i--){
            changeArray[i] = change/denominations[i];
            change%=denominations[i];
        }
        /* 
         for (int i=0; i<denominations.length; i++){
            System.out.println((i+1) + "."  + " Amount of " + denominations[i] + " peso denomination: " + changeArray[i]);
        } 
        */

        for (int i=0; i<denominations.length; i++){
           if(getMachineMoney().get(i).getMoneyQuantity() < changeArray[i]){
            validCheck++;
           }
        }

        if (validCheck==0){
            System.out.println("Change: ");
            System.out.println("Congratulations! You have successfully made a purchase!");
            System.out.println("-----------------------------------------------");
        }
        else{
            System.out.println("Sorry, but the machine does not have enough money!");
        }

    }

    /**
     * This checks if any slot in the vending machine has items available.
     * 
     * @return true if at least one slot has items, false otherwise
     */

    public boolean checkAllSlots(){
        int checker=0;
        boolean checkNum = false;
        for(int i=0; i<this.slots.size(); i++){
            if (getSlots().get(i).getItemQuantity()>0){
                checker++;
            }
        }
        
        if (checker>0){
            checkNum = true;
        }

        return checkNum;
    }

}




