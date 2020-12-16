package org.visola.howthewebworks.serverside;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.visola.howthewebworks.serverside.datareader.CSVReader;
import org.visola.howthewebworks.serverside.datareader.DataFile;

public class Main {

    public static void main(String [] args) throws Exception {
        DataFile dataFile = new DataFile("city_of_boston.csv");
        Reader fileReader = new InputStreamReader(new FileInputStream(dataFile.getFile()), StandardCharsets.UTF_8);
        try (CSVReader reader = new CSVReader(fileReader)) {
            String [] line;
            Map<String, Integer> countsByZipCode = new TreeMap<>();
            while ((line = reader.readRecord()) != null) {
                String zipCode = line[8];
                if (zipCode.trim().isEmpty()) {
                    continue;
                }

                Integer count = countsByZipCode.getOrDefault(zipCode, 0);
                count++;
                countsByZipCode.put(zipCode, count);
            }

            System.out.println("ZIP_CODE,COUNT");
            for (Entry<String, Integer> entry : countsByZipCode.entrySet()) {
                System.out.printf("%s,%d%n", entry.getKey(), entry.getValue());
            }
        }
    }

}