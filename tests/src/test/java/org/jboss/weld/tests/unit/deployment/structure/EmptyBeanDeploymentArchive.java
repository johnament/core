/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
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
package org.jboss.weld.tests.unit.deployment.structure;

import java.util.Collection;
import java.util.Collections;

import org.jboss.arquillian.container.weld.ee.embedded_1_1.mock.MockEjbInjectionServices;
import org.jboss.arquillian.container.weld.ee.embedded_1_1.mock.MockJpaInjectionServices;
import org.jboss.arquillian.container.weld.ee.embedded_1_1.mock.MockResourceInjectionServices;
import org.jboss.weld.bootstrap.api.ServiceRegistry;
import org.jboss.weld.bootstrap.api.helpers.SimpleServiceRegistry;
import org.jboss.weld.bootstrap.spi.BeanDeploymentArchive;
import org.jboss.weld.bootstrap.spi.BeansXml;
import org.jboss.weld.ejb.spi.EjbDescriptor;
import org.jboss.weld.injection.spi.EjbInjectionServices;
import org.jboss.weld.injection.spi.JpaInjectionServices;
import org.jboss.weld.injection.spi.ResourceInjectionServices;

public class EmptyBeanDeploymentArchive implements BeanDeploymentArchive {

    private final ServiceRegistry services = new SimpleServiceRegistry();

    public EmptyBeanDeploymentArchive() {
        this.services.add(EjbInjectionServices.class, new MockEjbInjectionServices());
        this.services.add(JpaInjectionServices.class, new MockJpaInjectionServices());
        this.services.add(ResourceInjectionServices.class, new MockResourceInjectionServices());
    }

    @Override
    public Collection<BeanDeploymentArchive> getBeanDeploymentArchives() {
        return Collections.emptySet();
    }

    @Override
    public Collection<String> getBeanClasses() {
        return Collections.emptySet();
    }

    @Override
    public BeansXml getBeansXml() {
        return null;
    }

    @Override
    public Collection<EjbDescriptor<?>> getEjbs() {
        return Collections.emptySet();
    }

    @Override
    public ServiceRegistry getServices() {
        return services;
    }

    @Override
    public String getId() {
        return "EMPTY";
    }
}
