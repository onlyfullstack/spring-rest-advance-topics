package com.onlyfullstack.springasyncexample.controller;

import com.onlyfullstack.springasyncexample.service.EmployeeService;
import java.util.concurrent.CompletableFuture;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("asynch")
@Log
public class CompletableFutureController {

  @Autowired
  EmployeeService service;

  @GetMapping("normal")
  public String getAsynchNormal() throws InterruptedException {
    log.info("Entered in getAsynchNormal");
    Thread.sleep(4000);
    log.info("Exited from getAsynchNormal");
    return "Asynch";
  }

  @GetMapping("callable")
  public CompletableFuture<String> getAsynchWithCallableFuture() {
    log.info("Entered in getAsynchWithCallableFuture");
    CompletableFuture<String> result = service.getCompletableFuture();
    log.info("Exited from getAsynchWithCallableFuture : "+result.isDone());
    return result;
  }
}

