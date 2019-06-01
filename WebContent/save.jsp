<%@page pageEncoding="utf-8"%>
<jsp:useBean id="user" class="com.xiudun.domain.User" scope="request"/>
<jsp:setProperty property="*" name="user"/>
<jsp:forward page="/save.do"></jsp:forward>
