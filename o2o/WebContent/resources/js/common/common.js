/**
 * 公有js
 * ctyFL
 * 2021-02-13
 */

//生成验证码
function changeVerifyCode(img){
	img.src = "../Kaptcha?" + Math.floor(Math.random()*100);
}