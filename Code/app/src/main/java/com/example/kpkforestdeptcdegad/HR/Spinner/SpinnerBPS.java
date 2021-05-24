package com.example.kpkforestdeptcdegad.HR.Spinner;

public class SpinnerBPS {

    public String Id;
    public String BPS;

    public SpinnerBPS(String id, String BPS) {
        Id = id;
        this.BPS = BPS;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBPS() {
        return BPS;
    }

    public void setBPS(String BPS) {
        this.BPS = BPS;
    }

    @Override
    public String toString() {
        return BPS;
    }
}
