public class LLDriver {
    public static void main(String[] args) {
        System.out.println("Initializing Linked List... ");
        LinkedList<Integer> myList = new LinkedList<Integer>();

        System.out.println("Adding a head: data of 0 at index 0");
        myList.addAtIndex(0, 0);

        printList(myList);

        System.out.println("Adding a head: data of 69 at index 0");
        myList.addAtIndex(69, 0);

        printList(myList);

        System.out.println("Getting the head of list:");
        System.out.println(myList.getHead().data + "\n");

        System.out.println("Adding a third node:");
        myList.addAtIndex(3, 2);

        printList(myList);

        System.out.println("Removing the node at index 1:");
        myList.removeAtIndex(1);

        printList(myList);

        System.out.println("Adding the fourth node (only three remain) at index 1:");
        myList.addAtIndex(4, 1);

        printList(myList);

        System.out.println("Getting the tail of list:");
        System.out.println(myList.getTail().data + "\n");

        System.out.println("Removing node with data of '69':");
        System.out.println(myList.remove(69));

        printList(myList);
        
        System.out.println("Is the list empty?:");
        System.out.println(myList.isEmpty() + "\n");

        System.out.println("Clearing the list:");
        myList.clear();

        System.out.println("\n" + "The list should be empty and the size should be zero...\n");
        printList(myList);
    }

    public static void printList(LinkedList<Integer> list) {
        System.out.println("Printing the data from the list in order:");
        System.out.println(list.toString());
        System.out.println("Size: " + list.size() + "\n");
    }
    
}
