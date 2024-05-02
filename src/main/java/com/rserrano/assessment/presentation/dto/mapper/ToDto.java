package com.rserrano.assessment.presentation.dto.mapper;

public interface ToDto<T, D> {

    T buildDto(D domainObject);

}
