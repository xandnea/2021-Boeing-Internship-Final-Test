public class Store {
    private static final int MAX_VENDING_MACHINE_SPACE = 4;
    private static final int MAX_CUSTOMERS = 100;
    private VendingMachine[] vendingMachines;
    private Customer[] customers;
    private int numvendingmachines = 0;
    private int numcustomers = 0;
    private int ID = 0;
    
    public Store(){
        vendingMachines = new VendingMachine[MAX_VENDING_MACHINE_SPACE];
        customers = new Customer[MAX_CUSTOMERS];
    }
    
    public void addVendingMachine(String name){
        vendingMachines[numvendingmachines] = new VendingMachine(name);
        numvendingmachines++;
    }
    
    public int addCustomer(Customer name){
        int ID = numcustomers;
        customers[numcustomers++] = name;

        return ID;
    }
    
    public void addSupply(StockItem stockItem){
        for (int i = 0; i < numvendingmachines; i++){
            if (stockItem.getname() == "Water" || stockItem.getname() == "Soda" || stockItem.getname() == "Juice" ){
                if (vendingMachines[i].getname() == "Drinks"){
                    vendingMachines[i].addSupply(stockItem);
                }
            }else if (stockItem.getname() == "Candies" || stockItem.getname() == "Cookies" || stockItem.getname() == "Crackers" ){
                if (vendingMachines[i].getname() == "Snacks"){
                    vendingMachines[i].addSupply(stockItem);
                }
            }
        }
    }
    
    /*
    public void buy(int ID, String item, int quantity){
        for (int i = 0; i < numvendingmachines; i++){
            if (item == "Water" || item == "Soda"){
                if (vendingMachines[i].getname() == "Drinks"){
                    vendingMachines[i].buy(ID, item, quantity);
                }
            }else if (item == "Candies" || item == "Cookies"){
                if (vendingMachines[i].getname() == "Snacks"){
                    vendingMachines[i].buy(ID, item, quantity);
                }
            }
        }
    }
    */
    
    public void getReceipt(int ID){
        for (int i = 0; i < numvendingmachines; i++){
            vendingMachines[i].getReceipt(ID);
        }
    }

    public void showStockSupplies(){
        for (int i = 0; i < numvendingmachines; i++){
            vendingMachines[i].showStockSupplies();
        }
    }
        
    public void showSoldItems(){
        for (int i = 0; i < numvendingmachines; i++){
            vendingMachines[i].showSoldItems();
        }
    }
        
    public void showAllReceipts(){
        for (int i = 0; i < numvendingmachines; i++){
            vendingMachines[i].showAllReceipts();
        }
    }
}

VendingMachine.java:
-------------------
public class VendingMachine {
    private static final int SPACE = 10;
    private String machineName;

    private PriorityQueue stockItems;
    private SoldItem[] soldItems;
    private LinkedList receipts;
    
    private int numstockitems = 0;
    private int numsolditems = 0;
    
    public VendingMachine(){
        this.machineName = null;
        stockItems = new PriorityQueue();
        soldItems = new SoldItem[SPACE];
        receipts = new LinkedList();
    }
    
    public VendingMachine(String machineName){
        this.machineName = machineName;
        stockItems = new PriorityQueue();
        soldItems = new SoldItem[SPACE];
        receipts = new LinkedList();
    }
      
    public String getname(){
        return this.machineName;
    }  
      
    public void addSupply(StockItem stockItem){
        stockItems.insertInOrder(stockItem);
    }
    
    /*
    public void buy(int ID, String Item, int AmountPurchased){
        for (int i = 0; i < numstockitems; i++){
            if (stockItems[i].getname() == Item){
                if (AmountPurchased <= stockItems[i].getquantity()){
                    stockItems[i].setquantity(stockItems[i].getquantity() - AmountPurchased);

                    createSoldItem(stockItems[i].getname(), AmountPurchased, stockItems[i].getcost());
                    createReceipt(ID, stockItems[i].getname(), AmountPurchased, stockItems[i].getcost());
                    
                }else{
                    System.out.println("There are not that many candies available, there are only " + stockItems[i].getquantity() + " candies left.");
                }
            }    
        }
    }
    */
    
    public void createSoldItem(String name, int quantity, int cost){
        SoldItem soldItem = new SoldItem(name, quantity, cost);
        soldItems[numsolditems] = soldItem;
        numsolditems++;
    }
    
    public void createReceipt(int ID, String name, int quantity, int cost){
        Receipt receipt = new Receipt(ID, name, quantity, cost);
        receipts.insertLast(receipt);
    }
    
    public void getReceipt(int ID){
        Node current = receipts.getHead();
        if (receipts.getHead() != null){
            while (current != null){
                if (current.getdata().getID() == ID){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Customer ID: " + ID);
                    System.out.println(current.getdata().getItemName());
                    System.out.println("Amount sold: " + current.getdata().getItems());
                    System.out.println("Total: $" + current.getdata().TotalCost());
                }
                current = current.next;
            }
        }
    }
    
    public void showStockSupplies(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println(machineName + " VENDING MACHINE STOCK SUPPLIES: ");
        System.out.println("-----------------------------------------------------------------");
        
        stockItems.printPriorityQueue();
    }
    
    public void showSoldItems(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println(machineName + " VENDING MACHINE SOLD ITEMS: ");
        System.out.println("-----------------------------------------------------------------");
        
        if (numsolditems == 0){
            System.out.println("error: no items sold");
        }else{
            for (SoldItem i_solditem : soldItems){
                if (i_solditem != null){
                    System.out.println("\n" + i_solditem.getSoldname() + ": ");
                    System.out.println(i_solditem.getnumSold());
                    System.out.println("$" + i_solditem.getSoldcost() + " each");
                }    
            }
        }
    }
    
    public void showAllReceipts(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println(machineName + " VENDING MACHINE RECEIPTS: ");
        System.out.println("-----------------------------------------------------------------");
        
        Node current = receipts.getHead();
        if (receipts.getHead() != null){
            while (current.next != null){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Customer ID: " + current.getdata().getID());
                System.out.println(current.getdata().getItemName());
                System.out.println("Amount sold: " + current.getdata().getItems());
                System.out.println("Total: $" + current.getdata().TotalCost());
                current = current.next;
            }
        }
    }
}
