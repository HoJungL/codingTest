import java.io.*;
import java.util.*;

public class Main {
    // 트리의 노드를 나타내는 클래스
    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    // 트리 클래스
    static class Tree {
        Node root;

        // 루트 노드를 기준으로 노드 추가
        void add(char parent, char left, char right) {
            if (root == null) {
                root = new Node(parent); // 루트 노드 생성
            }
            addNode(root, parent, left, right); // 자식 노드 추가
        }

        // 트리에 노드를 추가하는 함수
        void addNode(Node current, char parent, char left, char right) {
            if (current == null) return;

            if (current.data == parent) { // 현재 노드가 부모 노드와 같다면
                if (left != '.') current.left = new Node(left); // 왼쪽 자식이 있다면 추가
                if (right != '.') current.right = new Node(right); // 오른쪽 자식이 있다면 추가
            } else {
                addNode(current.left, parent, left, right); // 왼쪽 서브트리 탐색
                addNode(current.right, parent, left, right); // 오른쪽 서브트리 탐색
            }
        }

        // 전위 순회
        void preOrder(Node node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.data); // 루트 방문
            preOrder(node.left, sb); // 왼쪽 서브트리 방문
            preOrder(node.right, sb); // 오른쪽 서브트리 방문
        }

        // 중위 순회
        void inOrder(Node node, StringBuilder sb) {
            if (node == null) return;
            inOrder(node.left, sb); // 왼쪽 서브트리 방문
            sb.append(node.data); // 루트 방문
            inOrder(node.right, sb); // 오른쪽 서브트리 방문
        }

        // 후위 순회
        void postOrder(Node node, StringBuilder sb) {
            if (node == null) return;
            postOrder(node.left, sb); // 왼쪽 서브트리 방문
            postOrder(node.right, sb); // 오른쪽 서브트리 방문
            sb.append(node.data); // 루트 방문
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 개수
        Tree tree = new Tree(); // 트리 객체 생성

        // 트리 입력 정보 받아서 트리 구성
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.add(parent, left, right);
        }

        // 결과 출력 준비
        StringBuilder sb = new StringBuilder();

        // 전위 순회 결과
        tree.preOrder(tree.root, sb);
        sb.append('\n');

        // 중위 순회 결과
        tree.inOrder(tree.root, sb);
        sb.append('\n');

        // 후위 순회 결과
        tree.postOrder(tree.root, sb);
        System.out.print(sb);
    }
}