<%@page import="com.dj.app.controller.common.Pager"%>
<%@page import="com.dj.app.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
	List<Board> boardList =(List)request.getAttribute("boardList");
	Pager pager=(Pager)request.getAttribute("pager");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button{
	background:yellow;
	color:red;
}
a{text-decoration:none}/*링크 밑줄 없애기*/
table{
	position:relative;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("button").click(function(){
		location.href="/board/registForm";
	});
});
</script>
</head>
<body>
	<table width="100%" border="1px">
		<tr>
			<td width="5%">No</td>
			<td width="65%">제목</td>
			<td width="10%">작성자</td>
			<td width="10%">등록일</td>
			<td width="10%">조회수</td>
		</tr>
		<%int total=boardList.size(); %>
		<%int curPos=pager.getCurPos(); %>
		<%int num=pager.getNum(); %>
		<%for(int i=0;i<pager.getPageSize();i++){ %>
		<%if(num<1)break; %>
		<%Board board=boardList.get(i); %>
		<tr onMouseOver="this.style.background='cyan'" onMouseOut="this.style.background=''">
			<td><%=num-- %></td>
			<td><a href="/board/detail?board_id=<%=board.getBoard_id()%>"><%=board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate().substring(0,10) %></td>
			<td><%=board.getHit() %></td>
		</tr>
		<%}%>
		<tr>
			<td colspan="5">
				<button>등록</button>
			</td>
		</tr>
	</table>
</body>
</html>















