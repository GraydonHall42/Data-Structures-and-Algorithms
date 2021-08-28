import java.util.HashMap;

/**
 * This class creates an object that is capable of taking an infix expression and converting it to postfix.
 */
public class Q2_Hall_Graydon {


    /**
     * final postfix expression
     */
    private String outputString ="";


    /**
     * Stack used in solving problem
     */
    private MyStack stack;


    /**
     * hashmap to hold operators, and a number used to determine their precedence.
     */
    private HashMap<Character, Integer> operators;

    /**
     * Constructor class. Hashmap for operators is created within this class.
     */
    public Q2_Hall_Graydon() {
        operators = new HashMap<Character, Integer>();

        // numbers are used to determine precedence.
        operators.put('+',1);
        operators.put('-',1);
        operators.put('*',2);
        operators.put('/',2);

    }

    private String infixToPostfix(String inputString){
        char[] chars = inputString.toCharArray();  // character array of string entered by user
        stack = new MyStack(inputString.length());

        // iterate over `char[]` array using enhanced for-loop
        for (char ch: chars) {
            if(operators.containsKey(ch)){
                // ch is an operator
                var opThis = ch;
                if(stack.isEmpty()){
                    // If stack is empty, push opThis
                    stack.push(opThis);
                }
                else{
                    // Otherwise, while stack not empty, repeat:
                    while (!stack.isEmpty()){
                        var opTop = stack.pop();
                        if(operators.get(opTop) < operators.get(opThis)){
                            // If opTop < opThis, push opTop
                            stack.push(opTop);

                            // Quit loop if opTOP < opThis
                            break;

                        }
                        else if(operators.get(opTop) >= operators.get(opThis)){
                            // If opTop >= opThis, output opTop
                            outputString += opTop;
                        }
                    }
                    // Push opThis
                    stack.push(opThis);
                }
            }
            else{
                // ch is an operand, so add to output string
                outputString += ch;
            }

        }

        while(!stack.isEmpty()){
            // push whole remaining stack to output string
            outputString += stack.pop();
        }

        return outputString;

    }

    /**
     * Main method used to get user input of a infix expression, and then convert it to postfix.
     * @param args
     */
    public static void main(String[] args) {
        var r = new KeyboardReader();  // used to get user input
        r.prompt("Enter infix: ");
        var str = r.getKeyboardInput();  // user statement as string
        var x = new Q2_Hall_Graydon();  // use infix to postfix converter
        System.out.println(x.infixToPostfix(str));  // present result
    }


}
