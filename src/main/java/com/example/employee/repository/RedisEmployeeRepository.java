package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisEmployeeRepository {

    final private HashOperations<String, Integer, Employee> hashOperations;
    final private RedisTemplate<String, Employee> redisTemplate;
    final private ValueOperations valueOperations;

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisEmployeeRepository.class);

    public RedisEmployeeRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
        this.valueOperations = this.redisTemplate.opsForValue();
        //setExpire("EMPLOYEE",2,TimeUnit.MINUTES);
    }

    public void setExpire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public void save(Employee employee){
        //hashOperations.put("EMPLOYEE", employee.getEmpId(), employee);
        redisTemplate.opsForValue().set(String.valueOf(employee.getEmpId()), employee, 1, TimeUnit.MINUTES);
    }
    public List<Employee> findAll(){
        return hashOperations.values("Employee");
    }

    public Employee findById(int id){
        return (Employee) redisTemplate.opsForValue().get(id);
    }

    public void update(Employee employee){
        save(employee);
    }

    public void delete(int id){
        hashOperations.delete("EMPLOYEE", id);
    }

    public void saveAll(List<Employee> employeeList) {
        for(Employee e: employeeList) {
            //hashOperations.put("EMPLOYEE", e.getEmpId(), e);
            valueOperations.set(String.valueOf(e.getEmpId()), e, 1, TimeUnit.MINUTES);
        }
    }
}
