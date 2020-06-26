package algo.mylinkedlist;

/**
 * 查询链表的倒数第k节点
 * 3 8 7 5 6 0
 * k为2时输出6
 */
public class InverseK {


    private Node createLinkList() {
        Node root = new Node(0, null);
        for (int i = 1; i < 10; i++) {
            Node node = new Node(i, root);
            root = node;
        }
        return root;
    }

    public void getInverseK(Node root, int k) {
        if (root == null || k == 0) {
            return;
        }
        Node p1 = root;
        Node p2 = root;
        for (int i = 0; i < k; i++) {
            if (p1 != null) {
                p1 = p1.getNext();
            } else {
                return;
            }
        }
        while (p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        System.out.println(p2.getData());
    }

    public static void main(String[] args) {
        InverseK inverseK = new InverseK();
        Node linkList = inverseK.createLinkList();
        inverseK.getInverseK(linkList, 3);
    }
}
