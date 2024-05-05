public interface QueueGeneric<E> {
    void offer( E element ); // ~ push
    E poll( ); // ~ pop
    E peek( ); // ~ peek
    int size( );
    boolean isEmpty( );
}
