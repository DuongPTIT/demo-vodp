package com.viettel.democdc.Repositories;

import com.viettel.democdc.Domain.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxRepository extends JpaRepository<Outbox, String> {
}
