package servlet30project;

import java.io.IOException;

import javax.jws.soap.InitParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//servlet3.0��ʽ�޷�ͨ��ע�����web���������ã�ֻ�����õ�ǰservlet������web������Ҫ��web.xml������
//�൱��2.5�е�urlpattern���������������ó�ʼ��ʱ������ֻ��urlpatternʱ����ʡ��value=,�����������ǩ����ʡ��
@WebServlet(value="/welcomeServlet", loadOnStartup=1,initParams= {@WebInitParam(name="servletparaname30",value="servlet30")})
public class welcomeServlet extends HttpServlet {
	public void init() {
		System.out.println("��ʼ������");
		String value = super.getInitParameter("servletparaname30");
		System.out.println(value);
		//��servlet2.5��ͨ�� web.xml��<load-on-startup>1<load-on-startup>���ó�ʼ����ʱ��Ϊ
		//����tomcat����ʱ�����Ҳ�ͬ��servlet������ʱ����ͨ���˱�ǩ����servlet�ļ���˳��
	}
	public void destroy() {
		System.out.println("����");//��ϵͳ����servletʱ����ִ��
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("service�ľ���ʵ�� doget dopost");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
