package cn.lilq.question79;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/21 14:29
 */
public class Solution {
    private char[][] board;
    private String word;
    private boolean exit = false;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        backTrack(new ArrayList<>());
        return exit;
    }

    private void backTrack(List<Location> path) {
        if (path.size()==word.length()){
            exit = true;
        }
        if (exit){
            return;
        }
        //需要查找的字符串
        char findChar = word.charAt(path.size());
        //size==0
        if (path.size()==0){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j]==findChar){
                        path.add(new Location(i,j));
                        backTrack(path);
                        path.remove(0);
                    }
                }
            }
        }else {
            //size>0
            Location location = path.get(path.size()-1);
            //上下左右寻找findChar
            Location newLocation;
            //左
            if (location.column>0){
                if (board[location.line][location.column-1]==findChar){
                    newLocation = new Location(location.line,location.column-1);
                    if (!path.contains(newLocation)){
                        path.add(newLocation);
                        backTrack(path);
                        path.remove(path.size()-1);
                    }
                }
            }
            //右
            if (location.column < board[0].length-1){
                if (board[location.line][location.column+1]==findChar){
                    newLocation = new Location(location.line,location.column+1);
                    if (!path.contains(newLocation)){
                        path.add(newLocation);
                        backTrack(path);
                        path.remove(path.size()-1);
                    }
                }
            }
            //上
            if (location.line>0){
                if (board[location.line-1][location.column]==findChar){
                    newLocation = new Location(location.line-1,location.column);
                    if (!path.contains(newLocation)){
                        path.add(newLocation);
                        backTrack(path);
                        path.remove(path.size()-1);
                    }
                }
            }
            //下
            if (location.line < board.length-1){
                if (board[location.line+1][location.column]==findChar){
                    newLocation = new Location(location.line+1,location.column);
                    if (!path.contains(newLocation)){
                        path.add(newLocation);
                        backTrack(path);
                        path.remove(path.size()-1);
                    }
                }
            }
        }
    }

    class Location{
        private int line;
        private int column;

        public Location(int line, int column) {
            this.line = line;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return line == location.line &&
                    column == location.column;
        }
    }
}
