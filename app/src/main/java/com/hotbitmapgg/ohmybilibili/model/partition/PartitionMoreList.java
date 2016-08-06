package com.hotbitmapgg.ohmybilibili.model.partition;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PartitionMoreList
{

    public int pages;

    public int code;

    public int results;

    public List<PartitionMoreVideoItem> lists;

    private JsonObject list;

    public static PartitionMoreList createFromJson(String json)
    {

        PartitionMoreList result = new Gson().fromJson(json, PartitionMoreList.class);
        Iterator<Map.Entry<String,JsonElement>> iterator = result.list.entrySet().iterator();
        if (result.lists == null)
        {
            result.lists = new ArrayList<>();
        }
        while (iterator.hasNext())
        {
            Map.Entry<String,JsonElement> element = iterator.next();
            try
            {
                result.lists.add(new Gson().fromJson(element.getValue(), PartitionMoreVideoItem.class));
            } catch (Exception e)
            {

            }
        }

        result.list = null;

        return result;
    }
}
