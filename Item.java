/**
 * The Item class represents an item with a name, price, and the amount of calories.
 */
public class Item {

    private String itemName;
    private int itemPrice;
    private double itemCalories;

    /**
     * Constructs an Item object with the specified name, price, and calorie count.
     *
     * @param itemName     is the name of the item
     * @param itemPrice    is the price of the item
     * @param itemCalories is the amount of calories contained in the item
     */
    public Item(String itemName, int itemPrice, double itemCalories) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCalories = itemCalories;
    }

    /**
     * This gets the name of the item.
     *
     * @return the name of the item
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * This gets the price of the item in integer value.
     *
     * @return the price of the item
     */
    public int getItemPrice() {
        return this.itemPrice;
    }

    /**
     * This gets the amount of calories count of the item in decimal value.
     *
     * @return the amount of calories of the item
     */
    public double getItemCalories() {
        return this.itemCalories;
    }

    /**
     * This allows for the itemName to be changed.
     * 
     * @param itemName is the new String to be set to the original itemName
     */
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    /**
     * This allows for the itemCalories to be changed.
     * 
     * @param itemCalories is the double that will replace the current itemCalories.
     */
    public void setCalories(double itemCalories){
        this.itemCalories = itemCalories;
    }

    /**
     * This allows for the itemPrice to be set to a new value.
     * 
     * @param itemPrice is the integer that will replace the current itemPrice.
     */

    public void setItemPrice(int itemPrice){
        this.itemPrice = itemPrice;
    }
}