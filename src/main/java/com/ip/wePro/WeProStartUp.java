package com.ip.wePro;

import com.ip.wePro.project.Project;
import com.ip.wePro.project.ProjectRepository;
import com.ip.wePro.project.ProjectSkills;
import com.ip.wePro.testing.Book;
import com.ip.wePro.testing.BookRepository;
import com.ip.wePro.testing.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class WeProStartUp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WeProStartUp.class, args);

    }

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public void run(String... arg0){

        Book apple = new Book("Apple");
        Book samsung = new Book("Samsung");

        Pages iphone7 = new Pages(7, apple);
        Pages iphone8 = new Pages(8, apple);

        Pages galaxyJ1 = new Pages(1, samsung);
        Pages galaxyJ2 = new Pages(2, samsung);

        apple.setPages(new HashSet<Pages>(){{
            add(iphone7);
            add(iphone8);
        }});

        samsung.setPages(new HashSet<Pages>(){{
            add(galaxyJ1);
            add(galaxyJ2);
        }});

        bookRepository.save(apple);
        bookRepository.save(samsung);
        System.out.println("Here");

        System.out.println(bookRepository.findAll());

        Project project = new Project("first", "first desc", 1, 30, new Date(), 12, 0, 2, 24, "Yes");

        ProjectSkills projectSkills1 = new ProjectSkills(project,1);
        ProjectSkills projectSkills2 = new ProjectSkills(project,2);

        project.setSkills(new HashSet<ProjectSkills>(){{
            add(projectSkills1);
            add(projectSkills2);
        }});

        projectRepository.save(project);

        System.out.println(projectRepository.findAll());
    }



}
