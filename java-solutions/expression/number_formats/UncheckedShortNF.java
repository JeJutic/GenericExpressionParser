package expression.number_formats;

public class UncheckedShortNF implements NumberFormat<Short> {
    private final short val;

    public UncheckedShortNF(short val) {
        this.val = val;
    }

    public UncheckedShortNF(int val) {
        this.val = (short) val;
    }

    @Override
    public UncheckedShortNF add(NumberFormat<Short> val) {
        return new UncheckedShortNF(this.val + val.getValue());
    }

    @Override
    public UncheckedShortNF subtract(NumberFormat<Short> val) {
        return new UncheckedShortNF(this.val - val.getValue());
    }

    @Override
    public UncheckedShortNF multiply(NumberFormat<Short> val) {
        return new UncheckedShortNF(this.val * val.getValue());
    }

    @Override
    public UncheckedShortNF divide(NumberFormat<Short> val) {
        return new UncheckedShortNF(this.val / val.getValue());
    }

    @Override
    public UncheckedShortNF mod(NumberFormat<Short> val) {
        return new UncheckedShortNF(this.val % val.getValue());
    }

    @Override
    public UncheckedShortNF negate() {
        return new UncheckedShortNF(-val);
    }

    @Override
    public UncheckedShortNF valueOf(int val) {
        return new UncheckedShortNF(val);
    }

    @Override
    public Short getValue() {
        return val;
    }

    @Override
    public int compareTo(Short o) {
        return Short.valueOf(val).compareTo(o);
    }
}
