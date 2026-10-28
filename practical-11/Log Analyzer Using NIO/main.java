
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        Path[] files = {
            Paths.get("log1.txt"),
            Paths.get("log2.txt"),
            Paths.get("log3.txt")
        };

        String keyword = "ERROR";
        int totalLines = 0;
        int matchingLines = 0;

        for (Path path : files) {
            try {
                BasicFileAttributes attr =
                    Files.readAttributes(path, BasicFileAttributes.class);

                System.out.println("\nFile: " + path.getFileName());
                System.out.println("Size: " + attr.size() + " bytes");

                try (Stream<String> lines = Files.lines(path)) {
                    List<String> allLines = lines.toList();

                    for (String line : allLines) {
                        totalLines++;

                        if (line.contains(keyword)) {
                            matchingLines++;
                            System.out.println("Match: " + line);
                        }
                    }

                    System.out.println("Lines in file: " + allLines.size());
                }

            } catch (IOException e) {
                System.out.println("Cannot read " + path + ": "
                                   + e.getMessage());
            }
        }

        System.out.println("\nTotal lines: " + totalLines);
        System.out.println("Lines containing " + keyword + ": "
                           + matchingLines);
    }
}
