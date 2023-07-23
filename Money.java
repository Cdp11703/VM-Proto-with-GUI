/**
 * The Money class represents a denomination and its corresponding quantity.
 */
public class Money {
    private int moneyDenom;    // This will contain the denomination (e.g. 1, 5, 10, 20, 50, 100, 200, 500, 1000)
    private int moneyQuantity; // This will contain the quantity of the denomination
    private int totalMoney; //This will contain the total money based on both money and denomination

    /**
     * Constructs a Money object with the specified denomination and quantity.
     *
     * @param moneyDenom     is the denomination value of the money
     * @param moneyQuantity  is the quantity of the money denomination
     * @param totalMoney     is the total amount of money based on denomination and money
     */
    public Money(int moneyDenom, int moneyQuantity) {
        this.moneyDenom = moneyDenom;
        this.moneyQuantity = moneyQuantity;
        this.totalMoney=0;
    }

    /**
     * This returns the total amount of money represented by the denomination and quantity.
     *
     * @return the total amount of money
     */
    public int returnMoneyAmount() {
        return this.moneyDenom * this.moneyQuantity;
    }

    /**
     * This gets the denomination value of the money.
     *
     * @return the denomination value
     */
    public int getMoneyDenom() {
        return this.moneyDenom;
    }

    /**
     * This gets the quantity of the money denomination.
     *
     * @return the quantity of the money denomination
     */
    public int getMoneyQuantity() {
        return this.moneyQuantity;
    }

    /**
     * This sets the new quantity of the money denomination.
     *
     * @param moneyQuantity  the new quantity of the money denomination
     */
    public void setMoneyQuantity(int moneyQuantity) {
        this.moneyQuantity+=moneyQuantity;
    }

    /**
     * This gets the total Money based on the denomination and how much is there.
     * 
     * @return the total amount of money 
     */
    public int getMoneyTotal(){
        return totalMoney;
    }
   
    /**
     * This updates the current total money based on the denomination and also the quantity of money.
     * 
     */
    public void setTotalMoney(){
        this.totalMoney+=(this.moneyDenom * this.moneyQuantity);
    }

    /**
     * This updates the current total money based on the updated total money parameter.
     * 
     */
    public void setTotalMoney(int updatedTotal){
        this.totalMoney = updatedTotal;
    }



}