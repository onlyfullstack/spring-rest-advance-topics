package com.onlyfullstack.springasyncexample;

import com.onlyfullstack.springasyncexample.controller.CompletableFutureController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
@Log
public class SpringAsyncExampleApplication implements CommandLineRunner {

  @Autowired
  ApplicationContext applicationContext;
  
  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }

  @Bean
  public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("only-fullstack-");
    executor.initialize();
    return executor;
  }

  @Override
  public void run(String... args) throws ExecutionException, InterruptedException {
    log.info("******** Entered inside run method");
    CompletableFutureController controller = (CompletableFutureController) this.applicationContext.getBean("completableFutureController");

    CompletableFuture<String> res = controller.getAsynchWithCallableFuture();
    log.info("******** Checking the CompletableFuture status : " + res.isDone());
    log.info(res.get());
    log.info("******** Exited from run method");
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    SpringApplication.run(SpringAsyncExampleApplication.class, args);

  }
}
