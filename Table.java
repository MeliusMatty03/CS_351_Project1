
public class Table<T extends Contact> {

    private Node head;     // First record in the table
    private Node tail;     // Last record in the table
    private String title;  // Label for the table


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



    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}