package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Cacheable(value = "dataCache", key = "#id")
    public String getDataFromDatabase(Long id) {
        String cachedData = (String) redisTemplate.opsForValue().get(id.toString());
        if (cachedData != null) {
            return cachedData;
        }

        String data = dataRepository.findById(id).orElse(null).toString();
        redisTemplate.opsForValue().set(id.toString(), data);
        return data;
    }

    @CacheEvict(value = "dataCache", key = "#id")
    public void updateData(Long id, String newData) {
        dataRepository.updateData(id, newData);
        redisTemplate.opsForValue().set(id.toString(), newData);
    }

    public void processParallelTasks() {
        executorService.submit(() -> dataRepository.save(new Data()));
        executorService.submit(() -> redisTemplate.opsForValue().set("newKey", "newValue"));
    }
}
