package org.visola.howthewebworks.serverside.datareader.addressgroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.visola.howthewebworks.serverside.datareader.CSVReader;
import org.visola.howthewebworks.serverside.datareader.DataFile;

public class AddressGroupReader {

    private final DataFile dataFile;

    public AddressGroupReader(String dataFile) throws IOException {
        this.dataFile = new DataFile(dataFile);
    }  

    public List<AddressGroup> readAddressGroups() throws IOException {
        long start = System.currentTimeMillis();
        Reader fileReader = new InputStreamReader(new FileInputStream(dataFile.getFile()), StandardCharsets.UTF_8);

        List<AddressGroup> result = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(fileReader)) {
            String [] values;
            while ( (values = csvReader.readRecord()) != null ) {
                result.add(new AddressGroup(values));
            }
        }

        System.out.printf("Read zip codes in %dms%n", System.currentTimeMillis() - start);
        return result;
    }

}