import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

    static void Extract(String line) {

        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                for (int j = i; j < line.length(); j++) {
                    if (line.charAt(j) == '>') {
                        values.add(i);
                        keys.add(line.substring(i + 1, j));
//
                        i = j;
                        break;
                    }
                }
            }
        }
        ArrayList<String> cont = new ArrayList<>();

        for (int i = 0; i < keys.size(); i++) {


            if (cont.size()>1){
                for (int j =cont.size()-1; j >= 0 ; j--) {
                    if(keys.get(i).equals("/"+cont.get(j))){
                        System.out.println(line.substring(values.get(j)+keys.get(i).length()+1,values.get(i)));
                        cont = new ArrayList<>();
                    }
                }

            }
            cont.add(keys.get(i));
        }
//
    }



    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            Extract(line);

            testCases--;
        }

    }

}
