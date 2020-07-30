package org.zuo.ftpapi.contract.catalogContract;


public interface ICatalogService<T extends Catalog> {

    boolean save(T entity) throws Throwable;


}
