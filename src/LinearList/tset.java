package LinearList;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liyingdan
 * @date 2019/9/8
 */
public class tset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
                String key = sc.next();
            int value = sc.nextInt();
            //是否存在
            //存在
            if(map.containsKey(key)){
                if(map.get(key) < value){
                    map.remove(key);

                    map.put(key,value);
                }
                else
                    break;
                //不存在
            }else {
                if(map.size() < n)
                    map.put(key,value);
                else if(map.size() == n){
                    map.remove(0);
                    map.put(key,value);
                }
                else
                    break;
            }
        }
        System.out.println(map);
    }

}
