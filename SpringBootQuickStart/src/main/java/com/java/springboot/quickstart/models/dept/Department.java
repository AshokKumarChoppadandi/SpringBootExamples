package com.java.springboot.quickstart.models.dept;

public class Department {
    private int dId;
    private String dName;
    private String dDescription;

    public Department(int dId, String dName, String dDescription) {
        this.dId = dId;
        this.dName = dName;
        this.dDescription = dDescription;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdDescription() {
        return dDescription;
    }

    public void setdDescription(String dDescription) {
        this.dDescription = dDescription;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dDescription='" + dDescription + '\'' +
                '}';
    }
}
