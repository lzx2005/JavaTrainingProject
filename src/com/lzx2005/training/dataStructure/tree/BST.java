package com.lzx2005.training.dataStructure.tree;

/**
 * 二叉搜索树 binary search tree
 * Created by hzlizx on 2019/3/19
 */
public class BST<K extends Comparable, V> {

    private Node<K, V> root;
    private int count;

    public void insert(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value should not be null");
        }
        if (root == null) {
            count++;
            root = new Node<K, V>(key, value);
            return;
        }
        insert(root, key, value);
    }

    public V search(K key) {
        if (key == null) {
            throw new NullPointerException("key should not be null");
        }

        Node<K, V> search = search(root, key);
        return search == null ? null : search.value;
    }

    public V minimum() {
        if (isEmpty()) {
            throw new NullPointerException("tree is null");
        }
        return minimum(root).value;
    }

    public V maximum() {
        if (isEmpty()) {
            throw new NullPointerException("tree is null");
        }
        return maximum(root).value;
    }

    public void delMin() {
        if (isEmpty()) {
            throw new NullPointerException("tree is null");
        }
        count--;
        root = delMin(root);
    }

    public void delMax() {
        if (isEmpty()) {
            throw new NullPointerException("tree is null");
        }
        count--;
        root = delMax(root);
    }

    public void delete(K key) {
        if (isEmpty()) {
            throw new NullPointerException("tree is null");
        }
        if (key == null) {
            throw new NullPointerException("key should not be null");
        }
        count--;
        delete(root, key);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    //先序遍历
    public void preOrder() {
        preOrder(root);
    }

    private Node<K, V> delete(Node<K, V> node, K key) {
        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            Node<K, V> minimum = minimum(node.right);
            delMin(node.right);
            return minimum;
        }
        return node;
    }

    private Node<K, V> delMin(Node<K, V> node) {
        if (node.left == null) {
            if (node.right == null) {
                return null;
            } else {
                return node.right;
            }
        } else {
            node.left = delMin(node.left);
            return node;
        }
    }

    private Node<K, V> delMax(Node<K, V> node) {
        if (node.right == null) {
            if (node.left == null) {
                return null;
            } else {
                return node.left;
            }
        } else {
            node.right = delMax(node.right);
            return node;
        }
    }

    private Node<K, V> minimum(Node<K, V> node) {
        if (node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }

    private Node<K, V> maximum(Node<K, V> node) {
        if (node.right == null) {
            return node;
        } else {
            return maximum(node.right);
        }
    }

    private Node<K, V> search(Node<K, V> node, K key) {
        if (node == null) return null;
        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    private Node<K, V> insert(Node<K, V> node, K key, V value) {
        if (node == null) {
            count++;
            return new Node<K, V>(key, value);
        } else {
            if (key.compareTo(node.key) == 0) {
                node.value = value;
            } else if (key.compareTo(node.key) < 0) {
                node.left = insert(node.left, key, value);
            } else {
                node.right = insert(node.right, key, value);
            }
            return node;
        }
    }

    private void preOrder(Node<K, V> node) {
        if (node == null) return;
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private class Node<K extends Comparable, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
