import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class skipCharacter {
    static String newStr="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string to remove a's from it");
        String str= br.readLine();
        System.out.println(str.length());
        System.out.println("New removed string "+removeChar(str, 0));
    }

    static String removeChar(String s,int index){
        if(index>s.length()-1) return newStr;
        if(s.charAt(index)!='a') newStr+=s.charAt(index);
        return removeChar(s, index+1);
    }
}
