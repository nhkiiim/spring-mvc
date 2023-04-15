package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 서블릿 호출 시 service 메서드 호출
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        
        // HttpServletRequest 인터페이스를 WAS 서버가 구현한다 - 여기서는 구현체 RequestFacade
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // Servlet이 http 파싱!
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plian");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
