package comm.sakamoto.common.model;

public enum PostStatus {
    OPEN(Constants.OPEN),
    CLOSED(Constants.CLOSED);

    PostStatus(String role) {
        if (!role.equals(this.name())) {
            throw new IllegalArgumentException("Invalid role");
        }
    }

    public static class Constants {
        public static final String OPEN = "OPEN";
        public static final String CLOSED = "CLOSED";
    }
}
