import java.util.ArrayList;
import java.util.List;

/**
 * @Author: theo
 * @Date: 2020/3/10 1:26 下午
 */
public class AppTest {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        String s = "1234567890abcdefghABCDEF";
        List<String> strings = castStr(list, s);
        System.out.println(strings);

    }


    /**
     * 需求：
     * 1234567890abcdefgh
     * =>
     * 1234 5678 90
     * abcd ef
     * gh
     */
    public static List<String > castStr(List<String > list, String s){

        if (s.length() <= 2){
            list.add(s);
            return list;
        }
        if (s.length() > 10){
            String s10 = s.substring(0,10);
            list.add(s10.substring(0, 4));
            list.add(s10.substring(4, 8));
            list.add(s10.substring(8));

            String sub = s.substring(10);
            return castStr(list, sub);

        }else {
            if (s.length() <= 6){
                list.add(s.substring(0, s.length() - 2));
                list.add(s.substring(s.length() - 2));
            }
            if (s.length() == 7||s.length() == 8){
                list.add(s.substring(0,4));
                list.add(s.substring(4,6));
                list.add(s.substring(6));
            }

            if (s.length() == 9 || s.length() == 10){
                list.add(s.substring(0,4));
                list.add(s.substring(4,6));
                list.add(s.substring(6,8));
                list.add(s.substring(8));
            }
            return list;
        }
    }

}
