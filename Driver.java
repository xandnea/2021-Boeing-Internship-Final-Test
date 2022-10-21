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
