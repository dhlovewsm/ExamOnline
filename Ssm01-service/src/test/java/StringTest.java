import java.util.Arrays;

/**
 * @author Administrator
 * @date 2019/4/8 10:09
 */

public class StringTest {

    public static void main(String[] args) {
        String str1 = "aaa;bbb;ccc;ddd;eee";
        String str2 = "bbb;ccc;ddd;aaa";
        String[] st1 = str1.split(";");
        String[] st2 = str2.split(";");
        int score = 0;
        Arrays.sort(st1);
        Arrays.sort(st2);
        if (Arrays.equals(st1,st2)){
            score = 5;
        }else {
            score = 0;
        }
        System.out.println(score);
    }

}
