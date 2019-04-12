package com.javarnd.pns.enums;

public enum ResourceEnum {

	RESOURCE_PATH("path","/WEB-INF/view/");
	

	private final String name;
	private final String value;

	private ResourceEnum(String value, String name) {
        this.name = name;
        this.value = value;
    }

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static ResourceEnum getEnumByName(String name) {
		ResourceEnum[] modes = ResourceEnum.values();
		if (modes == null) {
			return null;
		}
		for (ResourceEnum mode : modes) {
			if (mode.getName().equals(name)) {
				return mode;
			}
		}
		return null;
	}

	public static ResourceEnum getEnumByValue(String value) {
		ResourceEnum[] modes = ResourceEnum.values();
		if (modes == null) {
			return null;
		}
		for (ResourceEnum mode : modes) {
			if (mode.getValue().equals(value)) {
				return mode;
			}
		}
		return null;
	}

}
