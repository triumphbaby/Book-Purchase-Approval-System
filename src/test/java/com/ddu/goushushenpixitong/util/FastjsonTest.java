package com.ddu.goushushenpixitong.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class FastjsonTest extends BaseTest {

    @Test
    public void test01() {
        String jsonStr01 = "{\"id\":1,\"opinion\":\"yes\"}";
        String jsonStr02 = "[{\"id\":6,\"opinion\":\"yes\"},{\"id\":5,\"opinion\":\"yes\"},{\"id\":4,\"opinion\":\"yes\"}]";

        JSONObject jo = JSON.parseObject(jsonStr01);//JSONObject本身就是map
        System.out.println(jo);
        System.out.println(jo.getInteger("id"));
        System.out.println(jo.getString("opinion"));

        JSONArray ja = JSON.parseArray(jsonStr02);//JSONArray本身就是list
        System.out.println(ja.getJSONObject(0));
//        System.out.println(ja.get(0));
        System.out.println(ja.get(1));
    }

    @Test
    public void test02() {
        String jsonStr01 = "[{\"id\":6,\"opinion\":\"yes\"},{\"id\":5,\"opinion\":\"yes\"},{\"id\":4,\"opinion\":\"yes\"}]";
        JSONArray ja = JSON.parseArray(jsonStr01);
        JSONObject jo = ja.getJSONObject(0);
        System.out.println(jo.get("id"));
    }

    @Test
    public void test03() {
        String jsonStr01 = "[{\"id\":6,\"opinion\":\"yes\"},{\"id\":5,\"opinion\":\"yes\"},{\"id\":4,\"opinion\":\"yes\"}]";
        JSONObject data[] = FastjsonUtil.jsonStr2Array(jsonStr01);
        for (JSONObject jo :
                data) {
            System.out.println(jo);
            System.out.println(jo.get("id"));
            System.out.println(jo.get("opinion"));
        }
    }

}
