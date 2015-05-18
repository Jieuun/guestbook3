<%@ page import="com.sds.icto.guestbook3.dao.*" %>
<%@ page import="com.sds.icto.guestbook3.vo.*" %>
<%
	// 한글처리
request.setCharacterEncoding( "utf-8" );

// 메세지 등록
String name = request.getParameter( "name" );
String password = request.getParameter( "pass" );
String message = request.getParameter( "content" );

GuestBookVo vo = new GuestBookVo();
vo.setName( name );
vo.setPassword(password);
vo.setMessage(message);

GuestBookDao dao = new GuestBookDao();
dao.add(vo);

//리다이렉트
response.sendRedirect( "/guestbook" );
%>