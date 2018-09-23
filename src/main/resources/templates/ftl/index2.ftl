<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add autoplay to tabs - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/demo/demo.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
    <script>
        $(function(){
            var index = 0;
            var t = $('#tt');
            var tabs = t.tabs('tabs');
            setInterval(function(){
                t.tabs('select', tabs[index].panel('options').title);
                index++;
                if (index >= tabs.length){
                    index = 0;
                }
            }, 300000);
        });
    </script>
</head>
<body>
    <div id="tt" class="easyui-tabs" style="width: 100%;height: 100%;">
        <#if map?exists>
          <#list map?keys as key>
        <div title="${key}">
            <div>${map[key]}</div>
        </div>
         </#list>
       </#if>
    </div>
</body>
</html>