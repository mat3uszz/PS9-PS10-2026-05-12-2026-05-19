public class Calculator {

    public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numbersToParse = numbers;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbersToParse = numbers.substring(delimiterIndex + 1);
        }

        String[] tokens = numbersToParse.split(delimiter);
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    if (negativeNumbers.length() > 0) negativeNumbers.append(", ");
                    negativeNumbers.append(num);
                }
                if (num <= 1000) {
                    sum += num;
                }
            }
        }

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

        return sum;
    }
}