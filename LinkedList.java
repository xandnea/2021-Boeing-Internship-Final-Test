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
