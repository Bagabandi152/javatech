package hw.bod10_8;

public class Financial {
    Financial() {
        int[][] brackets = new int[][]{
                // stat 0 single
                {8350, 33950, 82250, 171550, 372950},
                // stat 1 Married Filing Jointly
                {16700, 67900, 137050, 208850, 372950},
                // stat 2 Married Filing Separately
                {8350, 33950, 68525, 104425, 186475},
                // stat 3 Head of Household
                {11950, 45500, 117450, 190200, 372950}};

        double[] rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

        String s1 = "Taxable Income";
        String s2 = "Single";
        String s3 = "Married Joint";
        String s4 = "Married Separate";
        String s5 = "Head of house";

        System.out.printf("%-20s%-12s%-4s%21s%16s\n", s1, s2, s3, s4, s5);
        for (int i = 50000; i <= 60000; i += 1000) {
            System.out.printf("%4d%19.0f%16.0f%16.0f%20.0f\n", i, new Tax(Tax.SINGLE_FILER, brackets, rates, i).getTax(), new Tax(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, brackets, rates, i).getTax(), new Tax(Tax.MARRIED_SEPARATELY, brackets, rates, i).getTax(), new Tax(Tax.HEAD_OF_HOUSEHOLD, brackets, rates, i).getTax());
        }
    }

    public static void main(String[] args) {
        new Financial();
    }
}
