package StefanAgustoHutapeaJSleepDN;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Algorithm {
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        list.add(value);
        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T>pred) {
        List<T> list = new ArrayList<T>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            T value = iterator.next();
            if (pred.predicate(value)) {
                list.add(value);
            }
        }
        return list;
    }

    public static <T> List<T> collect(T[]array, Predicate<T>pred) {
        List<T> list = new ArrayList<T>();
        for (T value : array) {
            if (pred.predicate(value)) {
                list.add(value);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterator<T>iterator, Predicate<T>pred) {
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext()) {
            T value = iterator.next();
            if (pred.predicate(value)) {
                list.add(value);
            }
        }
        return list;
    }

    public static <T> int count(Iterator<T>iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(Iterable<T>iterable, Predicate<T>pred)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(T[]array, Predicate<T>pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterator<T>iterator, Predicate<T>pred)
    {
        return count(iterator, pred);
    }

    public static <T> int count(Iterable<T>iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> boolean exists(Iterable<T>iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T>iterable, Predicate<T>pred)
    {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[]array, Predicate<T>pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
		return exists(it, pred);
    }

    public static <T> boolean exists(T[]array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
		return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T>iterator, T value)
    {
        final Predicate<T> pred = value::equals;
		return exists(iterator, pred);
    }

    public static <T> boolean exists(Iterator<T>iterator, Predicate<T>pred)
    {
        return exists(iterator, pred);
    }

    public static <T> boolean find(T[]array, Predicate<T>pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
		return find(it, pred);
    }

    public static <T> boolean find(Iterable<T>iterable, Predicate<T>pred)
    {
        final Iterator<T> it = iterable.iterator();
		return find(it, pred);
    }

    public static <T> boolean find(T[]array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
		return find(it, value);
    }

    public static <T> boolean find(Iterable<T>iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
		return find(it, value);
    }

    public static <T> boolean find(Iterator<T>iterator, T value)
    {
        final Predicate<T> pred = value::equals;
		return find(iterator, pred);
    }

    public static <T> boolean find(Iterator<T>iterator, Predicate<T>pred)
    {
        while (iterator.hasNext())
        {
            T value = iterator.next();
            if (pred.predicate(value))
                return true;
        }
        return false;
    }

    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T>pred) {
        List<T> list = new ArrayList<T>();
        int start = page * pageSize;
        int end = start + pageSize - 1;
        for (int i = start; i < end; i++) {
            T value = array[i];
            if (pred.predicate(value)) {
                list.add(value);
            }
        }
        return list;
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T>pred) {
        List<T> list = new ArrayList<T>();
        int start = page * pageSize;
        int end = start + pageSize - 1;
        for (int i = start; i < end; i++) {
            T value = iterator.next();
            if (pred.predicate(value)) {
                list.add(value);
            }
        }
        return list;
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T>pred) {
        List<T> list = new ArrayList<T>();
        int start = page * pageSize;
        int end = start + pageSize - 1;
        Iterator<T> iterator = iterable.iterator();
        for (int i = 0; i < end; i++) {
            T value = iterator.next();
            if (i >= start && pred.predicate(value)) {
                list.add(value);
            }
        }
        return list;
    }
}