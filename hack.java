//package random;
//
//import java.util.*;
//import java.util.regex.*;
//
//
////Write your code here
//
//class Solution{
//	
//	public static void main(String []argh)
//	{
//		Parser X=new Parser();
//		Scanner in = new Scanner(System.in);
//
//		while (in.hasNext()) {
//			System.out.println(X.checkParenthesisBalance(in.next()));
//		}
//		
//	}
//}
// class Parser{
//          public static boolean checkParenthesisBalance(String s){
//        Stack<Character> st  = new Stack<Character>();
//        for(int i = 0; i < s.length(); i++) {
//            char bracket = s.charAt(i);
//            // this assert is for checking validity of characters in the
//            // string. If a non-bracket character is found, throw an 
//            // assert and exit the program. This, however, can be defined
//            // by the user about how the program wants to handle this, 
//            // but in this case, we do not expect a non bracket character.
//            assert (bracket == '(' || 
//                    bracket == ')' || 
//                    bracket == '{' || 
//                    bracket == '}' ||
//                    bracket == '[' ||
//                    bracket == ']') : "Non-bracket character " + bracket + " found";
//            if (bracket == '(' || bracket == '[' || bracket == '{')
//                st.push(bracket);
//            else if (bracket == ')'){
//                if (st.isEmpty() || st.pop() != '(')
//                    return false;
//            } else if (bracket == '}') {
//                if (st.isEmpty() || st.pop() != '{')
//                    return false;
//            } else if (bracket == ']') {
//                if (st.isEmpty() || st.pop() != '[')
//                    return false;
//            } else {
//                st.push(bracket);
//                // For non-bracket characters, this will already
//                // be handled earlier, but inserting it
//                // in the stack will mean that no matching characters will be found
//                // causing the stack to be non-empty at the end
//            }
//        }
//        return st.isEmpty();
//     }
// }