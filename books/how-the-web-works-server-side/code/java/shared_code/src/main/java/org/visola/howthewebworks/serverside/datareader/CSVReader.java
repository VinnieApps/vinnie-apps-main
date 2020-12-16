package org.visola.howthewebworks.serverside.datareader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class CSVReader implements AutoCloseable  {

    private final BufferedReader reader;
    private final List<String> header;

    public CSVReader(Reader readFrom) throws IOException {
        this(readFrom, true);
    }

    public CSVReader(Reader readFrom, boolean hasHeader) throws IOException {
        if (readFrom instanceof BufferedReader) {
            this.reader = (BufferedReader) readFrom;
        } else {
            this.reader = new BufferedReader(readFrom);
        }

        if (hasHeader) {
            String firstLine = this.reader.readLine();
            if (firstLine != null) {
                header = ImmutableList.copyOf(firstLine.split(","));
            } else {
                header = ImmutableList.of();
            }
        } else {
            header = ImmutableList.of();
        }
    }

    public void close() throws IOException {
        this.reader.close();
    }

    public List<String> getHeader() {
        return this.header;
    }

    public String[] readRecord() throws IOException {
        String line = this.reader.readLine();
        if (line == null) {
            return null;
        }

        return line.split(",");
    }

}