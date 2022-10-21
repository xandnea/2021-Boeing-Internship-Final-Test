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
