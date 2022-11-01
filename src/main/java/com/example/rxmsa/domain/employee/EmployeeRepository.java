package com.example.rxmsa.domain.employee;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author : nakgyeom
 * @date : 2022-11-01 오후 2:18
 */
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String>, ReactiveQueryByExampleExecutor<Employee> {
}
