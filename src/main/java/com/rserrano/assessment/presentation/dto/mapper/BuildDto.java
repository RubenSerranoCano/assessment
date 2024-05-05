package com.rserrano.assessment.presentation.dto.mapper;

public interface BuildDto<T, D> {

    T buildDto(D domainObject);

}
