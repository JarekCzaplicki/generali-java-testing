package tdd;

import java.util.*;

public class MyList<E> implements List<E> {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i]))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return (E) elements[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) { // Do poprawienia jako zadanie
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        // sprawdzić czy jest miejsce
        ensureCapacity();
        elements[size++] = e;
        return true;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    removeElementAtIndex(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    removeElementAtIndex(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void removeElementAtIndex(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Invalid index");

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            modified = add(element);
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Invalid index");

        Object[] newArray = c.toArray();
        int newSize = size + newArray.length;
        if (newSize > elements.length) {
            increeseCapacity(newSize);
        }
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elements, index, elements, index + newArray.length, numMoved);

        System.arraycopy(newArray, 0, elements, index, newArray.length);
        size = newSize;
        return newArray.length != 0;
    }

    private void increeseCapacity(int minCapacity) {
        int newCapacity = elements.length + (elements.length >> 1);
        if (newCapacity < minCapacity) newCapacity = minCapacity;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; ) {
            if (c.contains(elements[i])) {
                removeElementAtIndex(i);
                modified = true;
            } else i++;
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; ) {
            if (!c.contains(elements[i])) {
                removeElementAtIndex(i);
                modified = true;
            } else i++;
        }
        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException("Invalid index");
        @SuppressWarnings("Unchecked")
        E element = (E) elements[index];
        return element;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
