package se.arbetsformedlingen.dropwizard;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {

    @Rule
    public DropwizardAppRule<Configuration> application =
            new DropwizardAppRule<>(Main.class, ResourceHelpers.resourceFilePath("test-configuration.yaml"));

    @Test
    public void should_get_template() {
        Configuration configuration = application.getConfiguration();

        assertThat(configuration.getTemplate()).isEqualTo("Hello, %s!");
    }
}
