public class q6 {
    public static void main(String[] args) {
        nCubed(5);

    }

    public static void nCubed(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("" + i + j + k);
                }
            }
        }
    }

}
