var cls = document.getElementById("time");

function showTime() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth();
    var day = date.getDate();
    var hour = date.getHours();
    var minutes = date.getMinutes();
    var second = date.getSeconds();
    hour = checkTime(hour);
    minutes = checkTime(minutes);
    second = checkTime(second);
    cls.innerHTML = year + "年" + month + "月" + day + "日  " + hour + "时" + minutes + "分" + second + "秒";
    setTimeout(showTime, 1000)
}

function checkTime(time) {
    if (time < 10) {
        return "0" + time;
    }
    return time;
}