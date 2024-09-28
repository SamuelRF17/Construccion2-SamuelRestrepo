package app;

import app.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
    @Autowired
    LoginController controller;
    public static void main(String[] args) {
        System.out.println("aa");
        SpringApplication.run(AppApplication.class, args);
        System.out.println("bb");

    }

    @Override
    public void run(String... args) throws Exception {
        try{
            controller.session();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
