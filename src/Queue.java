public class Queue<E> implements QueueGeneric<E> {
    private Node<E> head;
    private int size;

    // constructor
    public Queue( ) {
        head = null;
        size = 0;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;
        // constructor
        public Node( E element ) {
            this.element = element;
            this.next = null;
        }
    }

    @Override
    public void offer( E element ) {
        Node<E> newNode = new Node<>(element);

        if ( head == null ) {
            head = newNode;
        } else {
            Node<E> current = head;
            while ( current.next != null ) {
                current = current.next;
            }

            current.next = newNode;
        }
        size++;
    }
    @Override
    public E poll( ) {

        E temp = head.element;

        Node<E> nextNode = head.next;
        head.next = null;
        head = nextNode;
        size--;
        return temp;
    }
    @Override
    public E peek( ) {
        return head.element;
    }
    @Override
    public int size( ) {
        return size;
    }
    @Override
    public boolean isEmpty( ) {
        if ( size == 0 && head == null ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString( ) {
        StringBuilder result = new StringBuilder( "[" );
        Node<E> current = head;
        while ( current != null ) {
            result.append( current.element );
            if ( current.next != null ) {
                result.append( ", " );
            }
            current = current.next;
        }
        result.append( "]" );
        return result.toString( );
    }
}
