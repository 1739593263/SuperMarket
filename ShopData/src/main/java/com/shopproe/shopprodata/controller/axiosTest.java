package com.shopproe.shopprodata.controller;

import com.shopproe.shopprodata.bean.SwiperBean;
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
    }
}
