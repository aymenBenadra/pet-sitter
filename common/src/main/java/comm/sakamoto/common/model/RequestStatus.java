package comm.sakamoto.common.model;

public enum RequestStatus {
    PENDING(Constants.PENDING),
    ACCEPTED(Constants.ACCEPTED),
    REJECTED(Constants.REJECTED);

    RequestStatus(String role) {
        if (!role.equals(this.name())) {
            throw new IllegalArgumentException("Invalid role");
        }
    }

    public static class Constants {
        public static final String PENDING = "PENDING";
        public static final String ACCEPTED = "ACCEPTED";
        public static final String REJECTED = "REJECTED";
    }
}
