package com.pogong.MyChat.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogong.MyChat.dao.TvCharacterDao;
import com.pogong.MyChat.dao.TvSeriesDao;
import com.pogong.MyChat.pojo.TvCharacter;
import com.pogong.MyChat.pojo.TvSeries;


@Service
public class TvSeriesService {
    private final Log log = LogFactory.getLog(TvSeriesService.class);

    @Autowired
    private TvSeriesDao seriesDao;
    @Autowired
    private TvCharacterDao characterDao;

    public List<TvSeries> getAllTvSeries() {
        if (log.isTraceEnabled()) {
            log.trace("getAllTvSeries started");
        }
        List<TvSeries> list = seriesDao.getAll();

        return list;
    }

    @Cacheable(cacheNames="TvSeries",key="#id")
    public TvSeries getOneById(int id) {
        if (log.isTraceEnabled()) {
            log.trace("getOneById started");
        }
        return seriesDao.getOneById(id);
    }

    public void insert(TvSeries tvSeries) { seriesDao.insert(tvSeries); }

    public void delete(int id){
        seriesDao.delete(id);
    }

    public void logicDelete(int id, String reason){
        seriesDao.logicDelete(id,reason);
    }
}
