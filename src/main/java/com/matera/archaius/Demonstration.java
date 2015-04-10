package com.matera.archaius;

import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicDoubleProperty;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

import java.util.Date;

/**
 * Hello Archaius!
 *
 */
public class Demonstration {

    public static void main(String[] args) throws InterruptedException {

        DynamicPropertyFactory factory = DynamicPropertyFactory.getInstance();

        DynamicStringProperty appName = factory.getStringProperty("appname", "N/A");
        DynamicDoubleProperty salary = factory.getDoubleProperty("salary", 0.0);
        DynamicLongProperty birthdate = factory.getLongProperty("birthdate", 0);
        DynamicBooleanProperty parent = factory.getBooleanProperty("parent", false);
        DynamicStringProperty description = factory.getStringProperty("description", "N/A");

        salary.addCallback(() -> {
            System.out.println(".......... Valor do salário foi alterado ..........");
        });

        System.out.println("\n=========================================================");
        System.out.println("Rodando o app: " + appName.get());
        
        while (true) {
            System.out.println("Salary: " + salary.get());
            System.out.println("Birthdate: " + new Date(birthdate.get()));
            System.out.println("Parent: " + parent.get());
            System.out.println("Description: " + description.get());
            System.out.println("=======================================================\n");

            // Waiting 5s
            Thread.sleep(5000);
        }
    }
}