package day01;

/**
 * @author liyingdan
 * @date 2019/9/14
 */
public class Test {
    public static void main(String[] args) {
        String a = "1111";
        String b = "1110";

        String a1 = Integer.valueOf(a, 2).toString(); //15
        String b1 = Integer.valueOf(b, 2).toString(); //14

        Integer c1 = Integer.parseInt(a1) + Integer.parseInt(b1); //29

        String num = Integer.toBinaryString(c1); //11101

        String num1 = addBinary(a, b);
        System.out.println(num1);


    }
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += a.charAt(p1--) - '0';
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p1 >= 0) {
            carry += a.charAt(p1--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }


}
