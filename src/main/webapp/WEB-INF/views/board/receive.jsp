<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
<% 
	//스크립틀릿 영역은 이  jsp 가 서블릿으로 변경될때  ,  
	//service()
	//메서드 영역이다~ 아래의 코드에서 request 변수는 우리가 선언한
	//적이 없음에도 에러가 나지 않고, 사용할수잇는 이유는
	//sun 에서 이미  jsp 에서 필요한 필수적인 객체들의 이름을 미리
	//정해놓았고, 이러한 10개 정도의 객체를 가리켜 jsp내장객체(built-in)
	//라 한다..
	//request, response, session, pageContext, out, 
	//application, config, excetion , page
	//service(request, response)
	//클라이언트가 전송한 파라미터를 이용하여 해당 단을 출력 out.print()
	//HTTP get/post로 전송되는 모든 파라미터는 String 이다!!
	String dan=request.getParameter("dan");
	int n = Integer.parseInt(dan);
	for(int i=1;i<=9;i++){
		out.print(n+"*"+i+"="+(n*i)+"<br>");
	}
%>
</body>
</html>













