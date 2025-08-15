package com.example.demo.quote.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

	List<Quote> findByMessageContainingIgnoreCase(String search);
}
