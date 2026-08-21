package ru.itone.course_java.core.basic_collections;

import java.util.ArrayList;
import java.util.List;

public class BTreeClass<T extends Comparable<T>> implements BTree<T> {

    private NodeClass<T> root;

    public void add(T item) {
        if (root == null) {
            root = new NodeClass<>(item);
            return;
        }

        addNode(root, item);
    }

    public void remove(T item) {
        List<NodeClass<T>> nodeAndParent = findNodeAndParent(item);

        NodeClass<T> node = nodeAndParent.getFirst();
        NodeClass<T> parent = nodeAndParent.get(1);

        if (node == null) {
            return;
        }

        if (root == node) {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getLeft() == null || root.getRight() == null) {
                if (root.getLeft() != null) {
                    root = root.getLeft();
                } else {
                    root = root.getRight();
                }
            } else {
                NodeClass<T> next = findNext(root);
                root.setItem(next.getItem());
            }
        } else {
            removeNode(node,  parent);
        }
    }

    public boolean contains(T item) {
        List<NodeClass<T>> nodeAndParent = findNodeAndParent(item);

        NodeClass<T> node = nodeAndParent.getFirst();

        return node != null;
    }

    public List<T>  toList() {
        List<T> list = new ArrayList<>();

        subtreeToList(root, list);

        return list;
    }

    private void addNode(NodeClass<T> node, T item) {
        int compare = item.compareTo(node.getItem());

        if (compare < 0) {
            if (node.getLeft() != null) {
                addNode(node.getLeft(), item);
            } else {
                node.setLeft(new NodeClass<>(item));
            }
        } else if (compare > 0) {
            if (node.getRight() != null) {
                addNode(node.getRight(), item);
            } else {
                node.setRight(new NodeClass<>(item));
            }
        }
    }

    private void removeNode(NodeClass<T> current, NodeClass<T> parent) {
        if (current.getLeft() == null && current.getRight() == null) {
            if (parent.getLeft() == current) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (current.getLeft() == null || current.getRight() == null) {
            if (current.getLeft() == null) {
                if (parent.getLeft() == current) {
                    parent.setLeft(current.getRight());
                } else {
                    parent.setRight(current.getRight());
                }
            } else {
                if (parent.getLeft() == current) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
        } else {
            NodeClass<T> next = findNext(current);
            current.setItem(next.getItem());
        }
    }

    private void subtreeToList(NodeClass<T> node, List<T> list) {
        if (node.getLeft() != null) {
            subtreeToList(node.getLeft(), list);
        }

        list.add(node.getItem());

        if (node.getRight() != null) {
            subtreeToList(node.getRight(), list);
        }
    }

    private List<NodeClass<T>> findNodeAndParent(T item) {
        NodeClass<T> current = root;
        NodeClass<T> parent = null;

        while (current != null && item.compareTo(current.getItem()) != 0) {
            int compare = item.compareTo(current.getItem());

            parent = current;

            if (compare < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        List<NodeClass<T>> result = new ArrayList<>();
        result.add(current);
        result.add(parent);

        return result;
    }

    private NodeClass<T> findNext(NodeClass<T> node) {
        NodeClass<T> current = node.getRight();
        NodeClass<T> parent = node;

        while (current.getLeft() != null) {
            parent = current;
            current = current.getLeft();
        }

        if (parent == node) {
            parent.setRight(current.getRight());
        } else {
            parent.setLeft(current.getRight());
        }

        return current;
    }
}
