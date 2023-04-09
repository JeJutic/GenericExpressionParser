package expression.number_formats;

import java.math.BigInteger;

public class BigIntegerNF implements NumberFormat<BigInteger> {
    private final BigInteger val;

    public BigIntegerNF(BigInteger val) {
        this.val = val;
    }

    public BigIntegerNF(int val) {
        this.val = BigInteger.valueOf(val);
    }

    @Override
    public BigIntegerNF add(NumberFormat<BigInteger> val) {
        return new BigIntegerNF(this.val.add(val.getValue()));
    }

    @Override
    public BigIntegerNF subtract(NumberFormat<BigInteger> val) {
        return new BigIntegerNF(this.val.subtract(val.getValue()));
    }

    @Override
    public BigIntegerNF multiply(NumberFormat<BigInteger> val) {
        return new BigIntegerNF(this.val.multiply(val.getValue()));
    }

    @Override
    public BigIntegerNF divide(NumberFormat<BigInteger> val) {
        return new BigIntegerNF(this.val.divide(val.getValue()));
    }

    @Override
    public BigIntegerNF mod(NumberFormat<BigInteger> val) {
        return new BigIntegerNF(this.val.mod(val.getValue()));
    }

    @Override
    public BigIntegerNF negate() {
        return new BigIntegerNF(this.val.negate());
    }

    @Override
    public BigIntegerNF valueOf(int val) {
        return new BigIntegerNF(val);
    }

    @Override
    public BigInteger getValue() {
        return val;
    }

    @Override
    public int compareTo(BigInteger o) {
        return this.val.compareTo(o);
    }
}
