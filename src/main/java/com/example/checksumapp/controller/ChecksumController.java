
package com.example.checksumapp.controller;

import com.example.checksumapp.model.ChecksumEntry;
import com.example.checksumapp.service.ChecksumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/algoHash")
public class ChecksumController {

    @Autowired
    private ChecksumService checksumService;

    @PostMapping
    public ChecksumEntry createChecksum(@RequestParam String input, @RequestParam(defaultValue = "SHA-256") String algorithm) {
        return checksumService.generateChecksum(input, algorithm);
    }

    @GetMapping
    public ChecksumEntry getChecksumFromQuery(@RequestParam String input, @RequestParam(defaultValue = "SHA-256") String algorithm) {
        return checksumService.generateChecksum(input, algorithm);
    }

    @GetMapping("/all")
    public List<ChecksumEntry> getAllChecksums() {
        return checksumService.getAllChecksums();
    }
}
