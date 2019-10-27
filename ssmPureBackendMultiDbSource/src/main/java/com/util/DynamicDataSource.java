package com.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{
    public static final String DATA_SOURCE_ONE = "dataSourceOne";
    public static final String DATA_SOURCE_ANOTHER = "dataSourceAnother";
    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    
    /**
     * Transfer data source which is upper final varaible. 
     * @param customerType
     */
    public static void setCustomerType(String customerType){
        contextHolder.set(customerType);
    }

    /**
     * Get one data source.
     * @return data source
     */
    public static String getCustomerType(){
        System.out.format("data source:"+contextHolder.get());
        return contextHolder.get();
    }

    /**
     * Clear data source.
     */
    public static void clearCustomerType(){
        contextHolder.remove();
    }

    /**
     * Switch data source.
     */
    @Override 
    protected Object determineCurrentLookupKey(){
        return getCustomerType();
    }
}