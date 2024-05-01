public class Array {
    public static <T> T[] copyOf(T[] original, int newLength) {
        @SuppressWarnings("unchecked")
        T[] copy = (T[]) new Object[newLength];
        for (int i = 0; i < original.length && i < newLength; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    public static <T> String toString(T[] array) {
        if (array == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.valueOf(array[i]));
        }
        sb.append(']');
        return sb.toString();
    }
}
