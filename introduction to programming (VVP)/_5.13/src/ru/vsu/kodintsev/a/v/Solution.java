package ru.vsu.kodintsev.a.v;
public class Solution {
    public static void image(int h, int w) {

        int spaceQuantity = -1;
        int spaceFix = 2;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w - spaceQuantity + 1 - spaceFix; c++) {
                if (c == w / 2 - r + 1 && r != 0) {
                    for (int k = 0; k < spaceQuantity; k++) {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print("*");
                }
            }
            if (r == 0) {
                spaceFix -= 2;
            }
            spaceQuantity += 2;
            System.out.println(" ");
        }
    }
}