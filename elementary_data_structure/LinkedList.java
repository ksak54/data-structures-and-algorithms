public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        }

        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printLinkedList(LinkedList list) {
        Node curr_node = list.head;
        System.out.println("\nLinked List: ");
        if (curr_node != null) {
            do {
                System.out.print(curr_node.data + " ");
                curr_node = curr_node.next;
            } while (curr_node != null);
        } else {
            System.out.println("Linked List is empty.");
        }
        System.out.println();

    }

    public static void delete(LinkedList list, int key) {
        Node del_node = list.head.next;
        Node prev = list.head;
        if (list.head.data == key) {
            list.head = list.head.next;
        }

        else {
            while (del_node != null) {
                if (del_node.data == key) {
                    prev.next = del_node.next;
                    break;
                } else if (del_node.next != null) {
                    prev = prev.next;
                } else {
                    System.out.println(key + " not found");
                }
                del_node = del_node.next;
            }
        }

    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        // list = insert(list, 1);
        // list = insert(list, 2);
        // list = insert(list, 3);
        // list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        printLinkedList(list);

        delete(list, 1);
        delete(list, 2);
        delete(list, 3);
        delete(list, 4);
        delete(list, 5);
        // delete(list, 6);
        // delete(list, 7);
        delete(list, 8);
        delete(list, 6);
        delete(list, 7);

        printLinkedList(list);

    }
}