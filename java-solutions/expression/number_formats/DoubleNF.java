package expression.number_formats;

public class DoubleNF implements NumberFormat<Double> {
    private final double val;

    public DoubleNF(double val) {
        this.val = val;
    }

    @Override
    public DoubleNF add(NumberFormat<Double> val) {
        return new DoubleNF(this.val + val.getValue());
    }

    @Override
    public DoubleNF subtract(NumberFormat<Double> val) {
        return new DoubleNF(this.val - val.getValue());
    }

    @Override
    public DoubleNF multiply(NumberFormat<Double> val) {
        return new DoubleNF(this.val * val.getValue());
    }

    @Override
    public DoubleNF divide(NumberFormat<Double> val) {
        return new DoubleNF(this.val / val.getValue());
    }

    @Override
    public DoubleNF mod(NumberFormat<Double> val) {
        return new DoubleNF(this.val % val.getValue());
    }

    @Override
    public DoubleNF negate() {
        return new DoubleNF(-val);
    }

    @Override
    public DoubleNF valueOf(int val) {
        return new DoubleNF(val);
    }

    @Override
    public Double getValue() {
        return val;
    }

    @Override
    public int compareTo(Double o) {
        return Double.valueOf(val).compareTo(o);
    }
}
