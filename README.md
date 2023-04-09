# Expression parser with multitype support

## Description

Expression parser with multitype support is a Java Core console-based application which allows you to evaluate expressions
containing up to 3 variables by different number formats: `int`, `double`, `BigInteger` and their modifications. \
The code architecture was written the way allowing you to add new
binary and unary operations easily as well as to create another type of parser which accepts an arbitrary
set of operations. Also architecture allows you to add number formats which can be used for expression evaluation easily: 
just by creating a wrapper over a set of standard arithmetical operations, most of other operations can be easily 
represented as their composition.\
The parser firstly creates nested `expression.ExpressionComparator` objects by recursive descent
parsing and then evaluates the result with `expression.GenericTripleExpression.evaluate()` method. \

Number formats parser can deal with:
* `expression.number_formats.BigIntegerNF` (`bi` mode): wrapper of `java.math.BigInteger`
* `expression.number_formats.CheckedIntegerNF` (`i` mode): wrapper of `int` whose methods throw `expression.exceptions.OverflowException` in case of overflow
* `expression.number_formats.DoubleNF` (`d` mode): wrapper of `double`
* `expression.number_formats.UncheckedIntegerNF` (`u` mode): wrapper of `int`
* `expression.number_formats.UncheckedLong` (`l` mode): wrapper of `long`
* `expression.number_formats.UncheckedShortNF` (`s` mode): wrapper of `short`

Binary operations parser can deal with:
* Add (x + y)
* Subtract (x - y)
* Multiply (x * y)
* Divide (x / y)
* Mod (x mod y): returns x % y for primitive types and x.mod(y) for `java.math.BigInteger`

Unary operations parser can deal with:
* Negate (- x)
* Abs (abs x): absolute value
* Square (square x): square of x

## Requirements

* Java [JDK 17+]

## Usage

Java source root is _/java-solutions_, all _.java_ files should be compiled.\
To run parser use:
```
 java expression.generic.Main -[mode] "[expression]"
```
Note that variable names in the expression should be _x_, _y_ and _z_. The output will be result of expression evaluation for all integer combinations of x [-2..2], y [-2..2], z [-2..2].\
For example:
```
 java expression.generic.Main -i "2*x mod 1 + abs y+4 + z"
```
should output:
```
 R[-2][-2][-2] = 4
 R[-2][-2][-1] = 5
 R[-2][-2][0] = 6
 R[-2][-2][1] = 7
 R[-2][-2][2] = 8
 ...
```
where R[-2][-2][2] = 8 means _2*(-2) mod 1 + abs (-2)+4 + (2) = 8_.
