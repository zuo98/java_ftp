package org.zuo.ftpapi.dao.config;


public abstract class SpringDao<E extends AbstractEntity> implements BaseDao<E> {

    private final BaseRepository<E> repository;

    protected SpringDao(BaseRepository<E> repository) {
        this.repository = repository;
    }

    @Override
    public E save(E entity) {
        return this.repository.save(entity);
    }

    @Override
    public Iterable<E> save(Iterable<E> entities) {
        return this.repository.saveAll(entities);
    }

    @Override
    public E findOne(String id) {
        return this.repository.findById(id).get();
    }

}
