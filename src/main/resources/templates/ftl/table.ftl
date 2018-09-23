<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>在线预览</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/js/excelPreveiw.js"></script>
    <link href="/css/excelPreview.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<h1>test excel preview</h1>

<script type=text/javascript> src = "/js/H-ui.js"</script>
<div id="tab_demo" class="HuiTab">
    <#if map?exists>
        <#list map?keys as key>
        <span>${key}</span>
        <div class="tabBar clearfix">
            <div class="tabCon">${map[key]}</div>
        </#list>
    </#if>
</div>
</div>

</body>
</html>