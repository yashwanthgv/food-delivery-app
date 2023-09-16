package com.bigapps.order.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collation = "sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {
	@Id
	private String id;
    private int sequence;
}
