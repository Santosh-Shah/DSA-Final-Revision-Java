package Strivers_A2Z_Sheet_455.Day6_LinkedList.SinglyLL;

public class Main {
    public static Node<Integer> linkedList() {
        Node<Integer> n1 = new Node<>(11);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(13);
        Node<Integer> n4 = new Node<>(40);
        Node<Integer> n5 = new Node<>(25);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    public static void printLL(Node<Integer> head) {
        // Base case
        if(head == null) {
            return;
        }

        Node<Integer> curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static int lengthLL(Node<Integer> head) {
        // Base case
        if(head == null) {
            return 0;
        }

        int count = 0;
        Node<Integer> curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }


    public static Node<Integer> addNodeAtLast(Node<Integer> head, int data) {
        Node<Integer> newNode = new Node<>(data);
        // Base case
        if(head == null) {
            return newNode;
        }

        Node<Integer> temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = linkedList();
        System.out.println(head);
        System.out.println(head.next.data);

        head = addNodeAtLast(head, 50);
        printLL(head);
        int length = lengthLL(head);
        System.out.println("\nLength of LL: " + length);
    }
}