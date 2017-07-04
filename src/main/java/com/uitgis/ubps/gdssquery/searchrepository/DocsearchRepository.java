package com.uitgis.ubps.gdssquery.searchrepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.uitgis.ubps.gdssquery.domain.Doc;


@Repository("docsearchRepository")
public interface DocsearchRepository extends ElasticsearchRepository<Doc, Long>{

    Page<Doc> findByCategory(String category, Pageable pageable);

    List<Doc> findByTitle(String title);
}
