package com.example.demo.configuration;

import static org.springframework.aot.hint.MemberCategory.DECLARED_FIELDS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_PUBLIC_METHODS;

import java.util.Set;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import com.example.demo.quote.model.dto.QuoteSearchCriteria;

@Configuration
@ImportRuntimeHints(NativeHintsConfig.NativeRuntimeHints.class)
public class NativeHintsConfig {

	public static class NativeRuntimeHints implements RuntimeHintsRegistrar {

		private static final Set<String> TYPES = Set.of("org.mariadb.jdbc.Configuration",
				"org.mariadb.jdbc.Configuration$Builder", QuoteSearchCriteria.class.getName());

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			registerTypes(hints);
		}

		private static void registerTypes(RuntimeHints hints) {
			TYPES.forEach(type -> hints.reflection().registerType(TypeReference.of(type), builder -> builder
					.withMembers(INVOKE_PUBLIC_CONSTRUCTORS, INVOKE_PUBLIC_METHODS, DECLARED_FIELDS)));
		}
	}
}
