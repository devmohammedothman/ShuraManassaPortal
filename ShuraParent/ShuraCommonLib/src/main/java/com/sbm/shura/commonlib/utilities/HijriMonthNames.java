package com.sbm.shura.commonlib.utilities;

public enum HijriMonthNames {

	MOHARAM("محرم", 1), 
	SAFAR("صفر", 2),
	RABEEFST("ربيع الأول", 3),
	RABEELST("ربيع الاخر", 4),
	GOMADAFST("جمادي الأولي", 5),
	GOMADALST("جمادي الأخرة", 6),
	RAGAB("رجب", 7),
	SHAABAN("شعبان", 8),
	RAMADAN("رمضان", 9),
	SHWAL("شوال", 10),
	ZOELKEEDA("ذو القعدة", 11),
	ZOELHEGGA("ذو الحجة", 12);

    private final String key;
    private final Integer value;

    HijriMonthNames(String key, int value) {
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
