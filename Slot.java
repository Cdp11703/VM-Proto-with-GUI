/**
 * The Slot class represents a slot that can hold an item with its quantity.
 */
public class Slot {
    private Item item;
    private int itemQuantity;

    /**
     * Constructs an empty Slot object.
     * The item and itemQuantity are initialized to null and 0, respectively.
     */
    public Slot() {
        this.item = item;
        this.itemQuantity = 0;
    }

    /**
     * Constructs a Slot object with the specified item and quantity.
     *
     * @param item          is the item to be stored in the slot
     * @param itemQuantity  is the quantity of the item in the slot
     */
    public Slot(Item item, int itemQuantity) {
        Item slotItem = new Item("Default", 0, 0.0);
        this.item = slotItem;
        this.itemQuantity = itemQuantity;
    }

    /**
     * This gets the item stored in the slot.
     *
     * @return the item stored in the slot
     */
    public Item getItem() {
        return item;
    }

    /**
     * This gets the quantity of the item stored in the slot.
     *
     * @return the quantity of the item stored in the slot
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * This sets the quantity of the item stored in the slot.
     *
     * @param itemQuantity  the new quantity of the item
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

}
