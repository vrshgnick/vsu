package ru.vsu.cs.vereschagin.logic;
public class Task {

    public static LinkedList<Integer> sumPair(LinkedList<Integer> list){
        LinkedList<Integer> resultList = new LinkedList<>();

        for (int i = 0; i < list.size(); i += 2) {
            if (i + 1 < list.size()) {
                int sum = list.get(i) + list.get(i + 1);
                resultList.add(sum);
            } else {
                resultList.add(list.get(i));
            }
        }

        return resultList;
    }
}
