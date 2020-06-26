package org.visola.howthewebworks.serverside;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.visola.howthewebworks.serverside.datareader.addressgroup.AddressGroup;
import org.visola.howthewebworks.serverside.datareader.addressgroup.AddressGroupReader;

public class ZipCodeLookupMain {

    private static List<AddressGroup> addressGroups;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.console().reader());
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println(" Q (or q) - to quit");
            System.out.println(" Z (or z) - to search for zipcode");
            System.out.print("\n> ");


            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("q")) {
                System.out.println("Good bye.");
                break;
            }

            if (option.equalsIgnoreCase("z")) {
                new ZipCodeFinder(getData(), scanner).findLoop();
            }
        }
    }

    private static List<AddressGroup> getData() throws IOException {
        if (addressGroups == null) {
            addressGroups = new AddressGroupReader("city_of_boston.csv")
                .readAddressGroups();
        }

        return addressGroups;
    }

}
