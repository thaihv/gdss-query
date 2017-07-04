package com.uitgis.ubps.gdssquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.uitgis.ubps.gdssquery.domain.Doc;
import com.uitgis.ubps.gdssquery.searchrepository.DocsearchRepository;

@Service("docsearchService")
public class DocsearchServiceImpl implements DocsearchService {

	@Autowired
	private DocsearchRepository docsearchRepository;

	@Autowired
	public void setUploadRepository(DocsearchRepository docsearchRepository) {
		this.docsearchRepository = docsearchRepository;
	}

	@Override
	public Doc save(Doc doc) {
		// TODO Auto-generated method stub
		return docsearchRepository.save(doc);
	}

	@Override
	public void delete(Doc doc) {
		// TODO Auto-generated method stub
		docsearchRepository.delete(doc);
	}

	@Override
	public Doc findOne(Long id) {
		// TODO Auto-generated method stub
		return docsearchRepository.findOne(id);
	}

	@Override
	public Iterable<Doc> findAll() {
		// TODO Auto-generated method stub
		return docsearchRepository.findAll();
	}

	@Override
	public Page<Doc> findByCategory(String category, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return docsearchRepository.findByCategory(category, pageRequest);
	}

	@Override
	public List<Doc> findByTitle(String title) {
		// TODO Auto-generated method stub
		return docsearchRepository.findByTitle(title);
	}

}
