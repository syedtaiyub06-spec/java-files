class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private static final int BUCKET_COUNT = 769;
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[BUCKET_COUNT];
    }

    private int getIndex(int key) {
        return Math.abs(key) % BUCKET_COUNT;
    }

    public void add(int key) {
        int index = getIndex(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key);
            return;
        }

        Node curr = head;
        while (true) {
            if (curr.key == key) {
                return;
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        curr.next = new Node(key);
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        if (curr == null) {
            return;
        }

        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}