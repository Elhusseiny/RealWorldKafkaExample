package com.kafka.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="wikimedia_recentchange")
public class WikimediaData {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long id ;

	@Lob
	@Column(name = "wiki_data")
	private String wikiData ;
}
