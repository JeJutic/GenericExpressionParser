package expression.parser;

import expression.*;
import expression.plugins.*;

import java.text.ParseException;
import java.util.List;

public class ExpressionToComparatorParser extends BaseParser {
    private final static String[] varNames = Variable.getVarNames();
    private final List<BinaryOperatorPlugin> binaryPlugins;
    private final List<UnaryOperatorPlugin> unaryPlugins;

    public ExpressionToComparatorParser(
            CharSource source,
            List<BinaryOperatorPlugin> binaryPlugins,
            List<UnaryOperatorPlugin> unaryPlugins
    ) {
        super(source);
        this.binaryPlugins = binaryPlugins;
        this.unaryPlugins = unaryPlugins;
    }

    public ExpressionComparator parse() throws ParseException {
        ExpressionComparator expr = subParse();
        if (test(')')) {
            throw error("No closing bracket expected at the end");
        }
        return expr;
    }

    private ExpressionComparator subParse() throws ParseException {
        return parseSequence(EXPRESSION_PRIORITY.NONE);
    }

    private boolean isLegalDelimiter(char c) {
        return Character.isWhitespace(c) || c == '(' || c == ')' ||
                c == '+' || c == '-' || c == '*' || c == '/';
    }

    private ExpressionComparator binaryPluginCheck(
            BinaryOperatorPlugin plugin, EXPRESSION_PRIORITY priority, ExpressionComparator left
    ) throws ParseException {
        char test = testGetNext(plugin.getOpStr());
        char lastTaken = getLastTaken();
        if (test != BaseParser.FAIL && plugin.compareTo(priority) > 0) {
            if (!plugin.isNeedsWs() || (isLegalDelimiter(lastTaken) && isLegalDelimiter(test))) {
                take(plugin.getOpStr());
                return plugin.create(left, parseSequence(plugin.getPriority()));
            }
        }
        return null;
    }

    private ExpressionComparator unaryPluginCheck(
            UnaryOperatorPlugin plugin
    ) throws ParseException {
        char test = testGetNext(plugin.getOpStr());
        char lastTaken = getLastTaken();
        if (test != BaseParser.FAIL) {
            if (!plugin.isNeedsWs() || (isLegalDelimiter(test)) &&
                    (lastTaken == BaseParser.FAIL || isLegalDelimiter(lastTaken))) {
                take(plugin.getOpStr());
                return plugin.create(parseSequence(EXPRESSION_PRIORITY.UNARY_OPERATOR));
            }
        }
        return null;
    }

    private ExpressionComparator parseSequence(EXPRESSION_PRIORITY priority) throws ParseException {
        ExpressionComparator left = parseElement();
        while (!eof() && !test(')')) {
            ExpressionComparator middle = null;
            for (BinaryOperatorPlugin plugin : binaryPlugins) {
                if (middle == null) {
                    middle = binaryPluginCheck(plugin, priority, left);
                }
            }
            if (middle == null) {
                if (priority == EXPRESSION_PRIORITY.NONE) {
                    throw error("Unknown binary operation");
                }
                break;
            }
            left = middle;
        }
        return left;
    }

    private ExpressionComparator parseElement() throws ParseException {
        skipWhitespaces();
        ExpressionComparator left = null;
        for (int i = 0; i < 3; i++) {
            if (take(varNames[i])) {
                left = new Variable(varNames[i]);
                break;
            }
        }
        if (left == null) {
            if (test('-') && !eof() && Character.isDigit(testGetNext("-"))) {
                take();
                int a = parsePositiveInt(true);
                left = new Const(a);
            }
            for (UnaryOperatorPlugin plugin : unaryPlugins) {
                if (left != null) {
                    break;
                }
                left = unaryPluginCheck(plugin);
            }
            if (left == null) {
                if (test(Character::isDigit)) {
                    int a = parsePositiveInt(false);
                    left = new Const(a);
                } else if (take('(')) {
                    left = subParse();
                    expect(')');
                } else if (eof() || test(')')) {
                    throw error("Not empty sequence expected");
                } else {
                    throw error("An element or unary operation supposed, unknown sequence of characters found");
                }
            }
        }
        skipWhitespaces();
        return left;
    }

    public void skipWhitespaces() {
        while (take(Character::isWhitespace)) {
        }
    }

    private int parsePositiveInt(boolean neg) throws ParseException {
        StringBuilder sb = new StringBuilder(neg ? "-" : "");
        do {
            sb.append(take());
        } while (test(Character::isDigit));

        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            throw error("Unable to parse the integer: " + e.getMessage());
        }
    }
}