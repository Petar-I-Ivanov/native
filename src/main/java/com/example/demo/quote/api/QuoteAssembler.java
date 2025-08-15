package com.example.demo.quote.api;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.example.demo.quote.model.Quote;
import com.example.demo.quote.model.dto.QuoteModel;

@Component
public class QuoteAssembler extends RepresentationModelAssemblerSupport<Quote, QuoteModel> {

	public QuoteAssembler() {
		super(QuoteApi.class, QuoteModel.class);
	}

	@Override
	public QuoteModel toModel(Quote quote) {
		return QuoteModel.builder().id(quote.getId()).message(quote.getMessage()).build()
				.add(linkTo(methodOn(QuoteApi.class).create(null)).withRel("create"))
				.add(linkTo(methodOn(QuoteApi.class).update(quote.getId(), null)).withRel("update"))
				.add(linkTo(methodOn(QuoteApi.class).delete(quote.getId())).withRel("delete"));
	}
}
