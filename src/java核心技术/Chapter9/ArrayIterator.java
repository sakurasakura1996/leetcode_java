package java核心技术.Chapter9;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName ArrayIterator
 * @Date 2020/12/7 21:37
 * @Created by sakura
 * 分析：
 **/
public class ArrayIterator<T> implements Iterable<T>, Iterator<T> {
    private final static String[] names = {"rose", "tuplia", "sakura"};

    public static void main(String[] args) {
        ArrayIterator<String> arrayIterator = new ArrayIterator<>(names);

        arrayIterator.forEach(System.out::println);

    }

    protected T[] data;

    protected int index = 0;

    public ArrayIterator(final T[] data) {
        setData(data);
    }

    public void setData(final T[] d){
        this.data = d;
        index = 0;
    }

    public boolean hasNext() {
        return index < data.length;
    }

    public T next() {
        if (hasNext()){
            return data[index++];
        }
        throw new NoSuchElementException("only" + data.length + "elements");
    }

    public void remove(){
        throw new UnsupportedOperationException("this demo Iterator does not implement the remove method");
    }

    public Iterator<T> iterator() {
        index = 0;
        return this;
    }
}
