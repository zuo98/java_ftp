package org.zuo.ftpapi.dao.config;

public interface BaseDao<E extends AbstractEntity> {
    E save(E entity);

    Iterable<E> save(Iterable<E> entities);

    E findOne(String id);
}
