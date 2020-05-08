package com.viettel.democdc.Repositories;

import com.viettel.democdc.Domain.RelyMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelyMessageRepository extends JpaRepository<RelyMessage, Integer> {
}
