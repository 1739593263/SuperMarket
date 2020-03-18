package com.shopproe.shopprodata.controller;

import com.shopproe.shopprodata.bean.SwiperBean;
import com.shopproe.shopprodata.bean.saveImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin("http://localhost:8081")
public class axiosTest {
    //    @ResponseBody
    @RequestMapping("/msg")
    public String test() {
        return "success";
    }

    @RequestMapping("/test/data")
    @ResponseBody
    public String data(){
        return "THE SUCCESS hahahahahahahahaha";
    }

    @RequestMapping("/test/multidata")
    @ResponseBody
    public String muldata(@RequestParam("username") Integer user,
                          @RequestParam("password") String pwd){
        System.out.println("user="+user+" pwd="+pwd);
        return "2.0 success HEHE";
    }

    @RequestMapping("/resources/swiper")
    @ResponseBody
    public SwiperBean resdata(){
        // SIMULATE Swiper (because unconnect database)
        SwiperBean swiperBean = new SwiperBean();
        Map<String, Object> resources = new HashMap<String, Object>();
        String[] url = new String[3];
        url[0] = "http://localhost:8080/img/swiper/elephant.png";
        url[1] = "http://localhost:8080/img/swiper/panther.jpg";
        url[2] = "http://localhost:8080/img/swiper/wolf.jpg";
        ArrayList<Map<String,Object>> URL = new ArrayList<>();
        for(int i=0;i<3;i++){
            Map<String,Object> sUrl = new HashMap<String, Object>();
            sUrl.put("image",url[i]);
            sUrl.put("name","item"+(i+1));
            URL.add(sUrl);
        }
        resources.put("list",URL);

        // SIMULATE iconBar under Swiper (because unconnect database)
        String[] icons = new String[4];
        icons[0] = "http://localhost:8080/img/swiperNav/M_Floss.jpg";
        icons[1] = "http://localhost:8080/img/swiperNav/panda.jpg";
        icons[2] = "http://localhost:8080/img/swiperNav/squirrel.jpg";
        icons[3] = "http://localhost:8080/img/swiperNav/tiger.jpg";
        Map<String, Object> recommend = new HashMap<String, Object>();
        String[] names = new String[4];
        names[0] = "Floss";
        names[1] = "panda";
        names[2] = "squirrel";
        names[3] = "tiger";
        ArrayList<Map<String,Object>> icon = new ArrayList<>();
        for(int i=0;i<4;i++){
            Map<String, Object> mm = new HashMap<String, Object>();
            mm.put("image",icons[i]);
            mm.put("name",names[i]);
            icon.add(mm);
        }


//        mm.put("image","http://localhost:8080/img/swiperNav/panda.jpg");
//        icon.add(mm);
//
//        mm.put("image","http://localhost:8080/img/swiperNav/squirrel.jpg");
//        icon.add(mm);
//
//        mm.put("image","http://localhost:8080/img/swiperNav/tiger.jpg");
//        icon.add(mm);


        recommend.put("list",icon);
        return swiperBean.success().add("resources",resources).add("recommends",recommend);
    };

    @ResponseBody
    @RequestMapping("/resources/tabItem")
    public SwiperBean controltab(@RequestParam("type") String type,
                                 @RequestParam("page") Integer page){
        SwiperBean swiperBean = new SwiperBean();
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1 = new saveImage().input();

        ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        if("herbivore".equals(type)){
            list = (ArrayList<Map<String, Object>>) map1.get("herbivore");
            map.put("data", list.get((page-1)));
            map.put("page",page);
            map.put("mainPage",new saveImage().pageLength(type));
        }else if("carnivore".equals(type)){
            list = (ArrayList<Map<String, Object>>) map1.get("carnivore");
            map.put("data", list.get((page-1)));
            map.put("page",page);
            map.put("mainPage",new saveImage().pageLength(type));
        }else if("poikilotherm".equals(type)){
            list = (ArrayList<Map<String, Object>>) map1.get("poikilotherm");
            map.put("data", list.get((page-1)));
            map.put("page",page);
            map.put("mainPage",new saveImage().pageLength(type));
        }else if("omnivore".equals(type)){
            list = (ArrayList<Map<String, Object>>) map1.get("omnivore");
            map.put("data", list.get((page-1)));
            map.put("page",page);
            map.put("mainPage",new saveImage().pageLength(type));
        }

        return swiperBean.success().add("tab",map);
    }

    @ResponseBody
    @RequestMapping("/resources/animals")
    public SwiperBean aniItem(){
        ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map = new saveImage().input();
//        for(int i=0;i<5;i++){
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("url","http://localhost:8080/img/animalInfo/eastern_puma.jpg");
//            map.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
//            map.put("origin","XXX");
//            map.put("genus","YYY");
//            list.add(map);
//
//            Map<String, Object> map1 = new HashMap<String, Object>();
//            map1.put("url","http://localhost:8080/img/animalInfo/leo.jpg");
//            map1.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
//            map1.put("origin","XXX");
//            map1.put("genus","YYY");
//            list.add(map1);
//
//            Map<String, Object> map2 = new HashMap<String, Object>();
//            map2.put("url","http://localhost:8080/img/animalInfo/mammoth.jpg");
//            map2.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
//            map2.put("origin","XXX");
//            map2.put("genus","YYY");
//            list.add(map2);
//
//            Map<String, Object> map3 = new HashMap<String, Object>();
//            map3.put("url","http://localhost:8080/img/animalInfo/Thylacine.jpg");
//            map3.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
//            map3.put("origin","XXX");
//            map3.put("genus","YYY");
//            list.add(map3);
//        }
        return new SwiperBean().success().add("animals",map);
    }
}
