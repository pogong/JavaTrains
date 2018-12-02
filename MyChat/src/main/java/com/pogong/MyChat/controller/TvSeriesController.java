package com.pogong.MyChat.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;

import com.pogong.MyChat.pojo.TvSeries;
import com.pogong.MyChat.service.TvSeriesService;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/tvseries"})
public class TvSeriesController {
    private static final Log log = LogFactory.getLog(TvSeriesController.class);

    @Autowired TvSeriesService tvSeriesService;

    public TvSeriesController() {
    }

    @GetMapping
    public List<TvSeries> getAll() {
        if (log.isTraceEnabled()) {
            log.trace("getAll()被调用了");
        }

        return tvSeriesService.getAllTvSeries();
    }

}
