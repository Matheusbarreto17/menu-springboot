package com.wmdigital.menu_springboot.framework;

import java.io.IOException;


import org.springframework.web.multipart.MultipartFile;

import com.wmdigital.menu_springboot.service.FileStoregeService;
import com.wmdigital.menu_springboot.util.StorageDomain;


public abstract class AbstractPhotoService <Entity>{
	
	protected final FileStoregeService storage;

	  protected AbstractPhotoService(FileStoregeService storage) {
	    this.storage = storage;
	  }

	  protected abstract java.util.UUID getId(Entity entity);
	  protected abstract StorageDomain  domain();
	  
	  public String save(Entity entity, MultipartFile file) throws IOException {
		    return storage.saveEntityPhoto(domain(), getId(entity), file);
		  }

		  public void deleteAll(Entity entity) throws IOException {
		    storage.deleteEntityFolder(domain(), getId(entity));
		  }

}
