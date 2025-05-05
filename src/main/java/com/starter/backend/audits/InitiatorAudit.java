package com.starter.backend.audits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.UUID;

@MappedSuperclass
@JsonIgnoreProperties(value = {"createdBy","updatedBy"},allowGetters = true)
@Getter
@Setter
public class InitiatorAudit  extends TimeStampAudit{
    private static final long serialVersionUID =1l;
   @CreatedBy
    @Column(name = "created_by")
    private UUID createdBy;
   @LastModifiedBy
    @Column(name = "updated_by")
    private UUID updatedBy;
}
