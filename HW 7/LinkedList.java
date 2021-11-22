import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    Node<T> getHead() {
        return this.head;
    }

    Node<T> getTail() {
        return this.tail;
    }

    public void addAtIndex(T data, int index) {
        if (index > this.size || index < 0) {
            throw new IllegalArgumentException("Your index is out of list bounds");
        } 
        if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        if (index == 0) {
            Node<T> newHead = new Node<T>(data, this.head);
            this.head = newHead;
            if (this.tail == null) {
                this.tail = newHead;
            }
        } else if (index == this.size) {
            Node<T> toAdd = new Node<T>(data);
            this.tail.next = toAdd;
            this.tail = toAdd;
        } else {
            int location = 0;
            Node<T> current = head;
            while (location < index - 1) {
                current = current.next;
                location += 1;
            }
            Node<T> right = current.next;
            Node<T> toAdd = new Node<T>(data, right);
            current.next = toAdd;
        }
        this.size += 1;
    }

    public T getAtIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("Your index is out of list bounds");
        }
        int location = 0;
        Node<T> current = this.head;
        while (location < index) {
            current = current.next;
            location += 1;
        }
        return current.data;
    }

    public T removeAtIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("Your index is out of list bounds");
        }
        if (index == 0 ) {
            Node<T> toDelete = this.head;
            this.head = this.head.next;
            this.size -= 1;
            return toDelete.getData();
        }
        int location = 0;
        Node<T> left = this.head;
        while (location < index - 1) {
            left = left.next;
            location += 1;
        }
        if (index == this.size - 1) {
            Node<T> toRemove = this.tail;
            this.tail = left;
            left.next = null;
            this.size -= 1;
            return toRemove.getData();
        } else {
            Node<T> toRemove = left.next;
            Node<T> right = toRemove.next;
            left.next = right;
            this.size -= 1;
            return toRemove.getData();
        }
    }

    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.getData() == data) {
                return removeAtIndex(index);
            }
            index += 1;
            current = current.next;
        }
        throw new NoSuchElementException("The data is not present in the list");
    }

    public void clear() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        Node<T> current = this.head;
        String listPrint = "";
        while (current != null) {
            listPrint = listPrint.concat(current.data.toString() + " ");
            current = current.next;
        }
        return listPrint;
    }
} 