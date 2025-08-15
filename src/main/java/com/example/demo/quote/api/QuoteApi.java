package com.example.demo.quote.api;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.quote.model.dto.QuoteUpdateRequest;
import com.example.demo.quote.model.dto.QuoteCreateRequest;
import com.example.demo.quote.model.dto.QuoteModel;
import com.example.demo.quote.model.dto.QuoteSearchCriteria;
import com.example.demo.quote.service.QuoteService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/v1/quotes")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class QuoteApi {

	QuoteService quoteService;

	@PostMapping
	@ResponseStatus(CREATED)
	public QuoteModel create(@RequestBody QuoteCreateRequest request) {
		return new QuoteModel(quoteService.create(request));
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public QuoteModel select(@PathVariable Long id) {
		return new QuoteModel(quoteService.select(id));
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<QuoteModel> search(QuoteSearchCriteria criteria) {
		return quoteService.search(criteria).stream().map(QuoteModel::new).toList();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public QuoteModel update(@PathVariable Long id, @RequestBody QuoteUpdateRequest request) {
		return new QuoteModel(quoteService.update(id, request));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		quoteService.delete(id);
		return ResponseEntity.status(NO_CONTENT).build();
	}
}
