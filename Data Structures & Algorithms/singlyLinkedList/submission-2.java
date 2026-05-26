public class LinkedList {
    private Node head;
    private Node tail;
    public LinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node working = head;
        for (int i = 0; i < index; ++i) {
            if (working == null) return -1;
            working = working.next;
        }
        return working != null ? working.value : -1;
    }

    public void insertHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        }
        else {
            Node newHead = new Node(val, head);
            head = newHead;
        }
    }

    public void insertTail(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        }
        else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }

    public boolean remove(int index) {
        if (head == null) return false;
        if (index == 0) {
            head = head.next;
            // in case we have an empty list now
            if (head == null) tail = null;
        }
        else {
            Node curr = head;
            for (int i = 0; i < index -1; ++i) {
                curr = curr.next;
                if (curr == null) return false;
            }
            if (curr.next == null) return false;
            // removing tail
            if (curr.next == tail) tail = curr;
            curr.next = curr.next.next;
        }
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        Node working = head;
        while (working != null) {
            values.add(working.value);
            working = working.next;
        }
        return values;
    }
}

public class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this(value);
        this.next = next;
    }
}
