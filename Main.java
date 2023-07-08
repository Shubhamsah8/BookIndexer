import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] pageFiles = {"C:\\Users\\RYZEN\\Downloads\\Page1.txt", "C:\\Users\\RYZEN\\Downloads\\Page2.txt", "C:\\Users\\RYZEN\\Downloads\\Page3.txt"};
        String excludeWordsFile = "C:\\Users\\RYZEN\\Downloads\\exclude-words.txt";
        String indexFile = "index.txt";

        try {
            BookIndexer indexer = new BookIndexer();
            indexer.readExcludeWords(excludeWordsFile);
            indexer.createIndex(pageFiles);
            indexer.generateIndexFile(indexFile);
            System.out.println("Index file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
