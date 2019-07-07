package servlet30project;

import java.io.IOException;

import javax.jws.soap.InitParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//servlet3.0方式无法通过注解进行web容器的配置，只能配置当前servlet，配置web容器需要在web.xml中配置
//相当于2.5中的urlpattern，可以在这里设置初始化时机，当只有urlpattern时可以省略value=,如果有其他标签不能省略
//123
@WebServlet(value="/welcomeServlet", loadOnStartup=1,initParams= {@WebInitParam(name="servletparaname30",value="servlet30")})
public class welcomeServlet extends HttpServlet {
	public void init() {
		System.out.println("初始化测试");
		String value = super.getInitParameter("servletparaname30");
		System.out.println(value);
		//在servlet2.5中通过 web.xml中<load-on-startup>1<load-on-startup>设置初始化的时机为
		//启动tomcat服务时，并且不同的servlet在启动时可以通过此标签设置servlet的加载顺序
	}
	public void destroy() {
		System.out.println("销毁");//在系统回收servlet时立即执行
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("service的具体实现 doget dopost");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
