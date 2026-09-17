package com.example.movieservice.modules.nation.domain.entity;

public class Nation {

    private Integer nationId;

    private String nationName;

    private String nationCode;

    public Nation(Integer nationId, String nationName, String nationCode) {
        this.nationId = nationId;
        this.nationName = nationName;
        this.nationCode = nationCode;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public static Nation createNation(String name, String code) {
        return new Nation(null, name, code);
    }

    public static Nation reconstitute(int id, String name, String code) {
        return new Nation(id, name, code);
    }
}
