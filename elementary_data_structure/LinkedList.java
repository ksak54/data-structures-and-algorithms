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

    public static void deleteByKey(LinkedList list, int key) {
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

    public static int listLength(LinkedList list) {
        Node traverse = list.head;
        int length = 0;
        while (traverse != null) {
            traverse = traverse.next;
            length++;
        }
        return length;
    }

    public static void deleteByPosition(LinkedList list, int pos) {
        Node head = list.head;
        Node cur_node = list.head.next;
        int i = 0;

        if (0 < pos && pos < listLength(list)) {
            if (pos == 1) {
                deleteByKey(list, head.data);
                System.out.println(pos + " position element found and deleted");

            } else {
                while (i < pos - 2) {
                    cur_node = cur_node.next;
                    head = head.next;
                    i++;
                }
                head.next = cur_node.next;
            }
            System.out.println(pos + " position element found and deleted");
        } else
            System.out.println("\nERROR: Index Out of Bound");
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        printLinkedList(list);

        // deleteByKey(list, 1);
        // deleteByKey(list, 2);
        // deleteByKey(list, 3);
        // deleteByKey(list, 4);
        // deleteByKey(list, 5);
        // deleteByKey(list, 6);
        // deleteByKey(list, 7);
        // deleteByKey(list, 8);
        // deleteByKey(list, 6);
        // deleteByKey(list, 7);

        deleteByPosition(list, 0);

        printLinkedList(list);

    }
}