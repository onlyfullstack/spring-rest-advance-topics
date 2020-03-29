package com.onlyfullstack.springasyncexample.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  @Async
  public void sendMail(String email) {
    System.out.println("Entered in sendMail with mailId : " + email);
    try {
      int seconds = 5;
      for (int i = 1; i <= 5; i++) {
        System.out.println("Wating for " + seconds + " seconds");
        Thread.sleep(1000);
        seconds--;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Exited from sendMail");
  }
}
