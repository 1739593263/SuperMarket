package com.shopproe.shopprodata.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class saveImage {
    private String type;
    private String[] carnivore = {"bear.jpg","dinosaur.jpg","eagle.jpg","eagle02.jpg","eastern_puma.jpg","fox.jpg","leo.jpg","leo01.jpg",
                                  "lion.jpg","owl.jpg","shark.jpg","Thylacine.jpg","unknown.jpg","unknown02.jpg","unknown03.jpg","w_tiger.jpg",
                                  "what.jpg",};
    private String[] herbivore = {"chimpanzee.jpg","elephant.jpg","mammoth.jpg","rabbit.jpg","reindeer.jpg"};
    private String[] omnivore = {"b_pig.jpg","bear.jpg","dog.jpg","hippo.jpg","tortoise.jpg"};
    private String[] poikilotherm = {"chameleon.jpg","frog.jpg"};

    public Integer pageLength(String type){
        Integer len = 0;
        if("carnivore".equals(type)){
            len = (carnivore.length%8==0)? carnivore.length/8:carnivore.length/8+1;
        }else if ("herbivore".equals(type)){
            len = (herbivore.length%8==0)? herbivore.length/8:herbivore.length/8+1;
        }else if ("omnivore".equals(type)){
            len = (omnivore.length%8==0)? omnivore.length/8:omnivore.length/8+1;
        }else if ("poikilotherm".equals(type)){
            len = (poikilotherm.length%8==0)? poikilotherm.length/8:poikilotherm.length/8+1;
        }
        return len;
    }


    public Map<String,Object> input(){
        Map<String,Object> mmap = new HashMap<String,Object>();
        type = "carnivore";
        if("carnivore".equals(type)){
            ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            ArrayList<Map<String,Object>> mainlist = new ArrayList<Map<String,Object>>();
            Integer differ = carnivore.length;
            for(int i=0; i<carnivore.length; i++){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("url","http://localhost:8080/img/animalInfo/"+type+"/"+carnivore[i]);
                map.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
                map.put("origin","XXX");
                map.put("genus","YYY");
//                map.put("page",(i/8)+1);
                list.add(map);
                differ = carnivore.length-(i+1);
                if((i+1)%8 == 0){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    list = new ArrayList<Map<String,Object>>();
                }else if(differ<8){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    if(carnivore.length > 8){
                        list = new ArrayList<Map<String,Object>>();
                    }
                }
            }
            mmap.put(type,mainlist);
        };

        type = "herbivore";
        if("herbivore".equals(type)){
            ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            ArrayList<Map<String,Object>> mainlist = new ArrayList<Map<String,Object>>();
            Integer differ = herbivore.length;
            for(int i=0; i<herbivore.length; i++){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("url","http://localhost:8080/img/animalInfo/"+type+"/"+herbivore[i]);
                map.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
                map.put("origin","XXX");
                map.put("genus","YYY");
//                map.put("page",(i/8)+1);
                list.add(map);
                differ = herbivore.length-(i+1);
                if((i+1)%8 == 0){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    list = new ArrayList<Map<String,Object>>();
                }else if(differ<8){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    if(herbivore.length > 8){
                        list = new ArrayList<Map<String,Object>>();
                    }
                }
            }
            mmap.put(type,mainlist);
        }

        type = "omnivore";
        if("omnivore".equals(type)){
            ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            ArrayList<Map<String,Object>> mainlist = new ArrayList<Map<String,Object>>();
            Integer differ = omnivore.length;
            for(int i=0; i<omnivore.length; i++){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("url","http://localhost:8080/img/animalInfo/"+type+"/"+omnivore[i]);
                map.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
                map.put("origin","XXX");
                map.put("genus","YYY");
//                map.put("page",(i/8)+1);
                list.add(map);
                differ = omnivore.length-(i+1);
                if((i+1)%8 == 0){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    list = new ArrayList<Map<String,Object>>();
                }else if(differ<8){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    if(omnivore.length > 8){
                        list = new ArrayList<Map<String,Object>>();
                    }
                }
            }
            mmap.put(type,mainlist);

        }

        type = "poikilotherm";
        if("poikilotherm".equals(type)){
            ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            ArrayList<Map<String,Object>> mainlist = new ArrayList<Map<String,Object>>();
            Integer differ = poikilotherm.length;
            for(int i=0; i<poikilotherm.length; i++){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("url","http://localhost:8080/img/animalInfo/"+type+"/"+poikilotherm[i]);
                map.put("Info","ABCDEFGHIJKLMNOPQRSTUVWSYZXYZNOWYOUSEEICANSEYTHEABC");
                map.put("origin","XXX");
                map.put("genus","YYY");
//                map.put("page",(i/8)+1);
                list.add(map);
                differ = poikilotherm.length-(i+1);
                if((i+1)%8 == 0){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    list = new ArrayList<Map<String,Object>>();
                }else if(differ<8){
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("page",(i/8)+1);
                    map1.put("list",list);
                    mainlist.add(map1);
                    if(poikilotherm.length > 8){
                        list = new ArrayList<Map<String,Object>>();
                    }
                }
            }
            mmap.put(type,mainlist);
        }

        return mmap;
    }
}
