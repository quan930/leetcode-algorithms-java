package cn.lilq.question51;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 15:36
 */
public class Solution {
    class Location{
        Integer x;
        Integer y;

        public Location(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return Objects.equals(x, location.x) &&
                    Objects.equals(y, location.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private int n;
    private List<List<String>> ress;

    private void backStack(List<Location> path, Map<Integer,Integer> map){
        if (path.size() > 1){
            //todo 减枝
            Location location = path.get(path.size()-1);
            //todo
            for (int i = 0; i <= location.x+location.y; i++) {
                if (i== location.x)
                    continue;
                if (path.contains(new Location(i, location.y+location.x-i))){
                    return;
                }
            }
            //todo
            if (location.x> location.y){
                for (int i = location.x-location.y,j = 0; i < n; i++,j++) {
                    if (i== location.x)
                        continue;
                    if (path.contains(new Location(i, j))){
                        return;
                    }
                }
            }else {
                for (int i = location.y-location.x,j = 0; i < n; i++,j++) {
                    if (j == location.x)
                        continue;
                    if (path.contains(new Location(j, i))){
                        return;
                    }
                }
            }
        }

        if (path.size()==n){
            List<String> res = new ArrayList<>();
            path.forEach(location -> {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (location.y==i){
                        stringBuilder.append('Q');
//                        stringBuilder.append(' ');
                    }else {
                        stringBuilder.append('.');
//                        stringBuilder.append(' ');
                    }
                }
                res.add(stringBuilder.toString());
            });
            ress.add(res);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (map.get(i)!=null){
                path.add(new Location(path.size(),i));
                map.remove(i);
                backStack(path,map);
                path.remove(path.size()-1);
                map.put(i,1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.ress = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,1);
        }
        backStack(new ArrayList<>(),map);
//        print();
        return new ArrayList<>(ress);
    }

    private void print(List<List<String>> ress){
        for (int i = 0; i < ress.size(); i++) {
            for (int j = 0; j < ress.get(i).size(); j++) {
                System.out.println(ress.get(i).get(j));
            }
            System.out.println();
        }
    }
}
