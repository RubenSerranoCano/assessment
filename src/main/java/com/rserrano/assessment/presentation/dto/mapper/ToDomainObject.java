package com.rserrano.assessment.presentation.dto.mapper;

public interface ToDomainObject<D, T> {

    D buildDomainObject(T dto);

}
