package com.nasrobot.repository.repository.site;

import com.nasrobot.repository.entity.site.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends CrudRepository<Site, Long> {
}
