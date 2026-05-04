package com.vti.entity;

import Enums.TypeName;

public class TypeQuestion {
    private int typeID;
    private TypeName typeName;

    //Constructor

    public TypeQuestion(TypeName typeName) {
        this.typeID++;
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "com.vti.entity.TypeQuestion{" +
                "typeID=" + typeID +
                ", typeName=" + typeName +
                '}';
    }
}
