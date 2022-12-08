package com.etec.mmusic.repository;

import com.etec.mmusic.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    @Query("select o from OrderEntity o where o.attendant.id = ?1 and o.status = 'UNREALIZED'")
    List<OrderEntity> findByAttendantId(UUID id);

    @Query("select o from OrderEntity o where o.id = ?1")
    OrderEntity findOrderEntityById(UUID id);

    @Query("select o from OrderEntity o where o.id = ?1 and o.status = 'UNREALIZED'")
    OrderEntity findByOrderIdStatusEqualsUnrealized(UUID id);

    @Modifying
    @Query("update OrderEntity o set o.status = 'REALIZED' where o.id = ?1 ")
    @Transactional
    void updateStatusOfOrder(UUID id);

}
