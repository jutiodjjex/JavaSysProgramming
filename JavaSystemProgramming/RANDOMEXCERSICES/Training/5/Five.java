public class Five {
    public static void main(String[] args) {
        int num, arg;
        for(num = 2; num <= 100; num++) {
            for(arg = 2; (num % arg) > 0; arg++) {
            }
            if(arg == num) System.out.print(num + "\t");
        }
    }
}
