package customers;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AgeIterator<T> implements Iterator<Customer> {
    private List<Customer> list;
    private int position = 0;

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Customer next() {
        return this.list.get(position++);
    }

    public AgeIterator(List<Customer> list) {
        this.list = list.stream().sorted((x, y) -> x.getAge() - y.getAge()).collect(Collectors.toList());
    }
}
