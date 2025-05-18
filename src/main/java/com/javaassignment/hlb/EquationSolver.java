package com.javaassignment.hlb;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves a series of mathematical equations sequentially, where each equation can use the result of
 * the previous equation (represented by 'x').
 */
public class EquationSolver {

  /**
   * Solves a sequence of equations by substituting each result into the next equation.
   *
   * @param input The initial input value for the first equation
   * @param equations Array of equation strings to solve sequentially
   * @return The final result after evaluating all equations
   * @throws IllegalArgumentException if any equation is invalid
   */
  public static double solveEquations(double input, String[] equations) {
    // Process each equation in sequence
    for (String equation : equations) {
      try {
        // Evaluate current equation with current input value
        input = evaluateEquation(input, equation);
//        System.out.println("Intermediate result: " + input);
      } catch (Exception e) {
        // Wrap and rethrow with contextual information
        System.err.println("Error evaluating equation: " + equation);
        e.printStackTrace();
        throw new IllegalArgumentException("Invalid equation: " + equation, e);
      }
    }
    return input;
  }

  /**
   * Evaluates a single equation by substituting the input value for 'x'.
   *
   * @param input The value to substitute for 'x'
   * @param equation The equation string to evaluate
   * @return The result of the evaluated equation
   */
  private static double evaluateEquation(double input, String equation) {
    // Replace 'x' with the current input value
    String expr = substituteVariable(equation, input);

    // Parse the expression into numbers and operators
    ExpressionTokens tokens = parseExpression(expr);

    // Evaluate respecting operator precedence
    return evaluateWithPrecedence(tokens);
  }

  /**
   * Substitutes a numeric value for the variable 'x' in an equation.
   *
   * @param equation The equation string containing 'x'
   * @param value The numeric value to substitute
   * @return Equation with 'x' replaced by the value
   */
  private static String substituteVariable(String equation, double value) {
    return equation.replace("x", Double.toString(value));
  }

  /**
   * Parses a mathematical expression into numbers and operators.
   *
   * @param expression The expression string to parse
   * @return ExpressionTokens containing separated numbers and operators
   * @throws IllegalArgumentException if expression is malformed
   */
  private static ExpressionTokens parseExpression(String expression) {
    List<Double> numbers = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    StringBuilder numBuilder = new StringBuilder();

    // Process each character in the expression
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      // Check if character is part of a number (digit, decimal, or valid negative sign)
      if (isPartOfNumber(ch, i, expression, !numBuilder.isEmpty())) {
        numBuilder.append(ch);
      }
      // Handle operators
      else if (isOperator(ch)) {
        completeNumber(numBuilder, numbers);
        operators.add(ch);
      }
      // Other characters (like whitespace) are ignored
    }

    // Add the final accumulated number
    completeNumber(numBuilder, numbers);

    // Validate we have proper operator/number pairing
    validateParsing(numbers, operators, expression);

    return new ExpressionTokens(numbers, operators);
  }

  /**
   * Determines if a character should be considered part of a number.
   *
   * @param ch The character to check
   * @param position Current position in the string
   * @param expression Full expression string
   * @param hasDigits Whether we've already seen digits for current number
   * @return true if character is part of a number
   */
  private static boolean isPartOfNumber(char ch, int position, String expression,
    boolean hasDigits) {
    return Character.isDigit(ch) ||  // Digit
      ch == '.' ||             // Decimal point
      (ch == '-' && (position == 0 || // Negative sign at start
        isOperator(expression.charAt(position - 1)) || // Or after operator
        !hasDigits)); // Or before any digits (for negative numbers)
  }

  /**
   * Checks if a character is a supported operator.
   */
  private static boolean isOperator(char ch) {
    return "+-*/".indexOf(ch) != -1;
  }

  /**
   * Finalizes the current number being built and adds it to the numbers list.
   */
  private static void completeNumber(StringBuilder builder, List<Double> numbers) {
    if (!builder.isEmpty()) {
      try {
        numbers.add(Double.parseDouble(builder.toString()));
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid number format: " + builder.toString());
      }
      builder.setLength(0); // Reset builder
    }
  }

  /**
   * Validates that numbers and operators are properly paired.
   */
  private static void validateParsing(List<Double> numbers, List<Character> operators,
    String expression) {
    // For N numbers there should be N-1 operators
    if (numbers.size() != operators.size() + 1) {
      throw new IllegalArgumentException(
        "Mismatched numbers and operators in expression: " + expression +
          " (Numbers: " + numbers.size() + ", Operators: " + operators.size() + ")"
      );
    }
  }

  /**
   * Evaluates an expression respecting operator precedence.
   *
   * @param tokens Parsed expression components
   * @return Final result of evaluation
   */
  private static double evaluateWithPrecedence(ExpressionTokens tokens) {
    // First evaluate multiplication and division (higher precedence)
    evaluateOperations(tokens, List.of('*', '/'));

    // Then evaluate addition and subtraction (lower precedence)
    evaluateOperations(tokens, List.of('+', '-'));

    // After evaluation there should be exactly one number remaining
    if (tokens.numbers.size() != 1) {
      throw new IllegalStateException("Evaluation failed - unexpected remaining operands");
    }

    return tokens.numbers.get(0);
  }

  /**
   * Evaluates specific operations in an expression.
   *
   * @param tokens Parsed expression components
   * @param opsToEvaluate List of operators to evaluate in this pass
   */
  private static void evaluateOperations(ExpressionTokens tokens, List<Character> opsToEvaluate) {
    for (int i = 0; i < tokens.operators.size(); ) {
      char op = tokens.operators.get(i);
      if (opsToEvaluate.contains(op)) {
        // Apply the operation to current operands
        double result = applyOperation(
          tokens.numbers.get(i),
          tokens.numbers.get(i + 1),
          op
        );

        // Replace operands with result
        tokens.numbers.set(i, result);
        tokens.numbers.remove(i + 1);
        tokens.operators.remove(i);
      } else {
        i++; // Skip other operators
      }
    }
  }

  /**
   * Applies a mathematical operation to two operands.
   *
   * @throws ArithmeticException for division by zero
   * @throws IllegalArgumentException for unknown operators
   */
  private static double applyOperation(double left, double right, char operator) {
    return switch (operator) {
      case '+' -> left + right;
      case '-' -> left - right;
      case '*' -> left * right;
      case '/' -> {
        if (right == 0)
          throw new ArithmeticException("Division by zero");
        yield left / right;
      }
      default -> throw new IllegalArgumentException("Unknown operator: " + operator);
    };
  }

  /**
   * Helper class to hold parsed components of a mathematical expression.
   *
   * @param numbers List of numeric operands
   * @param operators List of operators between operands
   */
    private record ExpressionTokens(List<Double> numbers, List<Character> operators) {  }
}
