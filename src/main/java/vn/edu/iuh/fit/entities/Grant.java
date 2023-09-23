package vn.edu.iuh.fit.entities;

public enum Grant {
    GRANTED("1"),
    DENIED("0"),
    UNKNOWN("-1");

    private final String value;

    Grant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Grant fromValue(String value) {
        for (Grant grant : values()) {
            if (grant.value.equals(value)) {
                return grant;
            }
        }
        return UNKNOWN;
    }
}

