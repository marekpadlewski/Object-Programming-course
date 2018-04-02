import java.io.Serializable;

public class Node<T> implements Serializable{
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node()
    {
        next = null;
        prev = null;
        value = null;
    }
}
