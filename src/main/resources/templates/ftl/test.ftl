<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>在线预览</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/js/excelPreveiw.js"></script>
</head>
<body>
<h1>test excel preview</h1>
  <#if map?exists>
      <#list map?keys as key>
        <a href="#"  onclick="addTab(${key},${map[key]})"> ${key} </a>
        <div id = "parent">
            ${map[key]}
        </div>
      </#list>
  </#if>
<div id = "tt"></div>
<script>
    jQuery.noconflict();
    jQuery(function () {
        alert(jQuery);
    })
    function addTab(key,value) {
        jQuery("#tt").html(value);
    }


</script>
</body>
</html>