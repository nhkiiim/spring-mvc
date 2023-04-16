package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override // protected로 만들기
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // start line 정보 불러오기
        printStartLine(request);

        // Header 모든 정보
        printHeaders(request);

        //Header 편리한 조회
        printHeaderUtils(request);

        // 기타 정보
        printEtc(request);

    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");

        // GET
        System.out.println("request.getMethod() = " + request.getMethod());

        // HTTP/1.1
        System.out.println("request.getProtocol() = " + request.getProtocol());

        // http
        System.out.println("request.getScheme() = " + request.getScheme());

        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());

        // /request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());

        // username=hi
        System.out.println("request.getQueryString() = " + request.getQueryString());

        // https 사용 유무
        System.out.println("request.isSecure() = " + request.isSecure());

        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");

        // 헤더 정보 가져오기 방법 1 - 옛날 방법
        /*
            Enumeration<String> headerNames = request.getHeaderNames(); // 모든 헤더 정보 꺼내기
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println(headerName + ": " + headerName);
            }
        */

        // 헤더 정보 가져오기 방법 2 - 요즘 스타일 ~ ^0^
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + headerName));

        request.getHeader("host"); // 원하는 값 가져오기

        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    //Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");

        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +request.getServerName()); // localhost
        System.out.println("request.getServerPort() = " + request.getServerPort()); // 8080
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale()); // 가장 높은 우선순위 locale
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType()); // body에 담겨있을 때
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

    private void printEtc(HttpServletRequest request) {
        // HTTP 메세지의 정보 X, 내부 네트워크 커넥션이 가지는 정보
        System.out.println("--- 기타 조회 start ---");

        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println();

        System.out.println("[Local 정보]"); // 내 서버 정보
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
