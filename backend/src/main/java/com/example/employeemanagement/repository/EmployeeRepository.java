package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * THE RULE:
 *
 * - A class implements an interface:        class Foo implements Bar
 * - An interface extends another interface: interface Foo extends Bar
 * - An interface can even extend multiple interfaces at once:
 *       interface Foo extends Bar, Baz
 *   This is one place Java allows multiple inheritance, unlike with classes.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);


}
