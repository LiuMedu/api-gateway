package com.ex.gateway.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// each of the property names starts with a prefix of app we will need to annotation our Java Bean with:
// @ConfigurationProperties(prefix = "message.default")
// http://www.appsdeveloperblog.com/reading-application-properties-spring-boot/

@Component
@ConfigurationProperties("app")
public class AppProperties {
 
 private String title;
 private String description;
 public String getTitle() {
  return title;
 }
 public void setTitle(String title) {
  this.title = title;
 }
 public String getDescription() {
  return description;
 }
 public void setDescription(String description) {
  this.description = description;
 }
 
}