package cn.lilq;



import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 19:38
 */
public class Test {
    private static boolean repetition(List<Integer> list){
        int temp;
        for (int i = 0; i < list.size(); i++) {
             temp = list.remove(i);
            if (list.contains(temp)){
                return true;
            }
            list.add(i,temp);
        }
        return false;
    }

    private static List<Integer> addI(List<Integer> list){
        List<Integer> listNew = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listNew.add(list.get(i)+i+1);
        }
        return listNew;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        String abc = "abc";
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }
        int pathSize = 0;
        while (true){
            if (repetition(list)){
                System.out.println(pathSize);
                break;
            }
            list = addI(list);
            pathSize++;
        }

    }


}
