package com.uitgis.ubps.gdssquery.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uitgis.ubps.gdssquery.domain.Author;


@RepositoryRestResource
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

	List<Author> findByname(@Param("name") String name);
}
