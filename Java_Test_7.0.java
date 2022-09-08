Customer.java:
-------------
public class Customer {
    private String name;
    private int ID;
    
    public Customer(){
        this.name = null;
        this.ID = 0;
    }
    
    public Customer(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
}

Driver.java:
-----------
public class Driver {
    public static void main(String[] args){
        Store store = new Store();
           
        store.addVendingMachine("Drinks");
        store.addVendingMachine("Snacks");

        StockItem candies = new StockItem("Candies", 150, 3);   
        StockItem water = new StockItem("Water", 200, 3);
        StockItem crackers = new StockItem("Crackers", 300, 2);
        StockItem juice = new StockItem("Juice", 150, 5);
        StockItem cookies = new StockItem("Cookies", 150, 6);
        StockItem soda = new StockItem("Soda", 100, 4);

        store.addSupply(candies);
        store.addSupply(water);
        store.addSupply(crackers);
        store.addSupply(juice);
        store.addSupply(cookies);
        store.addSupply(soda);
        
        store.showStockSupplies();
        
        /*
        Customer Bob = new Customer("Bob");
        int bobCID = 0;
        
        bobCID = store.addCustomer(Bob);
        store.buy(bobCID, "Water", 2);      // -> first water
        store.getReceipt(bobCID);
        
        Customer Dan = new Customer("Dan");
        int danCID = 0;
        
        danCID = store.addCustomer(Dan);
        store.buy(danCID, "Water", 1);      // -> first water water 
        store.buy(danCID, "Soda", 2);       // -> first soda water water
        store.buy(danCID, "Cookies", 3);    // -> first cookies
        store.buy(danCID, "Candies", 4);    // -> first candies cookies
        store.getReceipt(danCID);
        */
        
    }
}

LinkedList.java:
---------------
public class LinkedList {       // change insertFirst or deleteFirst to insertAtFirst and deleteAtFirst
    private Node head;          // change insertLast or deleteLast to insertAtEnd and deleteAtEnd
                                // for priority queue and/or stacks
                                // need integer called priority
    public LinkedList(){
        this.head = null;
    }
    
    public void isEmpty(){
        System.out.println("List is empty: " + (head == null));
    }
    
    public Node getHead(){
        return this.head;
    }
    
    public void insertFirst(Receipt data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void deleteFirst(){
        head = head.next;
    }
    
    public void insertLast(Receipt data){
        Node newNode = new Node(data);
        
        if (head == null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void printLinkedList(){
        Node current = head;
        System.out.print("LinkedList: ");
        while (current != null){
            System.out.print(current.getdata() + " ");
            current = current.next;
        }
        System.out.println("\n");
    }
}

Node.java:
---------
public class Node {
    private Receipt data;
    public Node next;      
    
    public Node(Receipt data){
        this.data = data;
        this.next = null;
    }
    
    public Receipt getdata(){
        return this.data;
    }
    
    public void setdata(Receipt data){
        this.data = data;
    }
}

PriorityQueue.java:
------------------
public class PriorityQueue {       
    private Node head;          
                        
    public PriorityQueue(){
        this.head = null;
    }
    
    public void isEmpty(){
        System.out.println("List is empty: " + (head == null));
    }
    
    public Node getHead(){
        return this.head;
    }
    
    public void insertInOrder(StockItem item){
        Node newNode = new Node(item);
        int priority = newNode.getpriority();

        if (head == null){
            head = newNode;
        }else{
            if (priority < head.getpriority()){
                newNode.next = head;
                head = newNode;
            }else{
                Node current = head;
                while ((current.next != null) && (current.getpriority() < priority) && (current.next.getpriority() < priority)){
                    current = current.next;
                }
  
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }
    
    public void insertAtFirst(StockItem item){
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
    }
    
    public void deleteAtFirst(){
        head = head.next;
    }
    
    public void insertAtEnd(StockItem item){
        Node newNode = new Node(item);
        
        if (head == null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void deleteAtEnd(){
        Node current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = current.next.next;
    }
    
    public void printPriorityQueue(){
        Node current = head;
        System.out.print("PriorityQueue: \n");
        while (current != null){
            System.out.print(current.getdata().getname() + ": $" + current.getpriority() + " \n");
            current = current.next;
        }
        System.out.println("\n");
    }

    public class Node {
        private StockItem data;
        private int priority;
        public Node next;      
    
        public Node(StockItem data){
            this.data = data;
            this.priority = data.getcost();
            this.next = null;
        }
    
        public StockItem getdata(){
            return this.data;
        }
        
        public int getpriority(){
            return this.priority;
        }
    }
}

Receipt.java:
------------
public class Receipt {
    private int ID;
    private String itemName;
    private int numItems;
    private int individualCost;
    
    public Receipt(){
        this.ID = 0;
        this.itemName = null;
        this.numItems = 0;
        this.individualCost = 0;
    }
    
    public Receipt(int ID, String itemName, int numItems, int individualCost){
        this.ID = ID;
        this.itemName = itemName;
        this.numItems = numItems;
        this.individualCost = individualCost;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public String getItemName(){
        return this.itemName;
    }    
    
    public int getItems(){
        return this.numItems;
    }    
    
    public int getindividualCost(){
        return this.individualCost;
    }    
    
    public int TotalCost(){
        int total = numItems*individualCost;
        return total;
    }
}

SoldItem.java:
-------------
public class SoldItem {
    private String soldName;
    private int numSold;
    private int soldCost;
    
    public SoldItem(){
        this.soldName = null;
        this.numSold = 0;
        this.soldCost = 0;
    }
    
    public SoldItem(String soldName, int numSold, int soldCost){
        this.soldName = soldName;
        this.numSold = numSold;
        this.soldCost = soldCost;
    }
    
    public String getSoldname(){
        return this.soldName;
    }    
    
    public void setSoldname(String soldName){
        this.soldName = soldName;
    }
    
    public int getnumSold(){
        return this.numSold;
    }    
    
    public void setnumSold(int numSold){
        this.numSold = numSold;
    }
    
    public int getSoldcost(){
        return this.soldCost;
    }    
    
    public void setSoldcost(int soldCost){
        this.soldCost = soldCost;
    }
}

StockItem.java:
--------------
public class StockItem {
    private String name;
    private int quantity;
    private int cost;
    
    public StockItem(){
        this.name = null;
        this.quantity = 0;
        this.cost = 0;
    }
    
    public StockItem(String name, int quantity, int cost){
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }
    
    public String getname(){
        return this.name;
    }    
    
    public void setname(String name){
        this.name = name;
    }
    
    public int getquantity(){
        return this.quantity;
    }    
    
    public void setquantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getcost(){
        return this.cost;
    }    
    
    public void setcost(int cost){
        this.cost = cost;
    }
}

Store.java:
----------
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

