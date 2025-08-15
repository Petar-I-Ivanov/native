package com.example.demo.quote.model.dto;

import com.example.demo.quote.model.Quote;

public record QuoteModel(Long id, String message) {

	public QuoteModel(Quote quote) {
		this(quote.getId(), quote.getMessage());
	}
}
