/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.service;

import com.mycompany.zopa.lending.Lender;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author andre
 */
public class CSVParser {

    public List<Lender> parse(String fileName)
            throws FileNotFoundException, IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records
                = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        List<Lender> lenders = new ArrayList<>();
        records.forEach(r -> lenders.add(createLenderFromRecord(r)));
        return lenders;
    }

    private Lender createLenderFromRecord(CSVRecord r) {
        return new Lender(
                r.get("Lender"),
                Float.parseFloat(r.get("Rate")),
                Float.parseFloat(r.get("Available"))
        );
    }

}
