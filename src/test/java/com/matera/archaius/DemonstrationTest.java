package com.matera.archaius;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

import java.net.URL;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DemonstrationTest {

    @BeforeClass
    public static void setup() throws ConfigurationException {

        URL resource = DemonstrationTest.class.getResource("/config-test.properties");
        PropertiesConfiguration configuration = new PropertiesConfiguration(resource);
        ConfigurationManager.install(configuration);
    }

    @Test
    public void test() {

        DynamicStringProperty test = DynamicPropertyFactory.getInstance().getStringProperty("test", "N/A");
        Assert.assertNotEquals(test.get(), "N/A");
        Assert.assertEquals(test.get(), "algum valor para testes");
    }
}
