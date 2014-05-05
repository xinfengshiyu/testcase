package com.alibaba.china.gene.dal.spu.dao.impl;

import java.io.File;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;

public class TestHtmlClean {

    public void cleanHtml(String htmlurl, String xmlurl) {
        try {
            long start = System.currentTimeMillis();

            HtmlCleaner cleaner = new HtmlCleaner();
            CleanerProperties props = cleaner.getProperties();
            props.setUseCdataForScriptAndStyle(true);
            props.setRecognizeUnicodeChars(true);
            props.setUseEmptyElementTags(true);
            props.setAdvancedXmlEscape(true);
            props.setTranslateSpecialEntities(true);
            props.setBooleanAttributeValues("empty");
            
            TagNode node = cleaner.clean("");

            System.out.println("vreme:" + (System.currentTimeMillis() - start));

            new PrettyXmlSerializer(props).writeXmlToFile(node, xmlurl, "utf-8");

            System.out.println("vreme:" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        HtmlCleaner cleaner = new HtmlCleaner();

        TagNode node = cleaner.clean(new File("D:\\temp\\10-unzip"), "utf-8");
        // ��tagȡ.
        Object[] ns = node.getElementsByName("title", true); // ����

        if (ns.length > 0) {
            System.out.println("title=" + ((TagNode) ns[0]).getText());
        }
        System.out.println("ul/li:");
        // ��xpathȡ
        ns = node.evaluateXPath("/body/div[14]/div[1]/div[2]/h1");
        for (Object on : ns) {
            TagNode n = (TagNode) on;
            //getText,��ȥ����ǩ������Ƕ�׵�html��ǩ
            System.out.println("\ttext=" + n.getText());
            //������ǩ�е�html
            System.out.println("\ttext with html=" + cleaner.getInnerHtml(n));
        }
        System.out.println("a:");
        // ������ֵȡ
        ns = node.getElementsByAttValue("name", "f", true, true);
        for (Object on : ns) {
            TagNode n = (TagNode) on;
            System.out.println("\thref=" + n.getAttributeByName("href") + ", text=" + n.getText());
        }
    }
}
