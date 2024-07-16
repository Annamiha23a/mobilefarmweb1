package com.example.mobilefarmweb.excel;
import com.example.mobilefarmweb.entity.Feed;

import java.util.List;
import java.util.Map;

public class RationsExcelData {
    private String nameRation;
    private String feedgroup;
    private List<String> nameTable1;
    private List<String> dataReal;

    private List<String> variance;
    private List<String> feedtitle;
    private List<Object> feeds;

    // геттеры и сеттеры
    public String getNameRation() {
        return nameRation;
    }

    public void setNameRation(String nameRation) {
        this.nameRation = nameRation;
    }

    public String getFeedgroup() {
        return feedgroup;
    }

    public void setFeedgroup(String feedgroup) {
        this.feedgroup = feedgroup;
    }

    public List<String> getNameTable1() {
        return nameTable1;
    }

    public void setNameTable1(List<String> nameTable1) {
        this.nameTable1 = nameTable1;
    }

    public List<String> getDataReal() {
        return dataReal;
    }

    public void setDataReal(List<String> dataReal) {
        this.dataReal = dataReal;
    }

    public List<String> getVariance() {
        return variance;
    }

    public void setVariance(List<String> variance) {
        this.variance = variance;
    }



    public List<String> getFeedtitle() {
        return feedtitle;
    }

    public void setFeedtitle(List<String> feedtitle) {
        this.feedtitle = feedtitle;
    }

    public List<Object> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Object> feeds) {
        this.feeds = feeds;
    }
}