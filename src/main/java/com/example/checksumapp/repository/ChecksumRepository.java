
package com.example.checksumapp.repository;

import com.example.checksumapp.model.ChecksumEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecksumRepository extends JpaRepository<ChecksumEntry, Long> {
}
