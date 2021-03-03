<head>
<jsp:directive.include
	file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<title>注册结果</title>
</head>
<body>
	<div class="container">
		<%
			boolean result = Boolean.valueOf(request.getParameter("result"));
			if (result) {
		%>
		注册成功,
		<%
			String name = request.getParameter("name");
		%>
		您的昵称为: <%=name %>
		<%
			} else {
		%>
		注册失败
		<%
			}
		 %>
	</div>
</body>