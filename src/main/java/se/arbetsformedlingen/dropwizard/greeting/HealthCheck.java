package se.arbetsformedlingen.dropwizard.greeting;

public class HealthCheck extends com.codahale.metrics.health.HealthCheck {
    private final String template;

    public HealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}