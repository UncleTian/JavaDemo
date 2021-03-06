package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.ParentEntity;
import com.art2cat.dev.jpademo.models.Subsidiary;
import org.springframework.data.repository.CrudRepository;

/**
 * com.art2cat.dev.jpademo.repositories
 *
 * @author rorschach
 * @date 4/12/18
 */

public interface SubsidiaryRepository extends CrudRepository<Subsidiary, Integer> {
    
    ParentEntity findSubByName(String name);
    
    ParentEntity findSubBySubId(Integer subId);
}
