package com.vti.Enum;

public enum PositionName {
    DEV("D"), TEST("T"), SCRUM_MASTER("SM"), PM("PM");
    private String name;

    private PositionName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static PositionName toEnum(String sqlPositionName){
        for(PositionName item: PositionName.values()){
            if(item.getName().equals(sqlPositionName)){
                return item;
            }
        }
        return null;
    }
}
