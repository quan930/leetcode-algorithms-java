package cn.lilq.question37;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/15 17:13
 */
public class Solution {

    class Node{
        Integer x;
        Integer y;
        List<Character> list;//可选值

        public Node(Integer x, Integer y, List<Character> list) {
            this.x = x;
            this.y = y;
            this.list = list;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", list=" + list +
                    '}';
        }
    }

    /**
     * 获得可选点
     * @param x
     * @param y
     * @param board
     * @return
     */
    private List<Character> getOptionalValue(int x,int y,char[][] board){
        Map<Character,Integer> map = new HashMap<>();
        map.put('1',1);map.put('2',1);map.put('3',1);map.put('4',1);map.put('5',1);map.put('6',1);map.put('7',1);map.put('8',1);map.put('9',1);
        for (int i = 0; i < 9; i++) {
            map.remove(board[x][i]);
        }
        for (int i = 0; i < 9; i++) {
            map.remove(board[i][y]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.remove(board[x/3*3+i][y/3*3+j]);
            }
        }
        return new ArrayList<>(map.keySet());
    }

    private void print(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    System.out.printf("\033[0;31m%c\033[0m",board[i][j]);
                    System.out.print("\t");
                }else {
                    System.out.print(board[i][j]+"\t");
                }
            }
            System.out.println();
        }
    }

    private char[][] boardCopy(char[][] board){
        char[][] boardNew = new char[board.length][];
        for(int i = 0;i < board.length;i++){
            boardNew[i] = board[i].clone();
        }
        return boardNew;
    }

    /**
     * 获得所有空节点
     * @param board
     * @return
     */
    private List<Node> getNullNode(char[][] board){
        List<Character> list;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    list = getOptionalValue(i,j,board);
                    nodes.add(new Node(i,j,list));
                }
            }
        }
        nodes.sort(Comparator.comparingInt(o -> o.list.size()));
        return nodes;
    }

    private boolean m = false;
    private char[][] res;

    private void dfs (int deep,char[][] board,List<Node> nodes){
        if (deep==nodes.size()){
//            System.out.println("=====================出现结果==========================");
            m = true;
            res = board;
            return;
        }
        if (m)
            return;
//        System.out.println("deep:"+deep);
        List<Character> characterList = getOptionalValue(nodes.get(deep).x,nodes.get(deep).y,board);
//        System.out.println("x:"+nodes.get(deep).x+"\ty:"+nodes.get(deep).y+"\t可插入节点:"+characterList);
        if (characterList.size()==0){
//            System.out.println("---------------------------------------------------回滚deep:"+deep);
            return;
        }
        characterList.forEach(character -> {
            char[][] boardNew = boardCopy(board);
            boardNew[nodes.get(deep).x][nodes.get(deep).y] = character;
            dfs(deep+1,boardNew,nodes);
        });
    }

    public void solveSudoku(char[][] board) {
        List<Node> nodes = getNullNode(board);
        //空点
//        nodes.forEach(System.out::println);
//        System.out.println(nodes.size());
        m = false;
        dfs(0,board,nodes);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}