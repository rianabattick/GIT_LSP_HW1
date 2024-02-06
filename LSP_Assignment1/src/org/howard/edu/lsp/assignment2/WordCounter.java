package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "src/org/howard/edu/lsp/assignment2/words.txt"; // Relative path to the input file
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line
                for (String rawWord : line.split("\\W+")) { // Splits by non-word characters
                    String word = rawWord.toLowerCase();
                    if (word.matches("[a-z]{4,}")) { // check if the word is at least 4 characters long and not a number
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return;
        }

        // Display the word counts
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + "    " + entry.getValue());
        }
    }
}
