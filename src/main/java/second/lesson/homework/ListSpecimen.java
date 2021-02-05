package second.lesson.homework;

public interface ListSpecimen<E> {

    int size();

    E get (int index);

    E set (int index, E essence);

    boolean add (E essence);

    boolean delete (E essence);

    boolean contains (E essence);

    boolean isEmpty ();
}
