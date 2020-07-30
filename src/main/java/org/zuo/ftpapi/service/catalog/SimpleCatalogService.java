package org.zuo.ftpapi.service.catalog;

import org.zuo.ftpapi.contract.Catalog;
import org.zuo.ftpapi.contract.ICatalogService;
import org.zuo.ftpapi.dao.config.AbstractEntity;
import org.zuo.ftpapi.dao.config.BaseDao;

public abstract class SimpleCatalogService<T extends Catalog, E extends AbstractEntity>
        implements ICatalogService<T> {

    private final BaseDao<E> dao;
    private final CatalogMapper<T, E> mapper;

    public SimpleCatalogService(BaseDao<E> dao, CatalogMapper<T, E> mapper) {
        super();
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public boolean save(T entity) throws Throwable {
        final E _entity = this.mapper.tToe(entity);
        return this.dao.save(_entity) != null;

    }


}
