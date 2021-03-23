package com.javatribe.apicompetition.util;

import org.commonmark.Extension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.web.util.HtmlUtils;

import java.util.Collections;
import java.util.Set;

/**
 * markdown 转 HTML
 *
 * @Author lyr
 * @create 2020/8/24 8:39
 */
public class MarkdownUtils {
    // private final static Pattern PATTERN = Pattern.compile("<code.*?>(.*)</code>");
    // CharSequence charSequence;
    // public static final CharMatcher LATEX = CharMatcher.anyOf("\\\\leq");

    /**
     * markdown格式转换成HTML格式
     * @param markdown
     * @return
     */
    public static String markdownToHtml(String markdown) {
        if (markdown==null) {
            markdown = "";
        }
        // markdown = LATEX.replaceFrom("\\\\leq","<=");
        //处理 pre 标签的代码
        String res =  markdownToHtmlExtensions(markdown);
        // Matcher matcher = PATTERN.matcher(res);
        // while (matcher.find()) {
        //     String code = matcher.group();
        //     res = res.replaceFirst(code,HtmlUtils.htmlUnescape(code));
        // }
        return res;
        // if (markdown==null) {
        //     markdown = "";
        // }
        // markdown = HtmlUtils.htmlUnescape(markdown);
        // // markdown = markdown.replace("&quot;","\"");
        // Parser parser = Parser.builder().build();
        // Node document = parser.parse(markdown);
        // HtmlRenderer renderer = HtmlRenderer.builder().build();
        // return renderer.render(document);
    }

    /**
     * 增加扩展[标题锚点，表格生成]
     * Markdown转换成HTML
     * @param markdown
     * @return
     */
    public static String markdownToHtmlExtensions(String markdown) {
        //h标题生成id
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        //转换table的HTML
        // List<Extension> tableExtension = Arrays.asList(TablesExtension.create(), InsExtension.create(), StrikethroughExtension.create());
        Parser parser = Parser.builder()
                // .extensions(tableExtension)
                .build();
        Node document = parser.parse(markdown);
        //图片懒加载
        HtmlRenderer renderer = HtmlRenderer.builder()
                // .nodeRendererFactory(ImageNodeRenderer::new)
                .extensions(headingAnchorExtensions)
                // .extensions(tableExtension)
                // .attributeProviderFactory(context -> new CustomAttributeProvider())
                .build();
        return renderer.render(document);
    }

    // /**
    //  * uniapp 客户端的处理
    //  * @param content
    //  * @return
    //  */
    // public static String markdownToAppContent(String content) {
    //     if (content==null) return "";
    //     content = HtmlUtils.htmlUnescape(content);
    //     //h标题生成id
    //     Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
    //     //转换table的HTML
    //     // List<Extension> tableExtension = Arrays.asList(TablesExtension.create(), InsExtension.create(), StrikethroughExtension.create());
    //     Parser parser = Parser.builder()
    //             // .extensions(tableExtension)
    //             .build();
    //     Node document = parser.parse(content);
    //     //图片懒加载
    //     HtmlRenderer renderer = HtmlRenderer.builder()
    //             // .nodeRendererFactory(ImageNodeRenderer::new)
    //             .extensions(headingAnchorExtensions)
    //             // .extensions(tableExtension)
    //             .attributeProviderFactory(context -> new CustomAttributeProvider())
    //             .attributeProviderFactory(context -> new CustomAppAttrProvider())
    //             .build();
    //     return renderer.render(document);
    //     // return "";
    // }


