package com.wmdigital.menu_springboot.util;

public enum StorageDomain {
	BARBEIROS("barbeiros"),
    PRODUTOS("produtos"),
    SERVICOS("servicos"),
    CLIENTES("clientes"),
	COMPANYS("companys");

    private final String folder;
    
    StorageDomain(String folder) { 
    	this.folder = folder;
    	}
    public String folder() {
    	return folder;
    	}

}
