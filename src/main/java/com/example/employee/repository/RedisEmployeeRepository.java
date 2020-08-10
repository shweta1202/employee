package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisEmployeeRepository {

    final private HashOperations hashOperations;
    final private RedisTemplate redisTemplate;

    public RedisEmployeeRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Employee employee){
        hashOperations.put("EMPLOYEE", employee.getEmpId(), employee);
    }
    public List<Employee> findAll(){
        return hashOperations.values("EMPLOYEE");
    }

    public Employee findById(int id){
        return (Employee) hashOperations.get("EMPLOYEE", id);
    }

    public void update(Employee employee){
        save(employee);
    }

    public void delete(int id){
        hashOperations.delete("EMPLOYEE", id);
    }
}
