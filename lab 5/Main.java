import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Adder {
    private final String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {
        int total = 0;
        String line = null;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while ((line = reader.readLine()) != null)
                total += Integer.parseInt(line);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
            writer.write("Total: " + total);
        }
    }
}

public class Main {

    public static void deleteFile(String filename) {
        File myObj = new File(filename);
        myObj.delete();
    }

    public static void addInFiles(String inFile, String outFile) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Adder adder = new Adder(inFile, outFile);
                    adder.doAdd();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        String[] inFiles = { "./file1.txt", "./file2.txt", "./file3.txt", "./file4.txt" };
        String[] outFiles = { "./file1.out.txt", "./file2.out.txt", "./file3.out.txt", "./file4.out.txt" };

        for (int i = 0; i < inFiles.length; i++) {
            deleteFile(outFiles[i]);
            // addInFiles(inFiles[i], outFiles[i]);
        }

    }
}