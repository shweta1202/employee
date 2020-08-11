package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisEmployeeRepository {

    final private HashOperations<String, Integer, Employee> hashOperations;
    final private RedisTemplate<String, Employee> redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisEmployeeRepository.class);

    public RedisEmployeeRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Employee employee){
        hashOperations.put("EMPLOYEE", employee.getEmpId(), employee);
        redisTemplate.expire("EMPLOYEE",1, TimeUnit.MINUTES);
    }
    public List<Employee> findAll(){
        return hashOperations.values("EMPLOYEE");
    }

    public Employee findById(int id){
        return hashOperations.get("EMPLOYEE", id);
    }

    public void update(Employee employee){
        save(employee);
    }

    public void delete(int id){
        hashOperations.delete("EMPLOYEE", id);
    }

    public Long getSize() {
        return hashOperations.size("EMPLOYEE");
    }

    public void saveAll(List<Employee> employeeList) {
        for(Employee e: employeeList) {
            hashOperations.put("EMPLOYEE", e.getEmpId(), e);
        }
        redisTemplate.expire("EMPLOYEE", 1, TimeUnit.MINUTES);
    }
}
