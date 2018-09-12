// JavaScript Document
function updatePrice(){
	var total=0.0;
	var checkboxs= document.getElementsByName("checkbox1");
	for (var i = 0; i < checkboxs.length; i++){
		var unitPrice=Number(checkboxs[i].parentNode.nextElementSibling.nextElementSibling.innerHTML);
		var count=Number(checkboxs[i].parentNode.nextElementSibling.nextElementSibling.nextElementSibling.children[1].value);
		//修改当前商品的购买总价
		checkboxs[i].parentNode.parentNode.lastElementChild.innerHTML=unitPrice*count;	
		//更新总价
		total+=unitPrice*count;
	}
	document.getElementById("total").innerHTML=total;	
}

//判断是否为非负整数
function isInteger( valueString ){
	var reg=/^(0|[1-9]\d*)$/;   // 正则表达式，限制了032
	if(valueString=='0' || reg.test(valueString)==true)    
		return true;
	else
		return false;			
}
//将购买数量加1或减1
function changeOne(id,n){
	var goodsObj=document.getElementById(id);
	//如果是整数
	if(isInteger( goodsObj.value )){
		var nowNumber=parseInt(goodsObj.value);
		if(parseInt(n)<0 && nowNumber<=0)//小于等于0，且做减法，不允许
			alert("不能小于0");
		else{
			nowNumber+=n;
			goodsObj.value=nowNumber;
			updatePrice();
		}				
	}else
		alert("必须是数字");
}
//在获得焦点时，保存旧的值到标签的自定义属性oldValue中
function remember(goodsObj){
	//火狐和谷歌浏览器里，我们可以通过getAttribute方法来访问自定义属性
	goodsObj.setAttribute("oldValue",goodsObj.value);
}
//检查是否为非负整数，如果不是，将文本框的值恢复为原来的值
function check(goodsObj){
	if(isInteger(goodsObj.value)){
		updatePrice();
	}else{
		alert("必须是非负整数");
		//恢复原来的值
		goodsObj.value=goodsObj.getAttribute("oldValue");	
		goodsObj.focus()//获得焦点			
	}
}	
//全选（全不选）复选框
function checkAll(obj){
	var checkboxs= document.getElementsByName("checkbox1");
	for (var i = 0; i < checkboxs.length; i++) 
		checkboxs[i].checked =obj.checked;	  
}

//删除选中的复选框
function deleteCheck(){	
	var checkboxs= document.getElementsByName("checkbox1");
	//删除选中的复选框
	for (var i = 0; i < checkboxs.length; i++) {
		if(checkboxs[i].checked){//判断复选框是否选中，为真，表示选中			
			var table=checkboxs[i].parentNode.parentNode.parentNode;
			var row=checkboxs[i].parentNode.parentNode;
			table.removeChild(row);//删除tr一行
		}
	}
	//更新价格
	updatePrice();	
}