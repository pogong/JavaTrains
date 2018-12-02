package com.pogong.MyChat;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class TvCharacterDto {
    private Integer id;
    private int tvSeriesId;
    @NotNull private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public int getTvSeriesId() {
        return tvSeriesId;
    }
    public void setTvSeriesId(int tvSeriesId) {
        this.tvSeriesId = tvSeriesId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}