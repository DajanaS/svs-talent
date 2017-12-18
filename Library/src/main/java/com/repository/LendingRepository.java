package com.repository;

import com.lending.Lending;
import org.springframework.data.repository.CrudRepository;

public interface LendingRepository extends CrudRepository<Lending, Long> {
    Iterable<Lending> findAllByMemberId(Long memberId);

    Iterable<Lending> findAllByBookId(Long bookId);
}
