package com.cristian.demo;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String location;
    private String numberEmployees;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Employee> employees;

    public Company() {
    }
    public Company(long id, String name, String location, String numberEmployees){
        this.id = id;
        this.name = name;
        this.location = location;
        this.numberEmployees = numberEmployees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(String numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
