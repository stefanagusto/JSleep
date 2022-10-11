package StefanAgustoHutapeaJSleepDN;
import java.util.Iterator;
import java.util.Arrays;

public class Algorithm {
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
}