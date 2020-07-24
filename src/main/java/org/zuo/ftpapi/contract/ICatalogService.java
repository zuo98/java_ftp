package org.zuo.ftpapi.contract;

public interface ICatalogService<T extends Catalog> {

    boolean save(T entity) throws Throwable;


}
