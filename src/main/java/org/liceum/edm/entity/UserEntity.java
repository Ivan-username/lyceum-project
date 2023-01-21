package org.liceum.edm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Пользователь
 */
@Entity
@Data
@Accessors(chain = true)
@Table(name = "users")
public class UserEntity {

    @Id
    private String userId;
    private String name;
    private LocalDate birthDay;
    private LocalDateTime createdAt;

}
