package expression.number_formats;

public class UncheckedLongNF implements NumberFormat<Long> {
    private final long val;

    public UncheckedLongNF(long val) {
        this.val = val;
    }

    @Override
    public UncheckedLongNF add(NumberFormat<Long> val) {
        return new UncheckedLongNF(this.val + val.getValue());
    }

    @Override
    public UncheckedLongNF subtract(NumberFormat<Long> val) {
        return new UncheckedLongNF(this.val - val.getValue());
    }

    @Override
    public UncheckedLongNF multiply(NumberFormat<Long> val) {
        return new UncheckedLongNF(this.val * val.getValue());
    }

    @Override
    public UncheckedLongNF divide(NumberFormat<Long> val) {
        return new UncheckedLongNF(this.val / val.getValue());
    }

    @Override
    public UncheckedLongNF mod(NumberFormat<Long> val) {
        return new UncheckedLongNF(this.val % val.getValue());
    }

    @Override
    public UncheckedLongNF negate() {
        return new UncheckedLongNF(-val);
    }

    @Override
    public UncheckedLongNF valueOf(int val) {
        return new UncheckedLongNF(val);
    }

    @Override
    public Long getValue() {
        return val;
    }

    @Override
    public int compareTo(Long o) {
        return Long.valueOf(val).compareTo(o);
    }
}
