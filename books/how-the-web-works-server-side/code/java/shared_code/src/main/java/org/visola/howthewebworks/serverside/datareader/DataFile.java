package org.visola.howthewebworks.serverside.datareader;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class DataFile {

    private static final String ROOT_DIRECTORY = "how-the-web-works-server-side";

    private final File file;

    public DataFile(String fileName) throws IOException {
        File dir = new File(".").getAbsoluteFile();
        do {
            if (!dir.getCanonicalPath().contains(ROOT_DIRECTORY)) {
                throw new RuntimeException("Can't find data file outside root directory: " + ROOT_DIRECTORY);
            }

            Optional<File> maybeDataDir = findDataDir(dir);
            if (maybeDataDir.isPresent()) {
                file = new File(maybeDataDir.get(), fileName);
                break;
            }

            dir = dir.getParentFile();
            if (dir == null) {
                throw new RuntimeException("Unable to find data file: " + fileName);
            }
        } while (true);
    }

    public File getFile() {
        return file;
    }

    /**
     * Checks if the specified directory has child directory called <code>data</code>.
     * 
     * @param dir Directory to look in.
     * @return Optional with the data directory if found, empty otherwise.
     */
    private Optional<File> findDataDir(File dir) {
        File [] filesInDir = dir.listFiles();
        if (filesInDir == null) {
            return Optional.empty();
        }

        for (File fileInDir : filesInDir) {
            if (fileInDir.isDirectory() && fileInDir.getName().equals("data")) {
                return Optional.of(fileInDir);
            }
        }

        return Optional.empty();
    }

}
