package com.uitgis.ubps.gdssquery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.uitgis.ubps.gdssquery.domain.Doc;

public interface DocsearchService {

	Doc save(Doc upload);

	void delete(Doc upload);

	Doc findOne(Long id);

	Iterable<Doc> findAll();

	Page<Doc> findByCategory(String category, PageRequest pageRequest);

	List<Doc> findByTitle(String title);
}
