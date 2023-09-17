
public class Table<T extends Contact> {

    private Node head;     // First record in the table
    private Node tail;     // Last record in the table
    private String title;  // Label for the table

    public Table(Node head, Node tail, String title){
        this.head = head;
        this.tail = tail;
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    /**
     * Creates a new table comprised of nodes in this table, but not in table. 
     * @param table
     * @return
     */
    public Table<T> difference(Table<T> table){
        Table<T> toReturn = null;
        return toReturn;
    }

    /**
     * Adds a new record to the end of the this table.
     * @param data
     */
    public void insert(T data){
        Node current = head;
        Node n = new Node(data);
        //if there is no elements in the linked list just make data the head
        if(current == null){
            head = n;
        }
        //else iterate through and get to the end and add a node
        else{
            while(current.next != null){
                current = current.next;
            }
            current.next = n;
        }
        this.tail = n;
    }

    public Table<T> intersect(String attribute, String value, Table<T> table) {
        Table<T> toReturn =  null;
        return toReturn;
    }
    //Creates a new table comprised of nodes having a value for a specific attribute, created from both tables.

    /**
     * Removes the first node matching whose attribute matches value.
     * @param attribute
     * @param value
     */
    public void remove(String attribute, String value) {
        
    }

    /**
     * Creates a new table comprised of nodes having a value for a specific attribute. 
     * @param attribute
     * @param value
     * @return
     */
    public Table<T> select(String attribute, String value) {
        Table<T> toReturn = null;
        return toReturn;
    }



    /**
     * Creates a new table comprised of nodes that occur in either table(s). No duplicates allowed.
     * @param table
     * @return
     */
    public Table<T> union(Table<T> table) {
        Table<T> toReturn = null;
        return toReturn;
    }


    public String toString() {
    
        String toReturn = "";
        
        Node current = this.head;

        
        while(current != null) {

            
            T contact = current.data;
    
            if(current.data instanceof PersonalContact) {

                toReturn += "Category: " + ((PersonalContact)contact).getLabel() + "\n";
            }
            else if(current.data instanceof WorkContact){


                toReturn += "Job Title: " + ((WorkContact) contact).getTitle() + "\n";
                toReturn += "Company: " + ((WorkContact) contact).getCompany() + "\n";
                toReturn += "Department: " + ((WorkContact) contact).getDepartment() + "\n";

            }
            
            //first, Last, Status\t Phone: \n
            toReturn += "\t" + contact.getPerson().getFirst() + ", ";
            toReturn += contact.getPerson().getLast() + ": ";
            toReturn += "(" + contact.getPerson().getStatus() + "):          ";
            toReturn += "Phone: " + contact.getPhone() + "\n";

            //Street Address
            toReturn += "\t" + contact.getAddress().getStreetAddress() + "\n";

            //city, state zip
            toReturn += "\t" + contact.getAddress().getCityAddress() + ", ";
            toReturn +=  contact.getAddress().getState() + " ";
            toReturn +=  contact .getAddress().getZipCode() + "\n";

            //---------------------
            toReturn += "--------------------------------------------------------------\n";

            current = current.next;
        }
        
        return toReturn;
    }

    public Node getNode(){
        return this.head;
    }



    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}