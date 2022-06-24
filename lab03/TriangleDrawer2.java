public class TriangleDrawer2 {
    public static void main(String[] args)  {
        int col = 0;
        int row = 0;
        int SIZE = 10;

        for (row = 0; row < SIZE; row = row + 1) {
            for (col = 0; col <= row; col = col + 1) {
                System.out.println('*');
            }
            System.out.println();
            }
        }
}
