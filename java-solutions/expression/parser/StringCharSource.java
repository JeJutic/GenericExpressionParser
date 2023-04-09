package expression.parser;

import java.text.ParseException;

public class StringCharSource implements CharSource {
    private final String str;
    private int pos;

    public StringCharSource(String str) {
        this.str = str;
        pos = 0;
    }

    @Override
    public char get(int off) {
        return str.charAt(pos + off);
    }

    @Override
    public boolean eof(int off) {
        return pos + off >= str.length();
    }

    @Override
    public void next() {
        pos++;
    }

    @Override
    public ParseException error(String message) {
        return new ParseException("String at position " + pos + ": " + message, pos);
    }
}
