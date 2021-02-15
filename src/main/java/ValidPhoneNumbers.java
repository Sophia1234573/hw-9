import java.io.*;

public class ValidPhoneNumbers {
    private static final String ABSOLUTE_PATH = "D:\\Sophia\\Java\\GoIT\\module 9\\hw-9\\src\\main\\resources\\file1.txt";

    public static void main(String[] args) {
        File file = createTestFile();
        validPhoneNumber(file);
    }

    private static void validPhoneNumber(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null) {
                boolean result1 = line.matches("\\d{3}\\-\\d{3}\\-\\d{4}");
                boolean result2 = line.matches("\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}");
                if (result1 || result2) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static File createTestFile() {
        File file = new File(ABSOLUTE_PATH);
        checkIfFileAvailable(file);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){

            bufferedWriter.write("987-123-4567\n" +
                    "123 456 7890\n" +
                    "(123) 456-7890");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return file;
    }

    private static void checkIfFileAvailable(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
