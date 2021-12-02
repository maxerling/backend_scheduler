package com.example.scheduler.repositories;

import com.example.scheduler.models.Authority;
import com.example.scheduler.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority,Long> {
}
