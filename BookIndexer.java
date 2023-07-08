import java.io.*;
import java.util.*;

class BookIndexer {
    private Set<String> excludeWords;
    private Map<String, Set<Integer>> wordIndex;

    public BookIndexer() {
        excludeWords = new HashSet<>();
        wordIndex = new TreeMap<>();
    }

    public void readExcludeWords(String excludeWordsFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(excludeWordsFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            excludeWords.addAll(Arrays.asList(words));
        }
        reader.close();
    }

    public void createIndex(String[] pageFiles) throws IOException {
        for (int i = 0; i < pageFiles.length; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(pageFiles[i]));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (!excludeWords.contains(word) && word.matches("^[a-zA-Z].*")) {
                        if (!wordIndex.containsKey(word)) {
                            wordIndex.put(word, new HashSet<>());
                        }
                        wordIndex.get(word).add(i + 1); // Add page number (1-based indexing)
                    }
                }
            }
            reader.close();
        }
    }


    public void generateIndexFile(String indexFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(indexFile));
        writer.write("Word : Page Numbers");
        writer.newLine();
        for (Map.Entry<String, Set<Integer>> entry : wordIndex.entrySet()) {
            String word = entry.getKey();
            Set<Integer> pages = entry.getValue();
            writer.write(word + " : ");
            StringBuilder pageList = new StringBuilder();
            for (int page : pages) {
                pageList.append(page).append(",");
            }
            pageList.deleteCharAt(pageList.length() - 1); // Remove trailing comma
            writer.write(pageList.toString());
            writer.newLine();
        }
        writer.close();
    }

}

