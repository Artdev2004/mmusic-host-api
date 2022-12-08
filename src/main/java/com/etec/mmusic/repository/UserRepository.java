package com.etec.mmusic.repository;

import com.etec.mmusic.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query("select u from UserEntity u where u.id = ?1")
    UserEntity findUserEntityById(UUID id);

    Optional<UserEntity> findByUsername(String username);

}
