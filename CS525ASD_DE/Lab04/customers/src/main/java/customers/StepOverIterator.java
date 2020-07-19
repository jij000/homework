package customers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class StepOverIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int position;

    public StepOverIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return position + 1 < list.size();
    }

    @Override
    public T next() {
        if (position % 2 == 1) {
            position++;
        }
        return list.get(position++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
