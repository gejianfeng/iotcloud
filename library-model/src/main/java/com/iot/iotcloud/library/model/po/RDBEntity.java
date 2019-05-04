package com.iot.iotcloud.library.model.po;

import com.sun.javafx.beans.IDProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 关系型数据库实体基类
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public abstract class RDBEntity extends BaseEntity implements Serializable {

    /**
     * 索引
     */
    protected String id;

    /**
     * 创建人
     */
    protected String createdBy;

    /**
     * 修改人
     */
    protected String modifiedBy;

    /**
     * 创建时间
     */
    protected Date createdTime;

    /**
     * 修改时间
     */
    protected Date modifiedTime;

    /**
     * 删除标志位
     */
    protected boolean isDeleted;

    /**
     * 获取索引
     * @return 索引
     */
    public String getId() {
        return id;
    }

    /**
     * 设置索引
     * @param id 待设置索引
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取创建人索引
     * @return 创建人索引
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人索引
     * @param createdBy 待设置创建人索引
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取最后修改人索引
     * @return 最后修改人索引
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * 设置最后修改人索引
     * @param modifiedBy 待设置最后修改人索引
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * 获取创建时间
     * @return 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     * @param createdTime 待设置创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取最后修改时间
     * @return 最后修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置最后修改时间
     * @param modifiedTime 待设置最后修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取删除标记
     * @return 删除标记
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * 设置删除标记
     * @param deleted 待设置删除标记
     */
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
