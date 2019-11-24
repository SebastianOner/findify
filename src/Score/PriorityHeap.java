package Score;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implemented as fibonacci heap
 */
final class PriorityHeap<T> {
    private Node<T> max = null;
    private int size = 0;

    private static <T> Node<T> mergeLists(Node<T> one, Node<T> two) {
        if (one == null && two == null) {
            return null;
        } else if (one != null && two == null) {
            return one;
        } else if (one == null && two != null) {
            return two;
        } else {
            Node<T> oneNext = one.next;
            one.next = two.next;
            one.next.previous = one;
            two.next = oneNext;
            two.next.previous = two;
            return one.priority > two.priority ? one : two;
        }
    }

    public Node<T> enqueue(T object, double priority) {
        checkPriority(priority);
        Node<T> newNode = new Node<T>(object, priority);
        max = mergeLists(max, newNode);
        ++size;
        return newNode;
    }

    Node<T> max() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return max;
    }

    boolean isEmpty() {
        return max == null;
    }

    int size() {
        return size;
    }

    Node<T> dequeueMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        --size;
        Node<T> maxElem = max;
        if (max.next == max) {
            max = null;
        } else {
            max.previous.next = max.next;
            max.next.previous = max.previous;
            max = max.next;
        }
        if (maxElem.child != null) {
            Node<?> current = maxElem.child;
            do {
                current.parent = null;
                current = current.next;
            } while (current != maxElem.child);
        }
        max = mergeLists(max, maxElem.child);
        if (max == null)
            return maxElem;
        List<Node<T>> nodes = new ArrayList<>();
        List<Node<T>> toVisit = new ArrayList<>();
        for (Node<T> current = max;
             toVisit.isEmpty() || toVisit.get(0) != current;
             current = current.next)
            toVisit.add(current);
        for (Node<T> current : toVisit) {
            while (true) {
                while (current.degree >= nodes.size())
                    nodes.add(null);
                if (nodes.get(current.degree) == null) {
                    nodes.set(current.degree, current);
                    break;
                }
                Node<T> other = nodes.get(current.degree);
                nodes.set(current.degree, null);
                Node<T> max =
                        (other.priority > current.priority) ? other : current;
                max.next.previous = max.previous;
                max.previous.next = max.next;
                max.next = max.previous = max;
                max.child = mergeLists(max.child, max);
                max.parent = max;
                max.isMarked = false;
                ++max.degree;
                current = max;
            }
            if (current.priority >= max.priority)
                max = current;
        }
        return maxElem;
    }

    void IncreaseKey(T object, double newPriority) {
        Node node = find(object);
        checkPriority(newPriority);
        if (newPriority < node.priority)
            throw new IllegalArgumentException("New priority exceeds old.");
        decreaseKeyUnchecked(node, newPriority);
    }

    //	public void delete(Node<T> node){
    //		decreaseKeyUnchecked(node, Double.NEGATIVE_INFINITY);
    //		dequeueMax();
    //	}
    private void checkPriority(double priority) {
        if (Double.isNaN(priority))
            throw new IllegalArgumentException(priority + " is invalid.");
    }

    private void decreaseKeyUnchecked(Node<T> node, double priority) {
        node.priority = priority;
        if (node.parent != null && node.priority <= node.parent.priority)
            cutNode(node);
        if (node.priority >= max.priority)
            max = node;
    }

    private void cutNode(Node<T> node) {
        node.isMarked = false;
        if (node.parent == null)
            return;
        if (node.next != node) {
            node.next.previous = node.previous;
            node.previous.next = node.next;
        }
        if (node.parent.child == node) {
            if (node.next != node) {
                node.parent.child = node.next;
            } else {
                node.parent.child = null;
            }
        }
        --node.parent.degree;
        node.previous = node.next = node;
        max = mergeLists(max, node);
        if (node.parent.isMarked)
            cutNode(node.parent);
        else
            node.parent.isMarked = true;
        node.parent = null;
    }

    double getPriority(SemanticWeb.Entry.Reference unvisitedReference) {
        return 1;
    }

    Node find(T object) {
        Node current = max;
        do {
            while (current.degree > 0) {
                if (object == current.getObject())
                    return current;
                current = current.child;
            }
            current = current.next;
        } while (current != max);

        return null;
    }

    static final class Node<T> {
        private int degree = 0;
        private boolean isMarked = false;
        private Node<T> next;
        private Node<T> previous;
        private Node<T> parent;
        private Node<T> child;
        private T object;
        private double priority;

        private Node(T object, double priority) {
            next = previous = this;
            this.object = object;
            this.priority = priority;
        }

        T getObject() {
            return object;
        }

        void setObject(T object) {
            this.object = object;
        }

        double getPriority() {
            return priority;
        }
    }
}