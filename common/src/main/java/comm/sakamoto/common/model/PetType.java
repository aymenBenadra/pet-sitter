package comm.sakamoto.common.model;

public enum PetType {
    DOG(Constants.DOG),
    CAT(Constants.CAT),
    BIRD(Constants.BIRD),
    OTHER(Constants.OTHER);

    PetType(String role) {
        if (!role.equals(this.name())) {
            throw new IllegalArgumentException("Invalid role");
        }
    }

    public static class Constants {
        public static final String DOG = "DOG";
        public static final String CAT = "CAT";
        public static final String BIRD = "BIRD";
        public static final String OTHER = "OTHER";
    }
}
