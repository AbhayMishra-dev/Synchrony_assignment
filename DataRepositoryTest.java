package com.example.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DataRepositoryTest {

    @Autowired
    private DataRepository dataRepository;

    @Test
    public void testSaveData() {
        Data data = new Data(1L, "newData");
        dataRepository.save(data);

        assertNotNull(dataRepository.findById(1L).orElse(null));
    }
}
