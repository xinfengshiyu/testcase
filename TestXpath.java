package com.alibaba.china.gene.dal.spu.dao.impl;

import java.io.File;
import java.net.URL;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class TestXpath {

    public static void main(String[] args) throws Exception {
        try {
            HtmlCleaner cleaner = new HtmlCleaner();
            URL url = new URL("http://info.1688.com/detail/1159029670.html");
            //����url���ʺ�ֱ�Ӵ���
//            TagNode node = cleaner.clean(url, "gbk");
            //�����ļ������д���
            TagNode node = cleaner.clean(new File("D:\\temp\\27-unzip"), "utf-8");
            Object[] tagNodes = node.evaluateXPath("/body/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/table/tbody");
            for (Object tagNode : tagNodes) {
                System.out.println(((TagNode) tagNode).getText());
                System.out.println(((TagNode) tagNode).getAttributeByName("href"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
