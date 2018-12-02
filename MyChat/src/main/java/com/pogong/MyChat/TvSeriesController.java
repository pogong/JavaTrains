package com.pogong.MyChat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    public TvSeriesController() {
    }

    @GetMapping
    public List<TvSeriesDto> getAll() {
        if (log.isTraceEnabled()) {
            log.trace("getAll()被调用了");
        }

        List<TvSeriesDto> list = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, 3, 1, 0, 0);
        list.add(new TvSeriesDto(1, "Got", 1, calendar.getTime()));
        calendar.set(2013, 3, 1, 0, 0);
        list.add(new TvSeriesDto(2, "Got", 2, calendar.getTime()));
        calendar.set(2014, 3, 1, 0, 0);
        list.add(new TvSeriesDto(3, "Got", 3, calendar.getTime()));
        calendar.set(2015, 3, 1, 0, 0);
        list.add(new TvSeriesDto(4, "Got", 4, calendar.getTime()));
        return list;
    }

    @GetMapping({"/{id}"})
    public TvSeriesDto getOne(@PathVariable int id) {
        if (log.isTraceEnabled()) {
            log.trace("getOne()被调用了 " + id);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 3, 1, 0, 0);
        return new TvSeriesDto(id, "any TV", 0, calendar.getTime());
    }

    @PostMapping
    public TvSeriesDto insertOne(@Valid @RequestBody TvSeriesDto tvSeriesDto) {
        if (log.isTraceEnabled()) {
            log.trace("insertOne()被调用了 " + tvSeriesDto);
        }

        tvSeriesDto.setId(9999);
        return tvSeriesDto;
    }

    @PostMapping({"/{id}/addPhotoFax"})
    public void addPhoto(@PathVariable int id, @RequestParam(value = "any",required = false) int any) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("addPhotoFax()被调用了 " + id);
        }

    }

    @PostMapping(
            value = {"/{id}/addPhoto"},
            consumes = {"multipart/form-data"}
    )
    public void addPhoto(@PathVariable int id, @RequestParam("photo") MultipartFile imageFile) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("addPhoto()被调用了 " + id);
        }

        FileOutputStream fos = new FileOutputStream("target/" + imageFile.getOriginalFilename());
        fos.close();
    }

    @GetMapping(
            value = {"/{id}/getPhoto"},
            produces = {"image/png"}
    )
    public byte[] getPhoto(@PathVariable int id) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("getPhoto()被调用了 " + id);
        }

        String imagePath = "target/xxhh.png";
        InputStream ips = new FileInputStream(imagePath);
        return IOUtils.toByteArray(ips);
    }
}
