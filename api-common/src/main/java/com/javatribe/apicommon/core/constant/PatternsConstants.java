package com.javatribe.apicommon.core.constant;

/**
 * 正则表达式 常量管理
 * 注意Object 为 null时候，@Pattern 校验不会生效
 * @Author lyr
 * @create 2020/11/5 11:41
 */
public interface PatternsConstants {
    /**
     * url 的 正则表达式
     */
    String urlPattern = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\\\\\\\\\\\\\/])+$";
}
