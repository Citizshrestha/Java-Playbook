package letsgoDSA;

public class ArrayExample {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,5,6,7};

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        arr[2] = 30;
        System.out.println(arr[2]);
        System.out.println("Access elements of array");
        for (int elems : arr) {
            System.out.print(elems + " ");
        }

        System.out.println();

        int[][] arr2 = {
                {10,20,30},
                {40,50,60},
                {70,80,90}
        };

        System.out.println("Elements ata row1 col2:" + arr2[0][1]);
        System.out.println("Elements ata row2 col2:" + arr2[1][1]);
        arr2[2][1] = 800;
        System.out.println("Elements ata row3 col2:" + arr2[2][1]);
        System.out.println("Accessing thee elements of matrixArray");
        for(int rows=0; rows<arr2.length; rows++){
            for(int cols=0; cols<arr2[rows].length; cols++){
                System.out.print(arr2[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
