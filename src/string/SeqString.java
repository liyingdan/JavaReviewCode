package string;

/**
 * @author liyingdan
 * @date 2019/10/1
 *
 * 顺序串的类定义
 */
public class SeqString {
    private char[] strvalue;
    private int curlen;
    //构造方法1：构造一个空串
    public SeqString(){
        strvalue = new char[0];
        curlen = 0;
    }
    //构造方法2：以字符串常量构造串对象
    public SeqString(String str){
        char[] tempchararray = str.toCharArray();
        strvalue = tempchararray;
        curlen = tempchararray.length;
    }
    //构造方法3：以字符串数组构造串对象
    public SeqString(char[] value){
        this.strvalue = new char[value.length];
        for (int i = 0; i < value.length; i++) { //复制数组
            this.strvalue[i] = value[i];
        }
        curlen = value.length;
    }
    //将一个已经存在的串置成空串
    public void clear(){
        this.curlen = 0;
    }
    //判断当前串是否为空
    public boolean isEmpty(){
        return curlen == 0;
    }
    //返回字符串长度
    public int length(){
        return curlen;   //区别：strvalue.length 是数组容量的
    }
    //返回字符串中序号为index的字符
    public char charAt(int index){
        if((index < 0) || (index >= curlen)){
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue[index];
    }

    /**
     * 扩充字符串存储空间容量，参数指定容量
     * */
    public void allocate(int newCapacity){
        char[] temp = strvalue;
        strvalue = new char[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            strvalue[i] = temp[i];
        }
    }

    /**
     * 返回串中序号从 begin 至 end-1 的字串
     * */
    public SeqString subString(int begin, int end){
        if(begin < 0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        if(end > curlen)
            throw new StringIndexOutOfBoundsException("起始位置不能大于curlen");
        if(begin > end)
            throw new StringIndexOutOfBoundsException("起始位置不能大于结束位置");
        if(begin == 0 && end == curlen)
            return this;
        else{
            char[] buffer = new char[end - begin];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = strvalue[begin + i];
            }
            return new SeqString(buffer);
        }
    }

    /**
     * 在当前串的第offset个字符之前插入串str
     * */
    public SeqString insert(int offset, SeqString str){
        if((offset < 0) || (offset > this.curlen))
            throw new StringIndexOutOfBoundsException("插入位置不合法 ");
        int len = str.length();
        int newCount = len + this.curlen;
        if(newCount > strvalue.length)
            allocate(newCount); //插入存储空间不足，需扩充容量
        for (int i = this.curlen - 1; i >= offset; i--)
            strvalue[len + 1] = strvalue[i]; //从offset开始向后移动len个字符
        for (int i = 0; i <len; i++) //复制串str
            strvalue[offset + i] = str.charAt(i);
        this.curlen = newCount;
        return this;
    }

    /**
     * 删除当前串从序号 begin 开始到序号 end - 1 为止的字串
     * */
    public SeqString delete(int begin, int end){
        if(begin < 0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        if(end > curlen)
            throw new StringIndexOutOfBoundsException("起始位置不能大于串的当前长度");
        if(begin > end)
            throw new StringIndexOutOfBoundsException("起始位置不能大于结束位置");
        for (int i = 0; i <curlen - end; i++)  //从end开始至串尾的子串向前移动到从begin开始的位置
            strvalue[begin + i] = strvalue[end + i];
        curlen = curlen - (end - begin);
        return this;
    }

    /**
     * 添加指定串str到当前串尾
     * */
    public SeqString concat(SeqString str){
        return insert(curlen, str);
    }

    /**
     * 将当前串与目标串str进行比较  ------------  不太懂
     *
     * 将当前串与参数str指定的串进行比较，若当前串的值大于sr的串值，则返回一个正整数；
     * 若当前串的值等于str的串值，则返回0；
     * 若当前串的值小于str的串值，则返回一个负整数
     * */
    public int compareTo(SeqString str){
        int len1 = curlen;
        int len2 = str.length();
        int n = Math.min(len1, len2);
        char[] s1 = strvalue;
        char[] s2 = str.strvalue;
        int k = 0;
        while (k < n){
            char ch1 = s1[k];
            char ch2 = s2[k];
            if(ch1 != ch2)
                return ch1 - ch2;  //返回第一个不相等字符的数值差
            k ++;
        }
        return len1 - len2;  //返回两个串长度的差
    }

    /**
     * 字串定位 ----Brute-Force
     *
     * 返回模式串t在主串s中从start开始的第一次匹配位置，匹配失败时返回-1
     * */
    public int indexOf_BF(SeqString t, int start){
        if(this != null && t != null && t.length() > 0 && this.length() >= t.length()){ //当主串比模式串长时进行比较
            int i = start, j = 0; // i 表示主串中某个字串的序号
            while(i < this.length() && j < t.length()){
                if(this.charAt(i) == t.charAt(j)){ //j为模式串当前字符的下标
                    i ++;
                    j ++;   //继续比较后续字符
                }else {
                    i = i - j + 1;  //继续比较主串中的下一个字符
                    j = 0;   //模式串下标退回到0
                }
            }
            if(j >= t.length())
                return i - t.length();  //匹配成功，返回字串序号
            else
                return -1;
        }
        return -1;
    }


    /**
     * 求next[]的值
     * */
    public int[] getNext(SeqString T){
        int[] next = new int[T.length()];
        int j = 1;
        int k = 0;
        next[0] = -1;
        next[1] = 0;
        while(j < T.length() - 1){
            if(T.charAt(j) == T.charAt(k)){
                next[j + 1] = k + 1;
                j ++;
                k ++;
            }else if(k == 0){
                next[j + 1] = 0;
                j ++;
            }else
                k = next[k];
        }
        return next;
    }

    /**
     * 求nextval[j]的值
     * */
    public int[] getNextVal(SeqString T){
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

    /**
     * 模式匹配的KMP算法
     * */
    public int index_KMP(SeqString T, int start){
        int[] next = getNextVal(T);  //计算模式串的next[]函数值
        int i = start, j = 0;  //i为主串指针， j为模式串指针
        while (i < this.length() && j < T.length()){ //对两串从左到右逐个比较字符
            if(j == -1 || this.charAt(i) == T.charAt(j)){ //若j = -1（此时模式串的第一个就匹配不上） 或者对应字符匹配
                i ++;
                j ++;
            }else
                j = next[j]; //当S[i]与T[j]不相等时，模式串右移
        }
        if(j < T.length())
            return -1;   //匹配失败
        else
            return i - T.length();
    }
}
