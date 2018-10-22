/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.helloworld;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;
import java.util.Set;

/**
 * A simple CDI service which is able to say hello to someone
 *
 * @author Pete Muir
 *
 */

public class HelloService {
    static {
        if (Boolean.getBoolean("test.use.property"))
        {
            System.setProperty("javax.xml.validation.SchemaFactory:http://www.w3.org/2001/XMLSchema",
                  "org.apache.xerces.jaxp.validation.XMLSchemaFactory");
        }
    }

    String createHelloMessage(String name) {

        System.out.println("#############################################################");
        Set<String> propertyNames = System.getProperties().stringPropertyNames();
        for (String propertyName : propertyNames)
        {
            if(propertyName.startsWith("javax.xml"))
            {
                System.out.println(propertyName + " = " + System.getProperty(propertyName));
            }
        }

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        System.out.println(schemaFactory.getClass());
        System.out.println(schemaFactory.getClass().getProtectionDomain().getCodeSource().getLocation());
        System.out.println("#############################################################");

        return "Hello " + name + "!";
    }

}
