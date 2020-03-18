package com.shopproe.shopprodata.bean;

import java.util.HashMap;
import java.util.Map;

public class SwiperBean {
    private Integer code;
    private String result;
    private Map<String, Object> map = new HashMap<String, Object>();
    private String[] re = new String[]{};

    public SwiperBean add(String key, Object value){
        this.getMap().put(key, value);
        return this;
    }

    public static SwiperBean success(){
        SwiperBean swiperBean = new SwiperBean();
        swiperBean.setCode(100);
        swiperBean.setResult("SUCCESS");
        return swiperBean;
    }

    public static SwiperBean fail(){
        SwiperBean swiperBean = new SwiperBean();
        swiperBean.setCode(200);
        swiperBean.setResult("FAIL");
        return swiperBean;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String[] getRe() {
        return re;
    }

    public void setRe(String[] re) {
        this.re = re;
    }
}
