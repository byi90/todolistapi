package com.todolistapi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolistapi.data.entity.JwtTokenBlacklist;

@Repository
public interface JwtTokenBlacklistRepository extends JpaRepository<JwtTokenBlacklist, Long> {

    JwtTokenBlacklist findByToken(String token);

    JwtTokenBlacklist deleteAllByExpiryAtLessThan(long time);


}
