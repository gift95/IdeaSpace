/*
    1、动态的创建省份节点
        省份的数组、创建子节点并添加到select中
    2、获取当前选中的省份下标，作为城市数组的下标
        城市的数组、selectedIndex
    3、将城市节点创建并添加到城市的select标签中
*/
var selNodes = document.getElementsByTagName('select');
var proArr = ["河南省", "河北省"];
var cityArr = [
    ["--请选择城市--"],
    ["郑州市", '新乡市', "南阳市"],
    ["廊坊", '石家庄']
];

//创建省份相关节点
creatEle(proArr, 0);

selNodes[0].onchange = function () {
    //每次添加之前先清除之前的值-节点
    selNodes[1].length = 0;
    //获取当前选择的值对应的下标
    var proIndex = this.selectedIndex;
    //通过省份获取对应的城市数组
    var citys = cityArr[proIndex];
    //将城市数组遍历添加子节点
    creatEle(citys, 1);
};

//创建子节点
function creatEle(arr, index) {
    for (var i = 0; i < arr.length; i++) {
        var optNode = document.createElement("option");
        optNode.innerHTML = arr[i];
        optNode.value = arr[i];
        selNodes[index].appendChild(optNode);
    }
}
