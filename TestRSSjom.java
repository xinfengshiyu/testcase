package com.alibaba.china.pdp.biz.spu.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Description;
import com.sun.syndication.feed.rss.Item;
import com.sun.syndication.io.WireFeedOutput;
/**
 * 需要引入rome-1.0.jar
 * 类TestRSSjom.java的实现描述：TODO 类实现描述 
 * @author zisheng.nongzs 2014-6-14 下午07:15:34
 */
public class TestRSSjom {

    public static void main(String[] args) {
        DateFormat dateParse = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        Channel channel = new Channel("rss_2.0"); // 该type参数为固定格式
        channel.setTitle("test rome channel title");
        channel.setDescription("channel的描述");
        channel.setLink("http://hi.baidu.com/openj/rss");
        channel.setPubDate(date);
        channel.setEncoding("GBK");
        channel.setLastBuildDate(Calendar.getInstance().getTime());

        List items = new ArrayList();
        Item item = new Item();
        item.setAuthor("zhangwei");
        item.setTitle("item title");

        Description desc = new Description();
        desc.setType("item desc type");
        desc.setValue("item desc value");
        item.setDescription(desc);

        items.add(item);// 添加一个item

        Item item2 = new Item();
        item2.setAuthor("zhangwei");
        item2.setTitle("use rome to read rss");

        Description desc2 = new Description();
        desc2.setValue("you must import rome_1.0.jar & jdom.jar");
        item2.setDescription(desc2);
        Content content = new Content();
        content.setValue("rome是用来发布读取rss的工具，遵循rss标准的XML");
        item2.setContent(content);

        items.add(item2);// 添加一个item

        channel.setItems(items);

        WireFeedOutput out = new WireFeedOutput();
        try {
            // Channel继承与WireFeed
            System.out.println(out.outputString(channel));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
