package com.gov.example;

import com.google.inject.Injector;
import com.gov.example.service.MySevletModule;
import com.netflix.archaius.guice.ArchaiusModule;
import com.netflix.governator.InjectorBuilder;
import com.netflix.governator.guice.jersey.GovernatorJerseySupportModule;
import com.netflix.governator.guice.jetty.Archaius2JettyModule;

public class Application {

  public static void main(String[] args) {
    Injector injector = InjectorBuilder.fromModules(
        new ArchaiusModule(),
        new Archaius2JettyModule(),
        new GovernatorJerseySupportModule(),
        new MySevletModule())
        .createInjector();
  }
}
