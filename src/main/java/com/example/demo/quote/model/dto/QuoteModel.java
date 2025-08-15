package com.example.demo.quote.model.dto;

import static lombok.AccessLevel.PRIVATE;

import org.springframework.hateoas.RepresentationModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = PRIVATE)
public class QuoteModel extends RepresentationModel<QuoteModel> {

	Long id;
	String message;
}
