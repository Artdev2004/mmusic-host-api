package com.etec.mmusic.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderEntity {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false)
    private UUID id;

    @ElementCollection(fetch = FetchType.EAGER)
    @ManyToOne
    @JoinColumn(name = "attendant")
    private UserEntity attendant;

    @ElementCollection(fetch = FetchType.EAGER)
    @ManyToOne
    @JoinColumn(name = "requester")
    private UserEntity requester;

    private String description;

    @Column(name = "status", updatable = false, nullable = false, insertable = false, columnDefinition = "VARCHAR(10) DEFAULT 'UNREALIZED'")
    private String status;

    @Column(name = "timestamp")
    private LocalDateTime timestamp = new Date().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
