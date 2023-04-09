package expression.generic;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("2 arguments expected, found " + args.length);
            }
            if (args[0].length() == 0 || args[0].charAt(0) != '-') {
                throw new IllegalArgumentException("First argument is expected to be a flag");
            }
            Object[][][] res = new GenericTabulator().tabulate(args[0].substring(1), args[1], -2, 2, -2, 2, -2, 2);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        System.out.println(
                                "R[" + (i - 2) + "][" + (j - 2) + "][" + (k - 2) + "] = " +
                                        res[i][j][k]);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal input: " + e.getMessage());
        }
    }
}
