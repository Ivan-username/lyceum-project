package org.liceum.edm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDto {
    String userId;
    String docType;
    String documentRef;
}
