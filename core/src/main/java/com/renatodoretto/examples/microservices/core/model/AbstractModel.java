package com.renatodoretto.examples.microservices.core.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.EqualsAndHashCode;

public abstract class AbstractModel {

	@Id
	@EqualsAndHashCode.Include
    private Long id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
