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
