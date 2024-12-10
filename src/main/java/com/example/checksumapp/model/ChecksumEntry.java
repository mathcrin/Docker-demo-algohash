
package com.example.checksumapp.model;

import jakarta.persistence.*;

@Entity
public class ChecksumEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String input;
    private String algorithm;
    private String checksum;

    public ChecksumEntry() {}

    public ChecksumEntry(String input, String algorithm, String checksum) {
        this.input = input;
        this.algorithm = algorithm;
        this.checksum = checksum;
    }

    public Long getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getChecksum() {
        return checksum;
    }
}
