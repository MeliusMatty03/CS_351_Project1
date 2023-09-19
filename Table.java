/**
 * @author Matthew Elliott
 * @version 9/17/23
 * A table used to store and organize objects and other data.
 */

public class Table<T extends Contact>{
    private Node head;     // First record in the table
    private Node tail;     // Last record in the table
    private String title;  // Label for the table

    /**
     * Constructor for the Table class
     * @param head First record in the table
     * @param tail Last record in the table
     * @param title Label for the table
     */
    public Table(Node head, Node tail, String title){
        this.head = head;
        this.tail = tail;
        this.title = title;
    }

    /**
     * Gets the title of the table.
     * @return Label for the table
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Creates a new table comprised of nodes in this table, but not in the other table. 
     * @param table a table that will be passed through to compare to this table.
     * @return a new table comprised of nodes that are only in this table, but not the given table.
     */
    public Table<T> difference(Table<T> table){
        Table<T> toReturn = null;

        Node thisCurrent = this.head;

        //Puts first table into a temp.
        while(thisCurrent.next != null){
            toReturn.insert(thisCurrent.data);
            thisCurrent = thisCurrent.next;
        }

        //Compares second table to the temp table.
        while(thisCurrent.next != null){
            Node otherCurrent = table.head;
            Boolean same = false;
            while(otherCurrent != null && !same){
                if(thisCurrent == otherCurrent){
                    same = true;
                }
            }
            if(!same){
                toReturn.insert(thisCurrent.data);
            }
            thisCurrent = thisCurrent.next;
        }

        return toReturn;
    }

    /**
     * Adds a new record to the end of the this table.
     * @param data data to add to the table.
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

    /**
     * Takes a table, an attribute, and a value and searches for a contact within that table
     * that has that value for that attribute.
     * @param attribute An attribute to search for
     * @param value A value to search for 
     * @param table A table that is passed in to be searched.
     * @return a table containing all contacts with the given attribute and value from the given table.
     */
    public Table<T> intersect(String attribute, String value, Table<T> table) {
        Table<T> toReturn =  null;
        return toReturn;
    }
    //Creates a new table comprised of nodes having a value for a specific attribute, created from both tables.

    /**
     * Removes the first node matching whose attribute matches value.
     * @param attribute An attribute to search for
     * @param value A value to search for 
     */
    public void remove(String attribute, String value) {
        
    }

    /**
     * Creates a new table comprised of nodes having a value for a specific attribute. 
     * @param attribute An attribute to search for
     * @param value A value to search for 
     * @return A table containing contacts that have a certain value for a specific attribute.
     */
    public Table<T> select(String attribute, String value) {
        Table<T> toReturn = null;
        return toReturn;
    }

    /**
     * Creates a new table comprised of nodes that occur in either table(s). No duplicates allowed.
     * @param table a table containing all nodes from either table.
     * @return A table containing node that occur in either table, with no duplicates.
     */
    public Table<T> union(Table<T> table) {
        Table<T> toReturn = null;
        return toReturn;
    }

    /**
     * Formats the table, its attributes, and their values into a string to print.
     * @return A formatted string of a table.
     */
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

    /**
     * Gets the node
     * @return returns the head
     */
    public Node getNode(){
        return this.head;
    }

    /**
     * A class representing a node which holds data
     */
    private class Node {
        T data;
        Node next;

        /**
         * Constructor 
         * @param data data to store in node
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
//End