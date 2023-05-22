import java.util.ArrayList;

public class LimitedArrayList<E> extends ArrayList<E> {
/**
 * The LimitedArrayList class is a custom implementation of ArrayList that imposes a maximum size limit on the list.
 *
 * @param <E> the type of elements in the list
 */
    private final int maxSize;
    /**
     * Constructs a new LimitedArrayList with the specified maximum size.
     *
     * @param maxSize the maximum size of the list
     */
    public LimitedArrayList(int maxSize) {
        this.maxSize = maxSize;
    }
    /**
     * Adds the specified element to the list if the maximum size has not been reached.
     *
     * @param element the element to be added
     * @return true if the element was added successfully, false otherwise
     */
    @Override
    public boolean add(E element) {
        if (size() < maxSize) {
            return super.add(element);
        }
        return false; // Returns false if the maximum limit is reached
    }
}
