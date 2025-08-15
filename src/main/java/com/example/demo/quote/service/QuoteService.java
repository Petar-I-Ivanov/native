package com.example.demo.quote.service;

import java.util.List;
import com.example.demo.quote.model.Quote;
import com.example.demo.quote.model.dto.QuoteUpdateRequest;
import com.example.demo.quote.model.dto.QuoteCreateRequest;
import com.example.demo.quote.model.dto.QuoteSearchCriteria;

public interface QuoteService {

	Quote create(QuoteCreateRequest request);

	Quote select(Long id);

	List<Quote> search(QuoteSearchCriteria criteria);

	Quote update(Long id, QuoteUpdateRequest request);

	void delete(Long id);
}
