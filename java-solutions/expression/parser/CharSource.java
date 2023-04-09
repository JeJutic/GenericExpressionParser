package expression.parser;

import java.text.ParseException;

public interface CharSource {
    char get(int off);
    boolean eof(int off);
    void next();
    ParseException error(String message);
}
