public class Table<T extends Contact> {

    private Node head;     // First record in the table
    private Node tail;     // Last record in the table
    private String title;  // Label for the table

//...


private class Node{
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
}