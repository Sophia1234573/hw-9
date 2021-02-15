import java.io.*;
import java.util.*;

public class FrequencyWords {
    private static final String ABSOLUTE_PATH = "D:\\Sophia\\Java\\GoIT\\module 9\\hw-9\\src\\main\\resources\\words.txt";

    public static void main(String[] args) {
        File file = createTestFile();
        counterFrequencyWords(file);
    }

    private static void counterFrequencyWords(File file) {
        Set<String> setOfWords = new HashSet<>();
        List<String> listOfWords = new ArrayList<>();
        List<String> results = new ArrayList<>();
        String counterFrequencyWords = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();

            while (line != null) {
                String[] words = line.split(" ");

                for (String word : words) {
                    setOfWords.add(word);
                    listOfWords.add(word);
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        String result = "";
        String str = "";

        for (String set : setOfWords) {
            int count = 0;
            for (String list : listOfWords) {
                if (set.equals(list)) {
                    count++;
                }
            }
            str = set;
            result = str + " " + count;
            results.add(result);
            Collections.sort(results, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            String[] components1 = o1.split(" ");
                            String[] components2 = o2.split(" ");
                            int a = Integer.parseInt(components1[1]);
                            int b = Integer.parseInt(components2[1]);
                            if (a > b) {
                                return -1;
                            } else if (a < b) {
                                return 1;
                            } else return 0;
                        }
                        });
                    }

        for (String r : results) {
            counterFrequencyWords += r + "\n";
        }
        System.out.println(counterFrequencyWords);
    }

        private static File createTestFile () {
            File file = new File(ABSOLUTE_PATH);
            checkIfFileAvailable(file);

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

                bufferedWriter.write("the day is sunny the the\n" +
                        "the sunny is is");

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return file;
        }

        private static void checkIfFileAvailable (File file){
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
