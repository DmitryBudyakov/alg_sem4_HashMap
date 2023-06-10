public class Mapa<K, V> {
    private int size = 6;
    Node<K, V>[] nodes = new Node[size];

    /**
     * Replace value by key
     * @param key Integer key
     * @param value value
     * @return
     */
    public V replace(K key, V value) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                currentNode.value = value;
                return currentNode.value;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    /**
     * Getting size of nodes in mapa
     * @return int number
     */
    public int getSize() {
        if (nodes[0] == null) {
            return 0;
        } else {
            int count = 0;
            for (Node<K,V> node : nodes) {
                while (node != null) {
                    node = node.nextNode;
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * Check exist or not Key in mapa
     * @param key
     * @return
     */
    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                return true;
            } else {
                node = node.nextNode;
            }
        }
        return false;
    }

    /**
     * Check exist or not value in mapa
     * @param value
     * @return
     */
    public boolean containsValue(V value) {
        for (Node<K,V> node : nodes) {
            while (node != null) {
                if (node.value == value) {
                    return true;
                } else {
                    node = node.nextNode;
                }
            }
        }
        return false;
    }

    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                V tmp = currentNode.value;
                currentNode.value = value;
                return tmp;
            }
            currentNode = currentNode.nextNode;
        }
        newNode.nextNode = nodes[index];
        nodes[index] = newNode;
        return null;

    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public V get(K key) {
        int index = getIndex(key);
        // System.out.println("index for key[" + key + "] = " + index);
        Node<K, V> node = nodes[index];
        while (node != null) {
            // if (node.key.equals(key)) {  // fo String
            if (node.key == key) {     // for Integer
                return node.value;
            }
            node = node.nextNode;
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V tmp = currentNode.value;
                if (previousNode == null)
                    nodes[index] = currentNode.nextNode;
                else if (currentNode.nextNode == null)
                    previousNode.nextNode = null;
                else previousNode.nextNode = currentNode.nextNode;
                return tmp;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "";
        for (Node<K,V> node : nodes) {
            while (node != null) {
                if (node.nextNode != null) {
                    output = output + node.key + ":" + node.value + " -> ";
                } else {
                    output = output + node.key + ":" + node.value + ", ";
                }
                node = node.nextNode;
            }
        }
        return output;
    }

    

}
