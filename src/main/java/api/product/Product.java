package api.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/product")
@MultipartConfig  // 파일도 포함해서 보낸다
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, String> map = new HashMap<>();
	public Product() {
		map.put("강호동", "JSP");
		map.put("유재석", "SPRING");
		map.put("신동엽", "JAVA");
		map.put("서장훈", "NODE");
		map.put("아이유", "JQUERY");
	}
	
	// 회원조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// http://localhost:8080/product?name=신동엽
		String name = request.getParameter("name");
		
//		String name     = "강호동";
		String language = map.get(name);
		
		// 출력부분
//		response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String json  = """
				{
					"name" : "%s",
					"language" : "%s"
				}
				""".formatted(name, language);
		
//		String json = String.format(name, language);
		
		out.print(json);
		out.flush();
		out.close();
		
		System.out.println(map);
	}

	// 회원 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String name     = request.getParameter("name");
		String language = request.getParameter("language");
		
		map.put(name, language);
		
		System.out.println(name + "이 추가됨");
		
		doGet(request, response);
	}

}
