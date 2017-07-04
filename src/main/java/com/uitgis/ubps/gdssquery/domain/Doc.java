package com.uitgis.ubps.gdssquery.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Document(indexName = "qsdocs", type = "doc")
public class Doc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String format;
	@Column
	private String category;
	@Column
	private String language;
	@Column
	private String releaseDate;
	@Column
	private String summary;
	@Column
	private String description;
	
	private Author author;
	
	private Publisher publisher;

	public Doc(Long id, String title, String format, String category, String language, String releaseDate,
			String summary, String description, Author author, Publisher publisher) {
		super();
		this.id = id;
		this.title = title;
		this.format = format;
		this.category = category;
		this.language = language;
		this.releaseDate = releaseDate;
		this.summary = summary;
		this.description = description;
		this.author = author;
		this.publisher = publisher;
	}


	
	



}
