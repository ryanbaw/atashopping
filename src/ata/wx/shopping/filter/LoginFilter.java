package ata.wx.shopping.filter;


import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;

public class LoginFilter implements Filter
{
	public void init(FilterConfig filterConfig)
          throws ServletException
	{
		
	}
	public void doFilter(ServletRequest request,
                     ServletResponse response,
                     FilterChain chain)
              throws IOException,
                     ServletException
	{
		// Session属于HTTP范畴，所以ServletRequest对象需要先转换成HttpServletRequest对象
		HttpServletRequest req = (HttpServletRequest)request ;
		HttpSession session = req.getSession() ;
		// 如果session不为空，则可以浏览其他页面
		if(session.getAttribute("admin")!=null)
		{
			chain.doFilter(request,response) ;
		}
		else
		{
			// 通过requestDispatcher跳转到登陆页
			request.getRequestDispatcher("/administrator.jsp").forward(request,response) ;
		}
	}
	public void destroy()
	{
		
	}
}
