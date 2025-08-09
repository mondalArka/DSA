    import java.util.Stack;
    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    public class Parenthesis{
        public static void main(String args[]) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the string");
            String str = br.readLine();
            System.out.println("Valid Parenthesis is "+checkParanthesis(str));
            System.out.println("Number of moves required "+moves(str));
        }

        static boolean checkParanthesis(String str){
            Stack<Character> st = new Stack<>();

            for(char ch: str.toCharArray()){
                for(int i=0;i<st.size();i++){
                    System.out.print(st.get(i)+" ");
                }
                if(ch=='(' || ch=='{' || ch=='[')
                    st.push(ch);
                    else if(ch==')' || ch=='}' || ch==']'){
                if(ch==')' && (st.isEmpty() || (st.pop()!='(' && ch==')')))
                    return false;
                if(ch=='}' && (st.isEmpty() || (st.pop()!='{' && ch=='}')))
                    return false;
                if(ch==']' && (st.isEmpty() || (st.pop()!='[' && ch==']')))
                    return false;
            }else return false;
        }
            return st.isEmpty();
        }

        static int moves(String str){
            Stack<Character> st = new Stack();
            int moves =0;
            for(char ch: str.toCharArray()){
               if(st.isEmpty())
                   st.push(ch);
                else {
                    if(ch==')' && st.peek()=='(')
                        st.pop();
                    else st.push(ch);
                }
            }

            return st.size();
        }
    }