package org.zuo.ftpapi.dao.config;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BaseRepository<E extends AbstractEntity>
        extends PagingAndSortingRepository<E, String>, JpaSpecificationExecutor {


}
