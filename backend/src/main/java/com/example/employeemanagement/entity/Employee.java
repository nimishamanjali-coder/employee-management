package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
/*
 * WHY WE NEED A NO-ARG CONSTRUCTOR:
 *
 * When Hibernate loads a row from the database, it doesn't know your
 * custom constructor's parameter order or which fields you chose to include.
 * Instead, its process is:
 *
 * 1. Instantiate the entity using the no-arg constructor (via reflection —
 *    basically calling new Employee() with nothing).
 * 2. Then use reflection to set each field individually (via the setters,
 *    or direct field access depending on config) — setId(1), setFirstName("John"), etc.
 *
 * If there's no no-arg constructor available, Hibernate has no way to
 * create the bare object first — it'll throw an exception at runtime
 * (InstantiationException or similar) the moment it tries to map a
 * query result back into an Employee.
 */
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(nullable = false,unique = true)
    private String email;

    private String jobTitle;

    private String department;

    private String status;

    private LocalDate hireDate;

    // This constructor excludes the id field because the database generates the id automatically when a new employee is saved.
    public Employee(String firstName, String lastName, String email, String jobTitle, String department, String status, LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.department = department;
        this.status = status;
        this.hireDate = hireDate;
    }
}
