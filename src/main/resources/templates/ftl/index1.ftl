<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="jquery,ui,easy,easyui,web">
    <meta name="description" content="easyui help you build your web page easily!">
    <title>jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://www.w3cschool.cc/try/jeasyui/jquery.easyui.min.js"></script>
    <script>
        function addTab(title, tableString){
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);
            } else {
                var content = "\\'"+tableString+"\\'";
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }
    </script>
</head>
<div style="margin-bottom:10px">
<body>

    <#if map?exists>
    <#list map?keys as key>
    <a href="#" class="easyui-linkbutton" onclick="addTab(${key},${map[key]})">${key}</a>
    </#list>
    </#if>

</div>
<div id="tt" class="easyui-tabs" style="width:400px;height:250px;">
</body>
</html>