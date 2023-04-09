package expression.number_formats;

public interface NumberFormat<E> extends Comparable<E> {
    NumberFormat<E> add(NumberFormat<E> val);
    NumberFormat<E> subtract(NumberFormat<E> val);
    NumberFormat<E> multiply(NumberFormat<E> val);
    NumberFormat<E> divide(NumberFormat<E> val);
    NumberFormat<E> mod(NumberFormat<E> val);
    NumberFormat<E> negate();
    NumberFormat<E> valueOf(int val);
    E getValue();
}
