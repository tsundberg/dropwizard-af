package se.arbetsformedlingen.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.arbetsformedlingen.dropwizard.greeting.Endpoint;
import se.arbetsformedlingen.dropwizard.greeting.HealthCheck;

public class Main extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        String template = configuration.getTemplate();
        String defaultName = configuration.getDefaultName();

        Endpoint helloWorld = new Endpoint(template, defaultName);
        environment.jersey().register(helloWorld);

        HealthCheck healthCheck = new HealthCheck(template);
        environment.healthChecks().register("template", healthCheck);
    }
}