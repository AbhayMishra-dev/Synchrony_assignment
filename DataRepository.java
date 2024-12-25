package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Data;

public interface DataRepository extends JpaRepository<Data, Long> {

    void updateData(Long id, String newData);
}
