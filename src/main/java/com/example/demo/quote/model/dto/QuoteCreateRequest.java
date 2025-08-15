package com.example.demo.quote.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record QuoteCreateRequest(@NotBlank @Size(min = 3, max = 255) String message) {
}
