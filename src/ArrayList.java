public class ArrayList<E> implements ArrayListGeneric<E> {
    private final int DEFAULT_CAPACITY = 5;
    private E[] elements;
    private int index = 0;

    // constructor
    public ArrayList( ) {
        this.elements = (E[]) new Object[ DEFAULT_CAPACITY ];
    }
    @Override
    public boolean add( E element ) {
        if ( this.index == elements.length ) {
            this.elements = Array.copyOf( this.elements, this.elements.length * 2 );
        }

        this.elements[ this.index ] = element;
        this.index = this.index + 1;
        return true;

    }
    @Override
    public boolean add( int index, E element ) {
        if ( index < 0 || index > this.index - 1 ) {
            throw new IndexOutOfBoundsException( "Index out of bound." );
        }

        if ( this.index == elements.length ) {
            this.elements = Array.copyOf( this.elements, this.elements.length * 2 );
        }

        // 1: move data to the right -> loop
        for ( int i = this.index; i > index; i-- ) {
            elements[ i ] = elements[ i - 1 ];
        }

        // 2: insert new data
        elements[ index ] = element;
        this.index = this.index + 1;

        return true;
    }

    public boolean replace ( int index, E element ){
        if ( index < 0 || index > this.index - 1 ) {
            throw new IndexOutOfBoundsException( "Index out of bound." );
        }
        elements[ index ] = element;
        return true;
    }

    @Override
    public E get( int index ) {
        if ( index < 0 || index > this.index - 1 ) {
            throw new IndexOutOfBoundsException( "Index out of bound." );
        }
        return this.elements[ index ];
    }
    @Override
    public E set( int index, E element ) {
        if ( index < 0 || index > this.index - 1 ) {
            throw new IndexOutOfBoundsException( "Index out of bound." );
        }

        E temp = this.elements[ index ];
        this.elements[ index ] = element;
        return temp;
    }
    @Override
    public E remove( int index ) {
        if ( index < 0 || index > this.index - 1 ) {
            throw new IndexOutOfBoundsException( "Index out of bound." );
        }

        E temp = this.elements[ index ];

        for ( int i = index; i < this.index - 1; i++ ) {
            this.elements[ i ] = elements[ i + 1 ];
        }

        this.elements[ this.index - 1 ] = null;
        this.index = this.index - 1;

        // check and decrease array size if needed
        if ( this.index <= elements.length / 3 ) {
            this.elements = Array.copyOf( this.elements, this.elements.length / 2 );
        }

        return temp;
    }
    @Override
    public int size( ) {
        return this.index - 1;
    }
    @Override
    public int indexOf( E element ) {
        int result = -1;
        for ( int i = 0; i < this.index - 1; i++ ) {
            if ( elements[ i ] == element ) {
                result = i;
                break;
            }
        }
        return result;
    }
    @Override
    public boolean contains( E element ) {
        boolean result = false;
        for ( int i = 0; i <= this.index - 1; i++ ) {
            if ( elements[ i ] == element ) {
                result = true;
                break;
            }
        }
        return result;
    }
    @Override
    public boolean isEmpty( ) {
        if ( size( ) == 0 ) { // if empty returns true
            return true;
        } else { // if not empty returns false
            return false;
        }
    }
    @Override
    public String toString( ) {
        return Array.toString( elements );
    }
}
