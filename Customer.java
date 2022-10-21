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
