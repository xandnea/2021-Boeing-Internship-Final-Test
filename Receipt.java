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
