package com.viniciusbe.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "DepartmentDto Model Information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;

    @Schema(description = "Department name")
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
