package com.gov.example.service;

import java.util.Arrays;
import java.util.function.UnaryOperator;

import javax.inject.Named;
import javax.inject.Singleton;

import com.google.inject.servlet.ServletModule;
import com.netflix.governator.guice.jersey.GovernatorServletContainer;
import com.netflix.governator.providers.Advises;
import com.sun.jersey.api.core.DefaultResourceConfig;

public class MySevletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    serve("/*").with(GovernatorServletContainer.class);
    binder().bind(GovernatorServletContainer.class).asEagerSingleton();
  }
  
  @Advises
  @Singleton
  @Named("governator")
  UnaryOperator<DefaultResourceConfig> adviseWithMyApplicationResources() {
      return defaultResourceConfig -> {
          defaultResourceConfig.getClasses().addAll(Arrays.asList(
              MyRestService.class
          ));
          return defaultResourceConfig;
      };
  }
}
