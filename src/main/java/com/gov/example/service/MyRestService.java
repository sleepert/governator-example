package com.gov.example.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.netflix.archaius.api.Config;

@Path("/hello")
public class MyRestService {
  
  @Inject
  private Config config;
  
  @GET
  public String hello() {
    return config.getString("prop");
  }
}
