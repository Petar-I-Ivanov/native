package com.example.demo.quote.service;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.util.StringUtils.hasText;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.quote.model.Quote;
import com.example.demo.quote.model.QuoteRepository;
import com.example.demo.quote.model.dto.QuoteUpdateRequest;
import com.example.demo.quote.model.dto.QuoteCreateRequest;
import com.example.demo.quote.model.dto.QuoteSearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class QuoteServiceImpl implements QuoteService {

	QuoteRepository quoteRepository;

	@Override
	public Quote create(QuoteCreateRequest request) {
		return quoteRepository.save(new Quote(null, request.message()));
	}

	@Override
	public Quote select(Long id) {
		return quoteRepository.getReferenceById(id);
	}

	@Override
	public List<Quote> search(QuoteSearchCriteria criteria) {
		if (!hasText(criteria.search())) {
			return quoteRepository.findAll();
		}

		return quoteRepository.findByMessageContainingIgnoreCase(criteria.search());
	}

	@Override
	public Quote update(Long id, QuoteUpdateRequest request) {
		var quote = select(id);
		quote.setMessage(request.message());
		return quote;
	}

	@Override
	public void delete(Long id) {
		quoteRepository.deleteById(id);
	}
}