    // static class ImageNodeRenderer implements NodeRenderer {
    //
    //     private final HtmlWriter html;
    //
    //     ImageNodeRenderer(HtmlNodeRendererContext context) {
    //         this.html = context.getWriter();
    //     }
    //
    //     @Override
    //     public Set<Class<? extends Node>> getNodeTypes() {
    //         // Return the node types we want to use this renderer for.
    //         return Collections.<Class<? extends Node>>singleton(Image.class);
    //     }
    //
    //     @Override
    //     public void render(Node node) {
    //         //https://github.com/commonmark/commonmark-java
    //         // We only handle one type as per getNodeTypes, so we can just cast it here.
    //         // IndentedCodeBlock codeBlock = (IndentedCodeBlock) node;
    //         Image image = (Image)node;
    //         // System.out.println("------------------");
    //         Map<String, String> data = Maps.newHashMap();
    //         data.put("data-original",image.getDestination()+"?x-oss-process=image/resize,m_fixed,w_774");
    //         html.tag("img",data);
    //         // html.line();
    //         // html.tag("pre");
    //         // html.text(image.getDestination());
    //         // html.tag("/pre");
    //         // html.line();
    //     }
    // }
    // static class CustomTextProvider implements Provider
    // /**
    //  * 处理标签的属性
    //  */
    // static class CustomAppAttrProvider implements AttributeProvider {
    //
    //
    //     @Override
    //     public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
    //         if (node instanceof  Image) {
    //             //图片最大宽度
    //             attributes.put("style","max-width:381px");
    //         }
    //     }
    // }
    // static class CustomAttributeProvider implements AttributeProvider {
    //     @Override
    //     public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
    //         //改变a标签的target属性为_blank
    //         if (node instanceof Link) {
    //             attributes.put("target", "_blank");
    //         }
    //         else if (node instanceof TableBlock) {
    //             attributes.put("class", "table  table-bordered");
    //         }
    //         /*else if (node instanceof Image) {
    //             Image image = (Image)node;
    //             attributes.put("data-original", image.getDestination());
    //             // image.setDestination("");
    //         }*/
    //         // else if (node instanceof Heading) {
    //         //     //header 元素
    //         //     attributes.put("id", IdUtil.fastUUID());
    //         // }
    //         // else if (node instanceof FencedCodeBlock) {
    //         //     //pre 标签
    //         //     FencedCodeBlock block = ((FencedCodeBlock)node);
    //         //     String content = block.getLiteral();
    //         //     //将 pre 标签的 东西去掉
    //         //     String raw = HtmlUtils.htmlUnescape(content);
    //         //     // System.out.println(raw);
    //         //     block.setLiteral(raw);
    //         //
    //         // }
    //         // if (tagName!=null && "pre".equals(tagName.trim())) {
    //         //     node.
    //         // }
    //
    //     }
    // }


    public static void main(String[] args) {
        String table = "| hello | hi   | 哈哈哈   |\n" +
                "| ----- | ---- | ----- |\n" +
                "| 斯维尔多  | 士大夫  | f啊    |\n" +
                "| 阿什顿发  | 非固定杆 | 撒阿什顿发 |\n" +
                "\n";
        String a = "![imCoding 爱编程](http://www.lirenmi.cn)";
        String latex = "对于 100%100\\\\%100% 的数据，1≤n≤1031 \\\\leq n \\\\leq 10^31≤n≤103，1≤m≤1051 \\\\leq m \\\\leq 10^51≤m≤105，1≤u,v≤n1\\\\leq u,v \\\\leq n1≤u,v≤n，1≤w≤1041 \\\\leq w \\\\leq 10^41≤w≤104，输入保证任意两点都能互相到达。";
        // System.out.println(markdownToHtmlExtensions(a));
        // System.out.println(markdownToHtmlExtensions(table));
        String code =  " ## helloworld" +
                "\r\n" +
                "" +
                "\r\n" +
                "" +
                "" +
                "<script>alert('xss');</script> \r\n" +
                "```java" +
                "\r\n" +
                "hello world aaa &quot;  \"" +
                "\r\n" +
                "![avatar](/home/picture/1.png)" +
                "\r\n" +
                "\r\n" +
                "```";
        // System.out.println(HtmlUtils.htmlUnescape(code));
        // System.out.println(markdownToHtmlExtensions(code));
        // CharMatcher.anyOf("\\\\leq")
        System.out.println(markdownToHtml(latex));
        // CharMatcher.inRange('a','z').or(CharMatcher.inRange('A','Z'));
    }
}
