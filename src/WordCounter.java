import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        String filePath = "src/resource/wordtest.txt";
        try {
            Map<String, Integer> wordFrequency = countWordFrequency(filePath);
            printHistogram(wordFrequency);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        int totalCharacters = 0;
        int totalWords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalCharacters += line.length();
                String[] words = line.split("\\s+");
                totalWords += words.length;

                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Eliminar caracteres no alfabéticos
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        System.out.println(totalWords + " palabras");
        System.out.println(totalCharacters + " caracteres");
        return wordFrequency;
    }

    private static void printHistogram(Map<String, Integer> wordFrequency) {
        System.out.println("Histograma de Frecuencia de Palabras (Ordenado de Mayor a Menor):");

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequency.entrySet());
        sortedEntries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            System.out.print(word + ": " + frequency + " | ");
            printBar(frequency);
            System.out.println();
        }
    }

    private static void printBar(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
    }
}