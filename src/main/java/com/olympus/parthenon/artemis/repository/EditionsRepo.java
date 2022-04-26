package com.olympus.parthenon.artemis.repository;

import com.olympus.parthenon.artemis.models.Editions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EditionsRepo extends MongoRepository<Editions, String> {
    @Query("{title:'?0'}")
    List<Editions> findByTitle(String title);

    @Query("{}")
    List<Editions> findAll();

    @Query(value="{$text: {$search: '?0'}}", sort = "{latest_revision: -1}", count = true)
    List<Editions> findSomething(String text);

    @Query(value="{$text: {$search: '?0'}}", sort = "{latest_revision: -1}", count = true)
    Page<Editions> findSomethingPaged(String text, Pageable pageable);

    public long count();
}
