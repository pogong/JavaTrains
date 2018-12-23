package com.pogong.MyChat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pogong.MyChat.pojo.TvSeries;
import org.apache.ibatis.annotations.Param;

public interface TvSeriesDao {
    public List<TvSeries> getAll();

    public TvSeries getOneById(int id);

    public void insert(TvSeries tvSeries);

    public void delete(int id);

    public void logicDelete(@Param("id")int id, @Param("reason")String reason);
}
