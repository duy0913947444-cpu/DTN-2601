package com.vti.entity;

import com.vti.Enums.Gender;

public class KySu extends CanBo {
    private String nganhDaoTao;

    public KySu(String name, int age, Gender gender, String address, String nganhDaoTao) {
        super(name, age, gender, address);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return "KySu{" + super.toString() +
                ", nganhDaoTao='" + nganhDaoTao + '\'' +
                '}';
    }
}
