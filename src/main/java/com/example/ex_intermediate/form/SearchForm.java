package com.example.ex_intermediate.form;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SearchForm {
    @Pattern(regexp = "^$|^-?[0-9]{1,6}$", message = "数字を入力してください")
    private String price;
}
