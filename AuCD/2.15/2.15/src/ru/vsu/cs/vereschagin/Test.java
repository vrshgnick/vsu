package ru.vsu.cs.vereschagin;

import ru.vsu.cs.vereschagin.logic.LinkedList;
import ru.vsu.cs.vereschagin.logic.LinkedListUtils;
import ru.vsu.cs.vereschagin.logic.Task;

public class Test {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = LinkedListUtils.listFromFile("test.txt");

        System.out.println(linkedList);
        linkedList.sumPairR();
        System.out.println(linkedList);
        int[] arr = linkedList.toArr();
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
