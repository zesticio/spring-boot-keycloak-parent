package com.zestic.authy.keycloak.utils;

public class Utils {

    public static boolean isNullOrEmpty(final String value){
        if(value==null || value.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
