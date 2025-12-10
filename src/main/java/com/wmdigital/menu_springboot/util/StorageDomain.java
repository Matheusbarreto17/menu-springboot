package com.wmdigital.menu_springboot.util;

public enum StorageDomain {

    PRODUTOS("produtos"),
    COMPANYS("companys");
   
    private final String folder;
    
    StorageDomain(String folder) { 
    	this.folder = folder;
    	}
    public String folder() {
    	return folder;
    	}

}
