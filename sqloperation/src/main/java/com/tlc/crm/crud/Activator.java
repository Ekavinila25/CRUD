package com.tlc.crm.crud;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author KavinilaE
 */
public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) {
        System.out.println("Starting the bundle");
    }

    @Override
    public void stop(BundleContext bundleContext) {
        System.out.println("test");
    }
}
