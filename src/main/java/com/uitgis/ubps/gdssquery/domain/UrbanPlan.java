package com.uitgis.ubps.gdssquery.domain;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(indexName = "qsmasterplan", type = "masterplan")
public class UrbanPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String title;
	@Column
	private String planningUnit;
	@Column
	private String division;
	@Column
	private String scale;
	@Column
	private String description;

	private Author author;
	
	private Publisher publisher;


}