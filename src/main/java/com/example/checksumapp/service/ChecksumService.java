
package com.example.checksumapp.service;

import com.example.checksumapp.model.ChecksumEntry;
import com.example.checksumapp.repository.ChecksumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class ChecksumService {

    @Autowired
    private ChecksumRepository checksumRepository;

    public ChecksumEntry generateChecksum(String input, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            ChecksumEntry entry = new ChecksumEntry(input, algorithm, hexString.toString());
            return checksumRepository.save(entry);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Invalid algorithm: " + algorithm);
        }
    }

    public List<ChecksumEntry> getAllChecksums() {
        return checksumRepository.findAll();
    }
}
