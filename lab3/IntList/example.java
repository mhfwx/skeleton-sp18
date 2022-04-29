import java.lang.*;
public class example {
    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i++) {
            totalLength += x[i].length;
        }

        int[] a = new int[totalLength];
        int aIndex = 0;
        for (int i = 0; i < x.length; i++) {
            System.arraycopy(x[i], 0, a, aIndex, x[i].length);
            aIndex += x[i].length;

        }
        return a;
    }
}
