package com.assignment.backend.request;

import com.assignment.backend.enums.VerificationDocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerificationDetails {
  private String userId;

  @NotBlank(message = "Identity number  is required")
  private String idNumber;

  @NotBlank(message = "Document type is required")
  private VerificationDocumentType idType;
}
