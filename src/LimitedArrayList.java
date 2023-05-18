import java.util.ArrayList;

public class LimitedArrayList<E> extends ArrayList<E> {
    private final int maxSize;

    public LimitedArrayList(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(E element) {
        if (size() < maxSize) {
            return super.add(element);
        }
        return false; // Returns false if the maximum limit is reached
    }
}
