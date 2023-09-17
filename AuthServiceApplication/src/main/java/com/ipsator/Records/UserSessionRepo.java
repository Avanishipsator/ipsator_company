package com.ipsator.Records;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipsator.Entity.UserSession;

@Repository
public interface UserSessionRepo extends JpaRepository<UserSession, Integer> {

}
