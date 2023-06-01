package com.example.Tuan2.validator;

import com.example.Tuan2.entity.PhongBan;
import com.example.Tuan2.validator.annotation.ValidPhongBanId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhongBanIdValidator implements ConstraintValidator<ValidPhongBanId, PhongBan> {
    @Override
    public boolean isValid(PhongBan PHONGBAN, ConstraintValidatorContext context){
        return PHONGBAN !=null && PHONGBAN.getMa_phong()!=null;
    }
}