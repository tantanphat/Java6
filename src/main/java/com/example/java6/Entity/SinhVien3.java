package com.example.java6.Entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien3 {
    @NotBlank(message = "{validation.email.notblank}")
    @Email(message = "{validation.email.email}")
    private String email;

    @NotBlank(message = "{validation.fullName.notblank}")
    private String fullName;

    @NotNull(message = "{validation.marks.notnull}")
    @PositiveOrZero(message = "{validation.marks.positiveorzero}")
    @Max(value = 10, message = "{validation.marks.max}")
    private Double marks;

    @NotNull(message = "{validation.gender.notnull}")
    private Boolean gender;

    @NotNull(message = "{validation.Country.notnull}")
    private String country;
}
