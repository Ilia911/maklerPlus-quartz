package com.itrex.muklerplus.scheduler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(QuartzApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Application started");
  }
}
