package com.ron.rao.common.pagehelper;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PageHelperFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(PageHelperFilter.class);
    private String excludePathPattern;
    private AntPathMatcher antPathMatcher;

    @Override
    public void destroy() {
    }

    /**
     * 处理pageHelper插件的分页功能
     * ron
     * 2016-06-14
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (!StringUtils.isEmpty(excludePathPattern) && antPathMatcher.match(excludePathPattern, ((HttpServletRequest) request).getServletPath())) {
            chain.doFilter(request, response);
        } else {
//            logger.info("pageHelper filter started");
            try {
                //获取datatable传递的参数，如果有值，则代表前端是datatable插件，需要进行分页操作
                String iDisplayStart = request.getParameter("start");
                Page p = null;
                if (!StringUtils.isEmpty(iDisplayStart)) {
                    p = new Page((HttpServletRequest) request, (HttpServletResponse) response);
                    PageHelper.startPage(p.getPageNo(), p.getPageSize(), p.getOrderBy().replace("order by", ""));
//                    logger.info("datatable参数不为空，执行分页操作");
                } else {
                    p = null;
//                    logger.info("datatable参数为空，不执行分页操作");
                }
                chain.doFilter(request, response);  //让目标资源执行，放行
            } catch (Exception e) {
                logger.info("pageHelper filter 出现异常，错误信息：" + e.getMessage());
                e.printStackTrace();
            } finally {
//                logger.info("pageHelper filter finally方法执行，清空pageHelper的page、orderby对象");
                PageHelper.clearPage();
            }
        }
    }

    @Override
    public void init(FilterConfig config) {
        this.excludePathPattern = config.getInitParameter("excludePathPattern");
        this.antPathMatcher = new AntPathMatcher();
    }

}
