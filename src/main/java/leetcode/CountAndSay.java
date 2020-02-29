package leetcode;

import javax.swing.plaf.IconUIResource;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-21<p>
// 注释说明
// -------------------------------------------------------
public class CountAndSay {

    public String countAndSay1(int n) {
        String result = "1";
        for(int i=2; i<=n; i++){
            String temp = "";
            for(int j=0; j<result.length(); j++ ){
                char f = result.charAt(j);
                int count = 1;
                for(int k=j+1; k<result.length(); k++){
                    if(result.charAt(k) == f){
                        count ++;
                    }else{
                        break;
                    }
                }
                temp += count + "" + f;
                j+=count-1;
            }
            result = temp;
        }
        return result;
    }

    public String countAndSay(int n) {
        String s = "1";
        while(n>1){
            s += "#";
            String tmp = "";
            int count = 1;
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    count++;
                }else{
                    tmp = tmp+count+s.charAt(i);
                    count = 1;
                }
            }
            s = tmp;
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(6));
    }
}
