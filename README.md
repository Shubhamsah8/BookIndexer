# BookIndexer
The Book Indexer is a Java program that reads the pages of a book, creates an index of words, and generates an output file with the list of pages on which each word is present.

# Features
1. Reads multiple page files and excludes common words specified in a separate file.
2. Generates an index file with words sorted alphabetically, along with the corresponding page numbers.
3. Excludes words that do not start with any alphabets from the index.

# Getting Started
## Prerequisities
1. Java Development Kit (JDK) installed on your machine.
2. Text files containing the book pages and the list of common words.

## Customization
1. You can modify the file names and paths in the Main class to match your own page files, exclude words file, and output file.
2. If your book pages are in a different format or encoding, you may need to adjust the file reading and parsing logic in the BookIndexer class accordingly.

# Acknowledgements
The Book Indexer program was created using Java and follows an object-oriented approach. It utilizes file reading and writing operations, data structures (such as sets and maps), and regular expressions for word filtering. The program was developed as an example to demonstrate the indexing functionality and can be customized or extended to suit specific requirements.

Please note that this is a sample README file, and you may need to modify it based on the specific details and structure of your project.
