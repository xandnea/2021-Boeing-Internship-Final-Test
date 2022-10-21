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
