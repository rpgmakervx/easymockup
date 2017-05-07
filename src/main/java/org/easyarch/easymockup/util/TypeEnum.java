package org.easyarch.easymockup.util;

/**
 * Created by xingtianyu on 17-5-7
 * 下午3:31
 * description:
 */

public enum TypeEnum {

    String(String.class.getName()),
    Integer(Integer.class.getName()),
    Character(Character.class.getName()),
    Float(java.lang.Float.class.getName());

    private String typeName;

    TypeEnum(String typeName){
        this.typeName = typeName;
    }

    public String getTypeName(){
        return typeName;
    }

    public static String getName(String enumName){
        for (TypeEnum enu : values()){
            if (enu.name().equals(enumName)){
                return enu.getTypeName();
            }
        }
        return "";
    }

}
