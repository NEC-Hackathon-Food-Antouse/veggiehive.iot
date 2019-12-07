package com.nec.foodstorage.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Responses {
	List<LabelAnnotations> labelAnnotations;
	ImagePropertiesAnnotation imagePropertiesAnnotation;
	@JsonIgnore
	CropHintsAnnotation cropHintsAnnotation;
	@JsonIgnore
	LogoAnnotations logoAnnotations;
}
