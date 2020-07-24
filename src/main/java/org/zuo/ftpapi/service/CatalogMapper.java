package org.zuo.ftpapi.service;

import org.zuo.ftpapi.contract.Catalog;
import org.zuo.ftpapi.dao.config.AbstractEntity;

import java.util.List;

public interface CatalogMapper<T extends Catalog, E extends AbstractEntity> {

    T eTot(E entity) throws Throwable;

    E tToe(T entity) throws Throwable;

    List<T> eTot(Iterable<E> entities) throws Throwable;

    List<E> tToe(Iterable<T> entities) throws Throwable;


}
