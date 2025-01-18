package JavaRE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex {
    

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Hello World" , Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher("Hello World! ");
        boolean found = match.find();

        if (found) {
            System.out.println("Match Found");

        }else{
            System.out.println("Match not Found");
        }
    }
}
