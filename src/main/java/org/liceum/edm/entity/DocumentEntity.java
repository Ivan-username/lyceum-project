package org.liceum.edm.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Data
@Accessors(chain = true)
@Table(name = "documents")
public class DocumentEntity {

    @Id
    private String documentId;
    private String docType;
    private String documentRef;
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

}
