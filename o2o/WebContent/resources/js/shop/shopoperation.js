/**
 * 店铺操作JS
 * ctyFL
 * 2021-02-12
 */

var initUrl = "/o2o/shopadmin/getshopinitinfo";
var registerShopUrl = "/o2o/shopadmin/registershop";

//(function(){})：DOM加载完成之后执行一系列预先定义好的函数。
$(function(){
	initShopCategoryAndArea();
	initSubmitEven();
})

//后台获取商铺类型、区域的下拉选数据
function initShopCategoryAndArea(){
	$.getJSON(initUrl, function(data){
		if(data.success){
			var tempShopCategoryHtml = "";
			var tempAreaHtml = "";
			//遍历后台返回的商铺类型列表
			data.shopCategoryList.map(function(item, index){
				tempShopCategoryHtml += "<option data-id='"+item.id+"'>" + item.name + "</option>";
			});
			//遍历后台返回的区域列表
			data.areaList.map(function(item, index){
				tempAreaHtml += "<option data-id='"+item.id+"'>" + item.name + "</option>";
			});
			$("#shopCategory").html(tempShopCategoryHtml);
			$("#area").html(tempAreaHtml);
		}
	});
}

//初始化提交按钮点击事件
function initSubmitEven(){
	$("#submit").click(function(){
		var shop = {};
		shop.name = $("#shopName").val();
		shop.phone = $("#phone").val();
		shop.address = $("#address").val();
		shop.description = $("#shopDesc").val();
		shop.shopType_ID = $("#shopCategory").find("option").not(function(){
				return !this.selected;
			}).data("id")
		shop.area_ID = $("#area").find("option").not(function(){
				return !this.selected;
			}).data("id")
		//获取上传文件流
		var shopImg = $("#img")[0].files[0];
		//验证码
		var verifyCodeActual = $("#captcha").val();
		if(!verifyCodeActual){
			$.toast("请输入验证码！");
			return; 
		}
		//表单控件
		var formData = new FormData();
		formData.append("shopImg", shopImg);
		formData.append("jsonStr", JSON.stringify(shop));
		formData.append("verifyCodeActual", verifyCodeActual);
		$.ajax({
			url: registerShopUrl,
			type: "POST",
			data: formData,
			contentType: false,
			processData: false,
			cache: false,
			success: function(data){
				if(data.success){
					$.toast("提交成功！");
				}else{
					$.toast("提交失败：" + data.errMsg);
				}
				$("#cpatcha_img").click();
			}
		})
	});
}