import java.util.ArrayList;


/**
 * This class evaluates any postfix expression.
 */
public class Q3_Hall_Graydon {

    /**
     * Uses generic stack that holds integers in order to solve problem.
     */
    private MyStackGeneric<Double> stack;


    /**
     * ArrayList that holds all possible operators so we can identify if a character is an operator.
     */
    private ArrayList<Character> operators;

    public Q3_Hall_Graydon() {
        operators = new ArrayList<Character>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');


    }

    /**
     * This method evaluates a postfix expression and returns the result as a double
     * @param inputString postfix expression to be evaluated
     * @return double result of evaluating the expression
     */
    private double evaluatePostfix(String inputString) {
        char[] chars = inputString.toCharArray();  // character array of string entered by user
        stack = new MyStackGeneric<Double>(inputString.length());


        for (char ch: chars) {
            if(operators.contains(ch)){
                // If item read from postfix expression is an operator, pop the top two operands from
                // the stack and apply the operator to them. Push the result.

                // some help taken from https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/ also
                var val1 = stack.pop();
                var val2 = stack.pop();
                switch(ch)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }

            }
            else{
                // If item read from postfix expression is an operand, then push that item onto the stack
                stack.push(Double.parseDouble(""+ch));  // converts char to double value
            }
        }
        return stack.pop();
    }

    /**
     * main method used to obtain a postfix expression from the user and evaluate it.
     * @param args
     */
    public static void main(String[] args) {
        var r = new KeyboardReader();  // used to get user input
        r.prompt("Enter Postfix: ");
        var str = r.getKeyboardInput();  // user statement as string
        var x = new Q3_Hall_Graydon();  // usedd to evaluate the postfix expression
        System.out.println("Evaluates to " + x.evaluatePostfix(str));  // present result
    }


}
