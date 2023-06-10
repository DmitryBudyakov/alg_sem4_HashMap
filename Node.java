/**
 * Node
 */
public class Node<K, V> {
    K key;
    V value;
    Node<K, V> nextNode;
    Node<K, V> previousNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}