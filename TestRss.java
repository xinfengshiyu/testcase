package com.alibaba.china.pdp.biz.spu.service;

import java.util.Calendar;

import com.rsslibj.elements.Channel;
import com.rsslibj.elements.Item;
import com.rsslibj.writers.RSSWriter;
import com.rsslibj.writers.RSSWriterFactory;

public class TestRss {
    
    public static void main(String[] args) {
        Channel channel=new Channel(); 
        channel.setTitle("title");
        channel.setLink("link");
        channel.setLanguage("zh-cn");
        channel.
        channel.setDcDate(Calendar.getInstance().getTime());
        Item item = new Item();
        item.setTitle("title");
        item.setCopyright("alibaba copyright!");
        item.setDescription("description");
        channel.addItem(item);
        channel.addCategory("category1");
        
        try {
            System.out.println("xml:"+channel.getFeed("rss"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        Channel channel=new Channel();
//        channel.setDescription("This is my sample channel.");
//        channel.setLink("http://localhost/");
//        channel.setTitle("My Channel");
//        channel.setImage("http://localhost/",
//                "The Channel Image",
//                "http://localhost/foo.jpg");
//        channel.setTextInput("http://localhost/search",
//                "Search The Channel Image",
//                "The Channel Image",
//                "s");
//        channel.addItem("http://localhost/item1",
//                "The First Item covers details on the first item>",
//                "The First Item")
//                .setDcContributor("Joseph B. Ottinger");
//        channel.addItem("http://localhost/item2",
//                "The Second Item covers details on the second item",
//                "The Second Item")
//                .setDcCreator("Jason Bell");
//        try {
//            System.out.println("The feed in RDF: "+channel.getFeed("test"));
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}
