import java.util.*;
import java.util.ArrayList;

import javax.naming.InitialContext;

public class VendMain{
    public static void main (String[]args){
        int slotModifyOption, reStockItem, vendIndex, indexTransact = 0;
        int userChoice, testChoice, slotChoice, vendChoice, choiceBuy;
        int moneyGrab, moneyChoice, moneyInc, moneyInsert;
        int amtSlots = 0;
        ArrayList<VendingMachine> userVends = new ArrayList<VendingMachine>();
        Money money;
        String machineType = "regular";
        String decideSlot, moneyAsk, moneyString, decideBuy;
        vendIndex = -1;
        do{
        Scanner userInput = new Scanner(System.in);  
        
        System.out.println("Hello!, and welcome to the ___ vending machine factory!");
        System.out.println("In here, you have two options: ");
        System.out.println("1. Create a Vending Machine.");
        System.out.println("2. Test a Vending Machine.");
        System.out.println("3. Exit");
        System.out.print("Please choose your option: ");

       userChoice = userInput.nextInt();
       switch(userChoice){
            case 1: System.out.println("You have chosen: Create a Vending Machine");
            vendIndex++;
           
            do{
                System.out.print("Enter amount of slots: ");
                amtSlots = userInput.nextInt();
                if(amtSlots<8){
                    System.out.println("Oops, that's not enough, please try again!");
                }
            }while (amtSlots<8);
            Slot userSlot = new Slot(null, 0);
            VendingMachine userVend = new VendingMachine(machineType, amtSlots, userSlot);
            
            userVends.add(vendIndex, userVend);
            userVends.get(vendIndex).initializeSlot(amtSlots, userSlot);
            userVends.get(vendIndex).initializeMachineMoney();
            userVends.get(vendIndex).initializeUserMoney();
            
           
            System.out.println("You have successfully created a vending machine!");
            break;

            case 2: System.out.println("You have chosen: Test a Vending Machine.");
                if (userVends.size()>0){
                        do{
                            System.out.println("1. Test Vending Features");
                            System.out.println("2. Maintenance");
                            System.out.println("3. Display Vending Machine");
                            System.out.println("4. Replenish Money");
                            System.out.println("5. Collect Money");
                            System.out.println("6. Exit");
                            System.out.print("Please choose your option: ");
                            testChoice = userInput.nextInt();

                            switch (testChoice){
                                case 1: System.out.println("You have chosen: Test Vending Features");
                                if (userVends.get(vendIndex).checkAllSlots() == true){
                                    do{
                                    userVends.get(vendIndex).displayUserDenominations();
                                    System.out.print("Please choose which denomination you would want to insert on the machine (1 up to 9): ");
                                    moneyGrab = userInput.nextInt();
                                    System.out.println("You have chosen to insert " + userVends.get(vendIndex).getTransactionAmount().get(moneyGrab-1).getMoneyDenom());
                                    System.out.print("How much of " + userVends.get(vendIndex).getTransactionAmount().get(moneyGrab-1).getMoneyDenom() + " Are you going to insert in the machine?: ");
                                    moneyInsert = userInput.nextInt();
                                    userVends.get(vendIndex).getTransactionAmount().get(moneyGrab-1).setMoneyQuantity(moneyInsert);
                                    //userVends.get(vendIndex).getMachineMoney().get(moneyGrab-1).setMoneyQuantity(moneyInsert);
                                    System.out.print("Do you want to insert more? (Press Y to continue): ");
                                    userInput.nextLine();
                                    moneyString = userInput.nextLine();
                                    }while (moneyString.equals("Y"));

                                    System.out.println("Breakdown of money would be like this: ");
                                    userVends.get(vendIndex).displayBreakdown();;

                                    System.out.print("Would you want to buy an item? ");
                                    decideBuy = userInput.nextLine();

                                                if(decideBuy.equals("Y")){
                                                    userVends.get(vendIndex).initializeTransaction();
                                                    do{
                                                        userVends.get(vendIndex).displayAvailableSlots();
                                                        System.out.println("These are the available items currently.");
                                                        System.out.print("Which item would you want to buy?: ");
                                                        choiceBuy = userInput.nextInt();
                                                        if (userVends.get(vendIndex).getSlots().get(choiceBuy-1).getItemQuantity()==0){
                                                            System.out.println("Sorry, but this item is out of stock!");
                                                        }
                                                        else{
                                                            userVends.get(vendIndex).getTransactions().get(indexTransact).setItem(userVends.get(vendIndex).getSlots().get(choiceBuy-1).getItem());
                                                            userVends.get(vendIndex).dispenseItem(choiceBuy-1);
                                                            System.out.println("Item Name: " + userVends.get(vendIndex).getTransactions().get(indexTransact).getItemBought().getItemName());                                        
                                                            indexTransact++;
                                                        }
                                                        System.out.println("These are the items you have bought so far: ");
                                                        userVends.get(vendIndex).displayTransaction(indexTransact);
                                                        System.out.print("Would you want to buy another product (Y for Yes)? ");
                                                        userInput.nextLine();
                                                        decideBuy = userInput.nextLine();
                                                    }while (decideBuy.equals("Y"));
                                                }
                                                else{
                                                    System.out.println("Producing change of: ");
                                                    userVends.get(vendIndex).displayBreakdown();
                                                }
                                                userVends.get(vendIndex).displayTransaction(indexTransact);
                                                userVends.get(vendIndex).calculatingTotal(indexTransact);
                                                //System.out.println("Total: " + userVends.get(vendIndex).getTransactionAmount().get(indexTransact).getMoneyTotal());

                                            System.out.print("Are you sure you want to buy these items? (Y for Yes): ");
                                            decideBuy = userInput.nextLine();
                                            if (decideBuy.equals("Y")){
                                                System.out.println("Thank you so much for your purchase! Here is your receipt: ");
                                                userVends.get(vendIndex).displayTransaction(indexTransact);
                                                userVends.get(vendIndex).calcTotal(indexTransact);
                                                userVends.get(vendIndex).calculateChange(indexTransact);
                                            }
                                            else{
                                                System.out.println("Producing change of: ");
                                                userVends.get(vendIndex).displayBreakdown();
                                            }
                                        }
                                        
                                        else{
                                            System.out.println("You have not even made an item in the slots yet!");
                                        }
                                        break;

                                case 2: System.out.println("You have chosen: Maintenance");
                                    System.out.println("1. Modify details of slot.");
                                    System.out.println("2. Restock item in slot.");
                                    System.out.print("Please choose what you would want to do to the vending machine: ");
                                    slotModifyOption = userInput.nextInt();
                                    
                                    switch(slotModifyOption){

                                            case 1:System.out.println("You have chosen:  Modify details of slot");
                                                    System.out.print("Would you want to modify a slot? (Y for Yes): ");
                                                    userInput.nextLine();
                                                    decideSlot = userInput.nextLine();
                                                    if (decideSlot.equals("Y")){
                                                                    do{
                                                                    System.out.print("Choose which slot to modify (1 up to " + (amtSlots) +"): ");
                                                                    slotChoice = userInput.nextInt();
                                                                    if(slotChoice <= amtSlots && slotChoice>0){
                                                                        System.out.print("Please set the price: ");
                                                                        int slotPrice = userInput.nextInt();
                                                                        System.out.print("How many calories?: ");
                                                                        double slotCal = userInput.nextDouble();   
                                                                        userInput.nextLine();      
                                                                        System.out.print("Please set the name: ");
                                                                        String itemName = userInput.nextLine();
                                                                        System.out.print("How many products are there? ");
                                                                        int addStock = userInput.nextInt();


                                                                    userVends.get(vendIndex).modifySlotArray(slotChoice, addStock, slotCal, itemName, slotPrice);
                                                                        
                                                                    
                                                                    }
                                                                    else{
                                                                        System.out.println("Invalid slot!");
                                                                    }
                                                                    userInput.nextLine();
                                                                    System.out.print("Would you want to modify another slot?: ");
                                                                    decideSlot = userInput.nextLine();
                                                            }while (decideSlot.equals("Y"));
                                                    }
                                                    

                                                break;

                                            case 2: System.out.println("You have chosen: Restock item in a specific slot.");
                                                System.out.print("Choose which slot you would want to restock: ");
                                                slotChoice = userInput.nextInt();
                                                slotChoice--;
                                                if(slotChoice <= amtSlots && slotChoice>0){
                                                    System.out.println("You have chosen to restock: " + userVends.get(vendIndex).getSlots().get(slotChoice).getItem().getItemName());
                                                    System.out.print("Enter amount to add: ");
                                                    reStockItem = userInput.nextInt();
                                                    userVends.get(vendIndex).restockItem(slotChoice, reStockItem);
                                                }
                                                
                                                

                                    }
                                break;

                                case 3: System.out.println("You have chosen: Display Vending Machine");
                                userVends.get(vendIndex).displayVendingMachine();
                                break;

                                case 4: System.out.println("You have chosen: Replenish Money.");
                                do{
                                userVends.get(vendIndex).displayMachineMoney();
                                System.out.print("Please choose which one you would want to replenish (1 up to 10): ");
                                moneyChoice = userInput.nextInt();
                                System.out.println("You have chosen to replenish: " + userVends.get(vendIndex).getMachineMoney().get(moneyChoice-1).getMoneyDenom());
                                System.out.print("How much would you want to increase it?: ");
                                moneyInc = userInput.nextInt();
                                userVends.get(vendIndex).getMachineMoney().get(moneyChoice-1).setMoneyQuantity(moneyInc);
                                System.out.print("Do you want to continue replenishing money? (Y for continue): ");
                                userInput.nextLine();
                                moneyAsk = userInput.nextLine();
                                }while(moneyAsk.equals("Y"));
                                break;

                                case 5: System.out.println("You have chosen: Collect Money.");
                                break;

                                case 6: System.out.println("You have chosen: Exit");
                                break;

                                default:System.out.println("Sorry, but this is not one of the options, please try again.");
                                break;
                        }
                   }while (testChoice!=6);
                } 
                else{
                    System.out.println("You have not even made a vending machine!");
                }
            break;

            case 3: System.out.println("You have chosen: Exit");
            break;

            default: System.out.println("Sorry, but this is not one of the options, please try again.");
            break;
       }
           
        }while (userChoice!=3);
    }
}