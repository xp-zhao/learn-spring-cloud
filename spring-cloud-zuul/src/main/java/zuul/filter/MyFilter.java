package zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @description: 过滤器测试
 * @author: zhaoxiaoping
 * @create: 2019/06/24
 **/
@Component
public class MyFilter extends ZuulFilter {

  /**
   * 返回一个字符串代表过滤器类型（pre：路由之前、routing: 路由之时、post: 路由之后、error: 发送错误调用）
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /**
   * 过滤的顺序
   */
  @Override
  public int filterOrder() {
    return 0;
  }

  /**
   * 判断逻辑，是否要过滤
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * 过滤器的具体逻辑
   */
  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    Object accessToken = request.getParameter("token");
    if (accessToken == null) {
      System.out.println("token is empty");
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      try {
        ctx.getResponse().getWriter().write("token is empty");
      } catch (IOException e) {
      }
      return null;
    }
    System.out.println("ok");
    return null;
  }
}