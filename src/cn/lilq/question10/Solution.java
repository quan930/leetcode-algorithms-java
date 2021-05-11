package cn.lilq.question10;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/11 08:25
 */
public class Solution {
    private static boolean aBoolean = false;

    private void util(String s, String p){
//        System.out.println("判断s:"+s+"\tp:"+p);
        if (s.length()==0&&p.length()==0){
            aBoolean=true;
            return;
        }
        else if (s.length()==0 && p.charAt(p.length()-1)=='*'){
            util(s,p.substring(0,p.length()-2));
            return;
        }
        else if (s.length()==0||p.length()==0)
            return;

        char charS = s.charAt(s.length()-1);
        char charP = p.charAt(p.length()-1);
        if (charS==charP||charP=='.')
            util(s.substring(0,s.length()-1),p.substring(0,p.length()-1));
        else if (charP=='*'&&p.charAt(p.length()-2)=='.'){
            for (int i = 0; i <= s.length(); i++) {
                util(s.substring(0,s.length()-i),p.substring(0,p.length()-2));
            }
        }
        else if (charP=='*'){
//            System.out.println("有*:"+s+"===="+p);
            int i = 1;
//            System.out.println("进:"+s+"===="+p.substring(0,p.length()-2));
            util(s,p.substring(0,p.length()-2));
            char temp = p.charAt(p.length()-2);
            while (s.length()-i>=0 && s.charAt(s.length()-i)==temp){
                util(s.substring(0,s.length()-i),p.substring(0,p.length()-2));
//                System.out.println("进:"+s.substring(0,s.length()-i)+"===="+p.substring(0,p.length()-2));
                i++;
            }
        }else {
            return;
        }
    }


    public boolean isMatch(String s, String p) {
//        System.out.println(s.substring(0,s.length()-1));
        aBoolean = false;
        util(s,p);
        return aBoolean;
    }
}
