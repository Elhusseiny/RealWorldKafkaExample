package com.kafka.demo.repository;

import com.kafka.demo.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface wikimediaRepository extends JpaRepository <WikimediaData , Long> {

}
