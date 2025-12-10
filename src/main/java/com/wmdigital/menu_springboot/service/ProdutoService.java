package com.wmdigital.menu_springboot.service;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.wmdigital.menu_springboot.dao.ProdutoRepository;
import com.wmdigital.menu_springboot.entity.Produto;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;

@Service
public class ProdutoService extends AbstractEntityService<Produto>  {
	
	private final ProdutoRepository produtoDAO;
	private final ProdutoPhotoService produtoPhotoService;

	protected ProdutoService(ProdutoRepository produtoDAO, ProdutoPhotoService produtoPhotoService) {
		super(Produto.class, "produto");
		
		this.produtoDAO = produtoDAO;
		this.produtoPhotoService = produtoPhotoService;
	}

	@Override
	protected JpaRepository<Produto, UUID> getDao() {
	
		return produtoDAO;
	}

	@Override
	protected void validateSave(Produto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateEdit(Produto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateDelete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getIdEntity(Produto entity) {
		
		return entity.getId().toString();
	}

	@Override
	public List<Produto> findAllNew() {
		
		return produtoDAO.findAll();
	}

	@Transactional
	public String uploadFoto(UUID id, MultipartFile file) throws IOException {
	    Produto b = getDao().findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
	    String url = produtoPhotoService.save(b, file);
	    return url;
	}
	
	@Transactional
	public void removerFotos(UUID id) throws IOException {
	    Produto b = getDao().findById(id)
	    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
	    produtoPhotoService.deleteAll(b);
	   
	}
}
