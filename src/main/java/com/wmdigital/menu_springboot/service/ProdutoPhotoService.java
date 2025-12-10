package com.wmdigital.menu_springboot.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.wmdigital.menu_springboot.entity.Produto;
import com.wmdigital.menu_springboot.framework.AbstractPhotoService;
import com.wmdigital.menu_springboot.util.StorageDomain;

@Service
public class ProdutoPhotoService extends AbstractPhotoService<Produto> {

	protected ProdutoPhotoService(FileStoregeService storage) {
		super(storage);
		
	}
	
	@Override
	protected UUID getId(Produto entity) {
		
		return entity.getId();
	}

	@Override
	protected StorageDomain domain() {
		
		return StorageDomain.PRODUTOS;
	}

}
