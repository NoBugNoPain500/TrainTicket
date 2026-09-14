package modules.shared.entity;

public enum BusinessCode {

    SUCCESS(1000, "Success", 200);

    final int businessCode;

    final String message;

    final int statusCode;

    BusinessCode(int businessCode, String message, int statusCode) {
        this.businessCode = businessCode;
        this.message = message;
        this.statusCode = statusCode;
    }

    public int getBusinessCode() {
        return businessCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
