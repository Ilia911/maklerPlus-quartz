package com.itrex.muklerplus.scheduler.config;

import com.itrex.muklerplus.scheduler.job.IntegrationTelegramGetChatHistoryJob;
import com.itrex.muklerplus.scheduler.job.PrimaryCollectorResendJob;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SchedulerConfig {

  @Bean(name = "primaryCollectorResendJobDetail")
  public JobDetailFactoryBean primaryCollectorResendJobDetail() {
    JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
    jobDetailFactory.setJobClass(PrimaryCollectorResendJob.class);
    jobDetailFactory.setDurability(true);
    return jobDetailFactory;
  }

  @Bean(name = "primaryCollectorResendTrigger")
  public CronTriggerFactoryBean primaryCollectorResendTrigger(
      @Qualifier("primaryCollectorResendJobDetail") JobDetail job) {
    CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
    trigger.setJobDetail(job);
    trigger.setCronExpression("0 0/1 * * * ? *");
    return trigger;
  }

  @Bean(name = "integrationTelegramGetChatHistoryJobDetail")
  public JobDetailFactoryBean integrationTelegramGetChatHistoryJobDetail() {
    JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
    jobDetailFactory.setJobClass(IntegrationTelegramGetChatHistoryJob.class);
    jobDetailFactory.setDurability(true);
    return jobDetailFactory;
  }

  @Bean(name = "integrationTelegramGetChatHistoryTrigger")
  public CronTriggerFactoryBean integrationTelegramGetChatHistoryTrigger(
      @Qualifier("integrationTelegramGetChatHistoryJobDetail") JobDetail job) {
    CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
    trigger.setJobDetail(job);
    trigger.setCronExpression("0 0/2 * * * ? *");
    return trigger;
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
