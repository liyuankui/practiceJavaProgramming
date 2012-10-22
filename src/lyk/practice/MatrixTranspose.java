package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/18/12
 * Time: 11:48 PM
 * The MatrixTranspose class is intended to fulfil some duties.
 */
public class MatrixTranspose {

    public static void displayMatrix(int[] arr, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(arr[i * width + j] + "\t");
            }
            System.out.println();
        }
    }

    public static void leftShiftArray(int[] arr, int start, int end) {
        System.out.println("L Insert -> " + start + " to " + end);
        int i = start;
        int value = arr[start];
        while (i < end) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[end] = value;
    }

    public static void shiftArray(int[] arr, int start, int end) {
        if (start == end) return;
        if (start > end) {
            rightShiftArray(arr, end, start);
        } else {
            leftShiftArray(arr, start, end);
        }
    }

    public static void rightShiftArray(int[] arr, int start, int end) {
        System.out.println("R Insert -> " + end + " to " + start);
        int i = end;
        int value = arr[end];
        while (i > start) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[start] = value;
    }

    public static void transpose(int[] arr, int height, int width) {
        int square = Util.min(height, width);
        for (int i = 0; i < square; i++)
            for (int j = i; j < square; j++)
                Util.swap(arr, i * width + j, j * width + i);
        displayMatrix(arr, width, height);

        Util.DumpArray(arr);
        if (height > width) { // portrait to landscape
            for (int i = square; i < height; i++) {
                int offset = 0;
                for (int j = 0; j < width; j++) {
                    System.out.println("J=" + j);
                    rightShiftArray(arr, (j + 1) * (width + i - square) + offset, i * width + j);
                    offset++;
                }
            }
        } else { // landscape to portrait
            for (int j = width - 1; j >= square; j--) {
                for (int i = height - 1; i >= 0; i--) {
//                    leftShiftArray(arr,i*width+j,);
                }
            }

//            for(int i=0;i<height;i++){
//                int offset=0;
//                for(int j=square; j<width;j++){
//                    leftShiftArray(arr,i*height+square-offset,);
//
//                }
//            }
////            for(int j=width-1; j>=square; j++){
//                for(int i=height-1; i>=0;i++){
//                    rightShiftArray(arr,0,i*width+j);
//                }
//            }

        }
    }

    public static void naiveTranspose(int[] arr, int height, int width) {
        int from, to, offset, step;
        int i, j;
        for (i = to = offset = 0, step = width; i < width; ++i, --step, offset += height - 1) {
            for (j = 0, from = i + offset; j < height; ++j, ++to, from += step) {
                shiftArray(arr, from, to);
            }
        }
        displayMatrix(arr, width, height);
    }

    public static void trans(int[] arr, int height, int width) {
        displayMatrix(arr, height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Util.swap(arr, i * width + j, j * height + i);
            }
        }
        displayMatrix(arr, width, height);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        displayMatrix(arr, 3, 5);
        naiveTranspose(arr, 3, 5);
    }
}
