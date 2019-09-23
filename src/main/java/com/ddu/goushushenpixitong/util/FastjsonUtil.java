package com.ddu.goushushenpixitong.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;

public class FastjsonUtil {
    /**
     * json字符串转成数组
     *
     * @param jsonStr json字符串
     * @return
     */
    public static JSONObject[] jsonStr2Array(String jsonStr) {
        JSONArray ja = JSON.parseArray(jsonStr);
        Iterator iterator = ja.iterator();
        int num = 0;

        while (iterator.hasNext()) {//动态获取数组实际长度
            num++;
            iterator.next();
        }

        JSONObject data[] = new JSONObject[num];
        iterator = ja.iterator();
        num = 0;
        while (iterator.hasNext()) {
            data[num++] = (JSONObject) iterator.next();
        }

        return data;
    }

}
