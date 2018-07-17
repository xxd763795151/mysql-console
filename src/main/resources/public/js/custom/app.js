function addMysqlConnectioinInfo() {

    var name = $("#db_source_add_info_name").val();
    var mysql_ip = $("#db_source_add_info_mysql_ip").val();
    var mysql_port = $("#db_source_add_info_mysql_port").val();
    var mysql_pass = $("#db_source_add_info_mysql_pass").val();
    var name = $("#db_source_add_info_name").innerText;
    var save_info = $("#db_source_add_model .checkbox input[type=checkbox]:checked");

    if (!isIp(mysql_ip) || !isNum(mysql_port)) return;
    if (isEmptyStr(name)) {
        name = mysql_ip + "_" + mysql_port;
    }
    var data = {"name": name, "ip": mysql_ip, "port": mysql_port, "pass": mysql_pass, "saveInfo": save_info.length};
    //alert(JSON.stringify(data));
    $.ajax({
        url: "/dbsource/save/info",
        type: "post",
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        data: data,
        success: function (response) {
            alert("添加成功");
            $("#db_source_add_model").modal('toggle');
        },
        error: function (response) {
            alert("error:" + response.responseText);
        }
    })
}

/**
 * 给表单元素增加不同效果
 * @param e
 * @param reg
 * @param v
 */
function addClassIfTestTrue(e, condition) {
    if (!condition) {
        if (e.hasClass("has-success")) {
            e.removeClass("has-success");
        }
        if (!e.hasClass("has-error")) {
            e.addClass("has-error");
        }
        return false;
    } else {
        if (e.hasClass("has-error")) {
            e.removeClass("has-error");
        }
        if (!e.hasClass("has-success")) {
            e.addClass("has-success");
        }
        return true;
    }
}

function isIp(ip) {
    var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
    return reg.test(ip);
}

function isNum(num) {
    var reg = /^[1-9][0-9]*$/;
    return reg.test(num);
}

/**
 * 校验IP
 * @param e
 */
function validateIp(e) {
    var grandfather = $(e).parent().parent();
    addClassIfTestTrue(grandfather, isIp(e.value));
}

/**
 * 是否是数字
 * @param e
 */
function validatePort(e) {
    var grandfather = $(e).parent().parent();
    addClassIfTestTrue(grandfather, isNum(e.value));
}

function isEmptyStr(str) {
    var reg = /^[ ]*$/;
    return str == undefined || str == null || str == "" || ret.test(str);
}

function nullShowError(e) {
    var v = e.value;
    var grandfather = $(e).parent().parent();
    if (v == null || v == "") {
        grandfather.addClass("has-error");
    } else {
        if (grandfather.hasClass("has-error")) {
            grandfather.removeClass("has-error");
            grandfather.addClass("has-success");
        }
    }
}