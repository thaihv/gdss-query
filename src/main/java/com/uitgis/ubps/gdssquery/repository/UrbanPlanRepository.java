package com.uitgis.ubps.gdssquery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uitgis.ubps.gdssquery.domain.UrbanPlan;

@RepositoryRestResource(collectionResourceRel = "urbanplan", path = "Urbanplan")
public interface UrbanPlanRepository extends PagingAndSortingRepository<UrbanPlan, Long> {

}