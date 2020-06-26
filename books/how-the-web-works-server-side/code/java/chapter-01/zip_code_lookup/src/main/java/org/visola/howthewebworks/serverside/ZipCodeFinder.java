package org.visola.howthewebworks.serverside;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.visola.howthewebworks.serverside.datareader.addressgroup.AddressGroup;

public class ZipCodeFinder {

    private final List<AddressGroup> addressGroups;
    private final Scanner scanner;

    public ZipCodeFinder(List<AddressGroup> addressGroups, Scanner scanner) {
        this.addressGroups = addressGroups;
        this.scanner = scanner;
    }

    public void findLoop() {
        System.out.print("Type a number: ");
        String number = scanner.nextLine();

        Map<String, List<AddressGroup>> groupsByZipCode = addressGroups.stream()
            .filter(a -> a.getZipCode().contains(number))
            .collect(Collectors.groupingBy(AddressGroup::getZipCode));

        System.out.printf("Found %d zipcodes with %s%n", groupsByZipCode.size(), number);

        if (groupsByZipCode.size() == 0) {
            System.out.println();
            return;
        }

        printZipCodeInfo(groupsByZipCode);
    }

    private void printZipCodeInfo(Map<String, List<AddressGroup>> groupsByZipCode) {
        int total = 0;
        for (Entry<String, List<AddressGroup>> entry : groupsByZipCode.entrySet()) {
            int countInZipCode = entry.getValue().size();
            total += countInZipCode;
            System.out.printf("- %d address groups in %s%n", countInZipCode, entry.getKey());
        }
        System.out.printf("%d total address groups found%n%n", total);
    }

}
