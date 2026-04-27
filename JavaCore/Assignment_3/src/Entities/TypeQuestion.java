package Entities;

public class TypeQuestion {
    int typeID;
    TypeName typeName;

    //Constructor

    public TypeQuestion(TypeName typeName) {
        this.typeID++;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Entities.TypeQuestion{" +
                "typeID=" + typeID +
                ", typeName=" + typeName +
                '}';
    }
}
