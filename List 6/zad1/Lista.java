import java.io.Serializable;

public class Lista<T> implements Serializable
{
    public Node<T> head;
    public Node<T> end;

    public Lista()
    {
        head = null;
        end = null;
    }

    public void addFront(T x)
    {
        if (head == null)
        {
            head = new Node<T>();
            head.value = x;
            head.next = end;
        }
        else
        {
            Node<T> y = new Node<T>();
            y.value = x;
            y.next = head;
            head = y;
        }
    }

    public void addBack(T x)
    {
        if (end == null)
        {
            end = new Node<T>();
            end.value = x;
            if (head != null)
            {
                head.next = end;
                end.prev = head;
            }
        }
        else
        {
            Node<T> y = new Node<T>();
            y.value = x;
            y.next = null;
            end.next = y;
            y.prev = end;
            end = y;
        }
    }

    public T delFront()
    {
        if (isEmpty())
        {
            System.out.println("Lista jest pusta! Nie mogę usunąć elementu.");
            return null;
        }

        T temp = head.value;
        head = head.next;
        head.prev = null;
        return temp;
    }

    public T delBack()
    {

        if (isEmpty())
        {
            System.out.println("Lista jest pusta! Nie mogę usunąć elementu.");
            return null;
        }


        end.prev.next = null;
        end = end.prev;
        return end.value;
    }

    public boolean isEmpty()
    {
        return head == null && end == null;
    }

    public void writeNodes()
    {
        Node<T> temp = head;

        while (temp != null)
        {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}