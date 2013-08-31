package net.hncu.filter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EncodingFilter implements Filter{
    protected FilterConfig filterConfig;
    private String targetEncoding = "utf-8";
    
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        this.targetEncoding = config.getInitParameter("encoding");
    }
    
    public  void doFilter(ServletRequest srequest, ServletResponse  sresponse, FilterChain chain)
        throws IOException, ServletException {
        //System.out.println("使用以下方法对请求进行编码：encoding="+targetEncoding);
            
        HttpServletRequest request = (HttpServletRequest)srequest;
        HttpServletResponse response = (HttpServletResponse)sresponse;
        request.setCharacterEncoding(targetEncoding);
        response.setContentType("text/html; charset=" + targetEncoding);
        // 把处理权发送到下一个
        chain.doFilter(srequest,sresponse);  
    }   

	public void setFilterConfig(final FilterConfig filterConfig){
		this.filterConfig=filterConfig;
	}
    
    //销毁过滤器
	public void destroy(){
		this.filterConfig=null;
	}
}

