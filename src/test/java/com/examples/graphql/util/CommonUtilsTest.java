package com.examples.graphql.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import com.examples.graphql.util.CommonUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CommonUtilsTest {

	
	@ParameterizedTest
	@MethodSource("urls")
	void urlGeneratorTest(String url, String expectedValue) {
		assertEquals(expectedValue, CommonUtils.urlGenerator(url, 1L));
	}
	
	private static Stream<Arguments> urls() {
	    return Stream.of(
	            Arguments.of("abc@", "abc-1.html"),
	            Arguments.of("hello how r u", "hello-how-r-u-1.html")
//	            Arguments.of("hello$@#how r u", "hello-how-r-u-1.html")
	    );
	}

}
