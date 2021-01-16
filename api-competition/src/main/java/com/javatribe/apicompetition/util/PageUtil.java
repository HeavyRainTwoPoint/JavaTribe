package com.javatribe.apicompetition.util;

import com.javatribe.apicommon.dto.PageParam;
import com.javatribe.apicommon.util.WebUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lyr
 * @create 2021/1/17 1:24
 */
public class PageUtil {
    /**
     * 获取前端分页参数
     * @return
     */
    public static PageParam getParam() {
        HttpServletRequest request = WebUtil.getRequest();
        String pageStr =  request.getParameter("page");
        String sizeStr =  request.getParameter("size");
        int page = 10,size = 5;
        if (pageStr!=null) page = Integer.parseInt(pageStr);
        if (sizeStr!=null) size = Integer.parseInt(sizeStr);
        return PageParam.of(page,size);

    }
}
