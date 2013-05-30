package com.scoa.roadrunner.common.dto;

import java.io.Serializable;

/**
 *
 */
public class KeyValueDropDown implements Serializable {

    private Long id;
    private String entityKey;
    private String entityValue;
    private boolean selected = false;

    public KeyValueDropDown() {}

    public KeyValueDropDown(String entityKey, String entityValue) {
        this.entityKey = entityKey;
        this.entityValue = entityValue;
    }

    public KeyValueDropDown(Long id, String entityKey, String entityValue, boolean selected) {
        this.id=id;
        this.entityKey = entityKey;
        this.entityValue = entityValue;
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityKey() {
        return entityKey;
    }

    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }

    public String getEntityValue() {
        return entityValue;
    }

    public void setEntityValue(String entityValue) {
        this.entityValue = entityValue;
    }


}
