var time = null;
var nameArr = [
    "赵", "钱", "孙", "李", "周", "吴", "郑", "王"
];

function startShow() {
    var content = document.getElementById('showName');
    var index = Math.floor(Math.random() * nameArr.length);
    content.innerHTML = nameArr[index];
    time = setTimeout(startShow, 50);
}

function stopShow() {
    clearTimeout(time);
}

function reloadPage() {
    location.reload();
}