import java.util.HashMap;


// **** At first when I did the question I thought we had to account for different types
// of brackets... realized after that really wasn't required. Figured there was no sense
// taking it out after though, sorry about that!*******


/**
 * Class used to take a string containing parenthesis, and verify if the statement is properly balanced.
 */
public class Q1_Hall_Graydon {


    /**
     * Stack used to hold brackets
     */
    MyStack bracketStack;


    /**
     * Used to hold input string from user
     */
    String bracketStr;


    /**
     * Hash map used to hold the matching opening bracket for every closing bracket.
     * Key = closing bracket, value = matching opening bracket.
     */
    HashMap<Character, Character> matchingBrackets = new HashMap<Character, Character>();

    /**
     * Constructor method, used to construct object that can analyze a string of brackets and
     * determine if they are balanced.
     * @param bracketStr Bracket String to be analzyed for balance
     */
    public Q1_Hall_Graydon(String bracketStr) {
        this.bracketStr = bracketStr;

        // initialize stack, with max length = length of bracket string
        this.bracketStack = new MyStack(bracketStr.length());

        // create matching bracket hash map
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');

    }

    public String verifyBrackets(){
        boolean isValid = false;  // tracks if bracket statement is valid
        boolean loopUnbroken = true;  // tracks if for loop was broken out of
        char[] chars = bracketStr.toCharArray();  // character array of string entered by user

        // iterate over `char[]` array using enhanced for-loop
        for (char ch: chars) {
            if(ch=='(' || ch=='[' || ch=='{'){
                // if starting bracket, push to stack
                bracketStack.push(ch);
            }
            else if (ch==')' || ch==']' || ch=='}'){  // current character is a closing bracket

                // check if stack is empty
                if (bracketStack.isEmpty()){
                    loopUnbroken = false;
                    break;
                }

                // pop top character from stack and see if it matches bracket coming from top of stack
                var b = bracketStack.pop();
                if(b!=matchingBrackets.get(ch)){
                    loopUnbroken = false;
                    break;
                }
            }
            else {
                // user entered expression with non-bracket characters
                System.out.println("Error: Statement must contain only {}()[]");
                loopUnbroken = false;
                break;
            }
        }
        if(bracketStack.isEmpty() && loopUnbroken){
            // if stack is empty and we didn't have to break out of the loop
            isValid = true;
        }

        if(isValid){
            return "This is valid";
        }
        else {
            return "This is invalid";
        }

    }

    public void tester(){

    }

    /**
     * Main method used to get user input of brackets, and determine if the brackets are valid
     * @param args
     */
    public static void main(String[] args) {
//        code for testing
//        var testExpr1 = "{[()]}";  // valid
//        var testExpr2 = "())";  // invalid
//        var testExpr3 = "(]";  // invalid
//        var testExpr4 = "{([)}";  // invalid
//        var testExpr5 = "()()";  // valid
//        var testExpr6 = "[()()]";  // valid
//        var testExpr7 = "[(D)()]";  // invalid
//        var testExpr8 = "(";  // invalid
//        var testExpr9 = ")";  // invalid
//        var x = new BracketMatcher(testExpr9);
//        System.out.println(x.verifyBrackets());

        var r = new KeyboardReader();  // used to get user input
        r.prompt("Enter a String containing Parenthesis ex (()): ");
        var str = r.getKeyboardInput();  // user statement as string
        var x = new Q1_Hall_Graydon(str);  // use bracket matcher class we made
        System.out.println(x.verifyBrackets());  // present if entered string is valid



    }
}
