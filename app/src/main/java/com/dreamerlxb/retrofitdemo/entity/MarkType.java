package com.dreamerlxb.retrofitdemo.entity;

/**
 * Created by sxb on 2017/5/2.
 */

public class MarkType {

    /**
     * typeName : temp
     * typeDesc : 临时类型
     * typeDetail : null
     * typeGroupId : 0
     * id : 1
     */

    private String typeName;
    private String typeDesc;
    private String typeDetail;
    private int typeGroupId;
    private int id;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    public int getTypeGroupId() {
        return typeGroupId;
    }

    public void setTypeGroupId(int typeGroupId) {
        this.typeGroupId = typeGroupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
