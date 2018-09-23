//Jquery 实现
jQuery.Huitab = function (tabBar, tabCon, class_name, tabEvent, i) {
    var $tab_menu = $(tabBar);
    // 初始化操作
    $tab_menu.removeClass(class_name);
    $(tabBar).eq(i).addClass(class_name);
    $(tabCon).hide();
    $(tabCon).eq(i).show();

    $tab_menu.bind(tabEvent, function () {
        $tab_menu.removeClass(class_name);
        $(this).addClass(class_name);
        var index = $tab_menu.index(this);
        $(tabCon).hide();
        $(tabCon).eq(index).show()
    })
}

$(function () {
    $.Huitab("#tab_demo .tabBar span", "#tab_demo .tabCon", "mousemove", "click", "0");
});




/*<div id="tab_demo" class="HuiTab" th:each="lm:${list}">

    <div class="tabBar clearfix" >
    <span th:each = "entry: ${lm}" th:utext = "${entry.key}"></span>
    </div>
    <div class="tabCon" th:each = "entry: ${lm}" th:utext = "${entry.value}"></div>
    </div>

    <div id ="tab-parent" calss =" parent" th:each="lm:${list}">
    <div class = "tabBar" >
    <span th:each = "entry: ${lm}" th:utext = "${entry.key}"></span>
    </div>
    <div class="tabCon" th:each = "entry: ${lm}" th:utext = "${entry.value}"></div>

    </div>*/



