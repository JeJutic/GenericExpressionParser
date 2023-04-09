package expression.parser;

@FunctionalInterface
public interface TokenPredicate {
	boolean test(char c);
}