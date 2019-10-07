package string;


import java.util.Arrays;

/**
 * @author liyingdan
 * @date 2019/10/1
 */
public class Test {
    public static void main(String[] args) {
        String str1 = "abcbdgghhhhh";
        String str2 = "bcbdg";
//        int i = violenceMatch(str1, str2);
//        System.out.println(i);

        SeqString ababaaaba = new SeqString("ababaaaba");
        int[] nextVal = getNextVal(ababaaaba);
        System.out.println(Arrays.toString(nextVal));

    }
//    public static int violenceMatch(String str1, String str2){
//        if(str1 != null && str2 != null && str2.length() > 0 && str1.length() >= str2.length()){
//            int i = 0, j = 0;
//            while (i < str1.length() && j < str2.length()){
//                if(str1.charAt(i) == str2.charAt(j)){ //j为模式串当前字符的下标
//                    i ++;
//                    j ++;   //继续比较后续字符
//                }else {
//                    i = i - j + 1;  //继续比较主串中的下一个字符
//                    j = 0;   //模式串下标退回到0
//                }
//            }
//            if(j == str2.length())
//                return i - j;  //匹配成功，返回字串序号
//            else
//                return -1;
//        }
//        return -1;
//    }

    /**
     * 求nextval[j]的值
     * */
    public static int[] getNextVal(SeqString T){
        int[] nextval = new int[T.length()];
        int j = 0, k = -1;
        nextval[0] = -1;
        while(j < T.length() - 1){
            if(k == -1 || T.charAt(j) == T.charAt(k)){
                j ++;
                k ++;
                if(T.charAt(j) != T.charAt(k))
                    nextval[j] = k;
                else
                    nextval[j] = nextval[k];
            }else
                k = nextval[k];
        }
        return nextval;
    }
}
