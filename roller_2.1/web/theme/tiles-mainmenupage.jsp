<% response.setContentType("text/html; charset=UTF-8"); %><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/taglibs.jsp" %><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%= RollerRuntimeConfig.getProperty("site.shortName") %>: <c:out value="${model.title}" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<tiles:insert attribute="head" />     
<style type="text/css">
<tiles:insert attribute="styles" />
</style>
</head>
<body>

<div id="banner">
    <tiles:insert attribute="bannerStatus" />
</div>

<div id="content">
    <div id="leftcontent_wrap">
        <div id="leftcontent"> 
        </div>
    </div>
    
    <div id="centercontent_wrap">
        <div id="centercontent">   
            <h1><c:out value="${model.title}" /></h1>
            <tiles:insert attribute="messages" /> 
            <tiles:insert attribute="content" />    
        </div>
    </div>
    
    <div id="rightcontent_wrap">
        <div id="rightcontent"> 
            <tiles:insert attribute="sidebar" />
        </div>
    </div>
</div>

<div id="footer">
    <tiles:insert attribute="footer" />
</div>

<div id="datetagdiv" 
   style="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;">
</div>
</body>
</html>
