package se.arbetsformedlingen.dropwizard.greeting;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class Endpoint {
    private String template;
    private final String defaultName;
    private final AtomicLong counter;

    public Endpoint(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Hello sayHello(@QueryParam("name") Optional<String> name) {
        String value = String.format(template, name.orElse(defaultName));
        return new Hello(counter.incrementAndGet(), value);
    }
}