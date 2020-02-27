package com.cristian.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        // First let's create a director
        Company company = new Company();
        Company company1 = new Company();
        Company company2 = new Company();
        Company company3 = new Company();

        company.setName("CACI");
        company.setLocation("Arlington VA");
        company.setNumberEmployees("20,000");

        company1.setName("Capital One");
        company1.setLocation("McLean VA");
        company1.setNumberEmployees("48,000");

        company2.setName("Lockheed Martin");
        company2.setLocation("Bethesda MD");
        company2.setNumberEmployees("105,000");

        company3.setName("Transamerica Corporation");
        company3.setLocation("Baltimore MD");
        company3.setNumberEmployees("25,000");

        // Now let's create a movie
        Employee employee = new Employee();
        employee.setFirstName("Bobby T.");
        employee.setLastName("Lynch");
        employee.setPosition("Finance Analyst");
        employee.setShift("Morning");

        Employee employee1 = new Employee();
        employee1.setFirstName("Robert G.");
        employee1.setLastName("Harris");
        employee1.setPosition("Executer Analyst");
        employee1.setShift("Morning");

        Employee employee2 = new Employee();
        employee2.setFirstName("James N.");
        employee2.setLastName("Sullivan");
        employee2.setPosition("Dermatology Nurse");
        employee2.setShift("Morning");

        Employee employee3 = new Employee();
        employee3.setFirstName("Joseph D.");
        employee3.setLastName("Viramontes");
        employee3.setPosition("Automated systems librarian");
        employee3.setShift("Afternoon");

        // Add the movie to an empty list
        Set<Employee> employees = new HashSet<Employee>();
        Set<Employee> employees1 = new HashSet<Employee>();
        Set<Employee> employees2 = new HashSet<Employee>();
        Set<Employee> employees3 = new HashSet<Employee>();
        employees.add(employee);
        employees1.add(employee1);
        employees2.add(employee2);
        employees3.add(employee3);

        employee = new Employee();
        employee.setFirstName("Gary M.");
        employee.setLastName("Gaddis");
        employee.setPosition("Telephone service representative");
        employee.setShift("Evening");

        // Add the list of movies to the director's movie list
        company.setEmployees(employees);
        company1.setEmployees(employees1);
        company2.setEmployees(employees2);
        company3.setEmployees(employees3);

        // Save the director to the database
        companyRepository.save(company);
        companyRepository.save(company1);
        companyRepository.save(company2);
        companyRepository.save(company3);

        // Grab all the directors from the database and send them to
        // the template
        model.addAttribute("companies", companyRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/addCompany")
    public String companyForm(Model model){
        model.addAttribute("company", new Company());
        return "companyform";
    }
    @PostMapping("processCompany")
    public String processForm(@ModelAttribute Company company){
        companyRepository.save(company);
        return "redirect:/";
    }

    @GetMapping("/addEmployee")
    public String employeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }
    @PostMapping("processEmployee")
    public String processForm(@ModelAttribute Employee employee){

        employeeRepository.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        model.addAttribute("companySearch", companyRepository.findByName(search));
        return "searchList";
    }
}
