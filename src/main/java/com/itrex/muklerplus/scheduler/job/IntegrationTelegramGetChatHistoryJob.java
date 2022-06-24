package com.itrex.muklerplus.scheduler.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Log4j2
public class IntegrationTelegramGetChatHistoryJob implements Job {

  private final RestTemplate restTemplate;

  @Value("${integration-telegram.scheduler.get-chats.notification.url}")
  private String resendNotificationUrl;

  public void execute(JobExecutionContext context) throws JobExecutionException {

    ResponseEntity<String> stringResponseEntity =
        restTemplate.postForEntity(resendNotificationUrl, null, String.class);
    log.info(
        "Get chats notification was sent with response status code: {}",
        stringResponseEntity.getStatusCode());
  }
}
