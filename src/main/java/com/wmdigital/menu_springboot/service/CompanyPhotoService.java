package com.wmdigital.menu_springboot.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.wmdigital.menu_springboot.entity.Company;
import com.wmdigital.menu_springboot.framework.AbstractPhotoService;
import com.wmdigital.menu_springboot.util.StorageDomain;

@Service
public class CompanyPhotoService extends AbstractPhotoService<Company>  {

	protected CompanyPhotoService(FileStoregeService storage) {
		super(storage);
	
	}

	@Override
	protected UUID getId(Company entity) {
	
		return entity.getId();
	}

	@Override
	protected StorageDomain domain() {
		
		return StorageDomain.COMPANYS;
	}

}
