package ch5.item1;

public enum OrdinalEnum {
    SOLO(1), DUET(2), TRIO(3);
    private final int seq;

    OrdinalEnum(int seq) {
        this.seq = seq;
    }

    public int seqOfEnum() {
        return seq;
    }
}
