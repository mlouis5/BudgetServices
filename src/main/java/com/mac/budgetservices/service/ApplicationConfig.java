/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.budgetservices.service;

import java.util.Set;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author MacDerson
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig(){
        //this.packages("com.mac.budgetservices", "com.mac.budgetservices.service.filters");
       
        //Set<Class<?>> resources = new java.util.HashSet<>();
        register(com.mac.budgetservices.service.AddressFacadeREST.class);
        register(com.mac.budgetservices.service.BillFacadeREST.class);
        register(com.mac.budgetservices.service.IncomeFacadeREST.class);
        register(com.mac.budgetservices.service.PaycheckFacadeREST.class);
        register(com.mac.budgetservices.service.PaymentFacadeREST.class);
        register(com.mac.budgetservices.service.UserFacadeREST.class);
        register(com.mac.budgetservices.service.filters.CORSResponseFilter.class);
    }
    /**
     *
     * @return
     */
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> resources = new java.util.HashSet<>();
//        addRestResourceClasses(resources);
//        return resources;
//    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) { //Set<Class<?>> resources
        resources.add(com.mac.budgetservices.service.AddressFacadeREST.class);
        resources.add(com.mac.budgetservices.service.BillFacadeREST.class);
        resources.add(com.mac.budgetservices.service.IncomeFacadeREST.class);
        resources.add(com.mac.budgetservices.service.PaycheckFacadeREST.class);
        resources.add(com.mac.budgetservices.service.PaymentFacadeREST.class);
        resources.add(com.mac.budgetservices.service.UserFacadeREST.class);
    }
    
}
