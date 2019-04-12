package com.javarnd.pns.enums;

public enum CompanyTypeEnum {
	CONSIGNOR(1, "Consignor"),
	CONSIGNEE(2, "Consignee");

	private final int name;
	private final String value;

	private CompanyTypeEnum(int name,String value) {
        this.name = name;
        this.value = value;
    }

	public String getValue() {
		return value;
	}

	public int getName() {
		return name;
	}

	public static CompanyTypeEnum getEnumByName(int name) {
		CompanyTypeEnum[] modes = CompanyTypeEnum.values();
		if (modes == null) {
			return null;
		}
		for (CompanyTypeEnum mode : modes) {
			if (mode.getName()==name) {
				return mode;
			}
		}
		return null;
	}

	public static CompanyTypeEnum getEnumByValue(String value) {
		CompanyTypeEnum[] modes = CompanyTypeEnum.values();
		if (modes == null) {
			return null;
		}
		for (CompanyTypeEnum mode : modes) {
			if (mode.getValue().equals(value)) {
				return mode;
			}
		}
		return null;
	}

}
