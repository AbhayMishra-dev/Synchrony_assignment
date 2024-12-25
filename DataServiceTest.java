package com.example.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DataServiceTest {

    @Mock
    private DataRepository dataRepository;

    @Mock
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testGetDataFromDatabase() {
        DataService dataService = new DataService(dataRepository, redisTemplate);

        when(dataRepository.findById(1L)).thenReturn(Optional.of(new Data(1L, "testData")));

        String data = dataService.getDataFromDatabase(1L);

        assertEquals("testData", data);
        verify(redisTemplate, times(1)).opsForValue().set("1", "testData");
    }
}
