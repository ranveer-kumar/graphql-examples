package com.examples.graphql.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeadMedia {
	private MediaType mediaType;
	@Builder.Default
	private List<Image> images = new ArrayList<>();
	@Builder.Default
	private List<Video> videos = new ArrayList<>();

}