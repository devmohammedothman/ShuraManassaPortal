package com.sbm.shura.entity.lookups.enums;

public enum EXPERIENCETYPE {

	 EXPERIENCETYPE("Experience", 1), 
	 SPECIALIZATION("Specialization", 2);

    private final String key;
    private final Integer value;

    EXPERIENCETYPE(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
	
}
