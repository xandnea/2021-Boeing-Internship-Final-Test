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
