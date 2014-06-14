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
 * ��Ҫ����rome-1.0.jar
 * ��TestRSSjom.java��ʵ��������TODO ��ʵ������ 
 * @author zisheng.nongzs 2014-6-14 ����07:15:34
 */
public class TestRSSjom {

    public static void main(String[] args) {
        DateFormat dateParse = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        Channel channel = new Channel("rss_2.0"); // ��type����Ϊ�̶���ʽ
        channel.setTitle("test rome channel title");
        channel.setDescription("channel������");
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

        items.add(item);// ���һ��item

        Item item2 = new Item();
        item2.setAuthor("zhangwei");
        item2.setTitle("use rome to read rss");

        Description desc2 = new Description();
        desc2.setValue("you must import rome_1.0.jar & jdom.jar");
        item2.setDescription(desc2);
        Content content = new Content();
        content.setValue("rome������������ȡrss�Ĺ��ߣ���ѭrss��׼��XML");
        item2.setContent(content);

        items.add(item2);// ���һ��item

        channel.setItems(items);

        WireFeedOutput out = new WireFeedOutput();
        try {
            // Channel�̳���WireFeed
            System.out.println(out.outputString(channel));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
