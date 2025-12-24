package cn.icexmoon.learnspringsecurity.demo.filter;

import cn.icexmoon.learnspringsecurity.demo.exception.AccessDeniedException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @ClassName TenantFilter
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2025/12/23 下午4:39
 * @Version 1.0
 */
public class TenantFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String tenantId = request.getHeader("X-Tenant-Id");
        boolean hasAccess = isUserAllowed(tenantId);
        if (hasAccess) {
            filterChain.doFilter(request, response);
            return;
        }
        throw new AccessDeniedException("Access denied");
    }

    private boolean isUserAllowed(String tenantId) {
        // 模拟检查用户是否允许访问租户
        return tenantId != null && !tenantId.isEmpty();
    }
}
