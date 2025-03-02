package com.arachnid.bex.registration.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityUserRepository
    extends JpaRepository<SecurityUser, Long> {

  Optional<SecurityUser> findByUsername(String username);
}
