import java.lang.reflect.Array;

public class MyList<T> {

    private Node<T> currentNode;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T value) {
        if (currentNode == null) {
            currentNode = new Node(value);
        } else {
            currentNode.next = new Node(value);
            Node temp = currentNode;
            currentNode = currentNode.next;
            currentNode.previous = temp;
        }
        size++;
        return true;
    }

    public boolean remove(T value) {
        Node<T> tempNode = currentNode;
        while (tempNode.previous != null)
            tempNode = tempNode.previous;

        while (tempNode != null) {
            if (tempNode.value == value) {
                tempNode.previous.next = tempNode.next;
                tempNode.next.previous = tempNode.previous;
                size--;
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> tempNode = currentNode;
        while (tempNode.previous != null)
            tempNode = tempNode.previous;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.value;
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size)
            return null;

        Node<T> tempNode = currentNode;
        while (tempNode.previous != null)
            tempNode = tempNode.previous;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        tempNode.value = value;

        return value;
    }

    public void add(int index, T value) {
        if (index < 0 || index >= size)
            return;

        Node<T> tempNode = currentNode;
        while (tempNode.previous != null)
            tempNode = tempNode.previous;

        T temp = null;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                temp = tempNode.value;
                tempNode.value = value;
                break;
            }
            tempNode = tempNode.next;
        }

        addNextElement(temp, tempNode);

    }

    private void addNextElement(T value, Node<T> tempNode) {
        if (value == null)
            return;

        if (tempNode.next == null) {
            tempNode.next = new Node<>(value);
            tempNode.next.previous = tempNode;
            currentNode = tempNode.next;
            size++;
        } else {
            tempNode = tempNode.next;
            T tempValue = tempNode.value;
            tempNode.value = value;

            addNextElement(tempValue, tempNode);
        }
    }


    // Different way of implementing add method
//    public void add(int index, T value) {
//        if (index < -1 || index >= size)
//            return;
//
//        Node<T> tempNode = currentNode;
//        while (tempNode.previous != null)
//            tempNode = tempNode.previous;
//
//        T tempValue;
//        for (int i = 0; i < index; i++) {
//            tempNode = tempNode.next;
//        }
//        tempValue = tempNode.value;
//        tempNode.value = value;
//
//        for (int i = index + 1; i <= size; i++) {
//            if (tempNode.next == null) {
//                tempNode.next = new Node<>(tempValue);
//                tempNode.next.previous = tempNode;
//            } else {
//                tempNode = tempNode.next;
//                T temp = tempNode.value;
//                tempNode.value = tempValue;
//                tempValue = temp;
//            }
//        }
//        currentNode = tempNode.next;
//        size++;
//    }

    public boolean contains(T value) {
        Node<T> tempNode = currentNode;
        while (tempNode.previous != null)
            tempNode = tempNode.previous;

        while (tempNode != null) {
            if (tempNode.value == value)
                return true;
            tempNode = tempNode.next;
        }
        return false;
    }

    public boolean containsAll(MyList<T> list) {
        if (list == null)
            return false;

        if (list.size != list.size())
            return false;

        for (int i = 0; i < this.size; i++) {
            if (!(this.get(i).equals(list.get(i)))) {
                return false;
            }
        }

        return true;
    }

    public Object[] toArray() {
        Node<T> tempNode = currentNode;
        while (tempNode.previous != null)
            tempNode = tempNode.previous;

        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = tempNode.value;
            tempNode = tempNode.next;
        }
        return array;
    }

    public <T> T[] toArray(T[] arr) {
        Node tempNode = currentNode;
        while (tempNode.previous != null)
            tempNode = tempNode.previous;

        T array[] = (T[]) Array.newInstance(arr.getClass().getComponentType(), size);

        for (int i = 0; i < size; i++) {
            array[i] = (T) tempNode.value;
            tempNode = tempNode.next;
        }
        return array;
    }

    public void clear() {
        this.size = 0;
        this.currentNode = null;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        String string = currentNode.value.toString();
        Node<T> tempNode = currentNode;

        for (int i = 1; i < size; i++) {
            tempNode = tempNode.previous;
            string = tempNode.value.toString() + ", " + string;
        }

        return "[" + string + "]";
    }

    private class Node<T> {
        Node<T> previous;
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
