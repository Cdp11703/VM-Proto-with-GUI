/**
 * The Transaction class represents a purchase transaction representing the item bought, its quantity, and the amount received.
 */
public class Transaction {  
    private Item itemBought;
    private int itemQuantity;
    private int amountReceived;
    private int totalPayment;

    /**
     * Constructs a Transaction object with the specified item bought, quantity, and amount received.
     *
     * @param itemBought     is the item that was bought
     * @param itemQuantity   is the quantity of the item bought
     * @param amountReceived is the amount of money received for the transaction
     */
    public Transaction(Item itemBought, int itemQuantity, int amountReceived) {
        this.itemBought = itemBought;
        this.itemQuantity = itemQuantity;
        this.amountReceived = amountReceived;
        this.totalPayment = 0;
    }

    /**
     * This gets the item that was bought in the transaction.
     *
     * @return the item that was bought
     */
    public Item getItemBought() {
        return this.itemBought;
    }

    /**
     * This gets the quantity of the item bought in the transaction.
     *
     * @return the quantity of the item bought
     */
    public int getItemQuantity() {
        return this.itemQuantity;
    }

    /**
     * This gets the amount of money received for the transaction.
     *
     * @return the amount of money received
     */
    public int getAmountReceived() {
        return this.amountReceived;
    }

    /**
     * This function updates the item that was bought by the user.
     * 
     * @param item updates itemBought based on the item that was bought by the user.
     */
    public void setItem(Item item){
        this.itemBought=item;
    }

    /**
     * This updates the total payment
     * 
     * @param itemPrice updates the payment total.
     */
    public void setTotalPayment(int itemPrice){
        this.totalPayment+=itemPrice;
    }

    /**
     * This lets the program get the total payment.
     * 
     * @return the total payment of the transaction.
     */
    public int getTotalPayment(){
        return totalPayment;
    }
    



}