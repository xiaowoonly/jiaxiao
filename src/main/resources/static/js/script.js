/**
 * Created by baobaobao on 2016/3/24.
 */
$(document).ready(function(){
    addNavEvent();
    bannerPlay();
    search();
    clickLove();
    imgLazyLoading();
	jiaoyou();
	guanzhu();
	more();
	share();	
});


/*
    ·搜索框 焦点事件
*/
function search(){
		function main_search(iconid,Input,searchwrap,msearch,cal){
			var searchInput= $(Input);
			$(iconid).click(function(e) {
				$(searchwrap).hide(0)
				$(msearch).show(200)
			});
			$(cal).click(function(e) {
				$(searchwrap).show(0)
				$(msearch).hide(0)
			});
	
			searchInput.focus(function(){
				searchInput.attr('placeholder','');
			}).blur(function(){
				searchInput.attr('placeholder','请输入您想要的商品');
			});
		}
		/*搜索icon  搜索input 主内容包裹 主搜索框 取消搜索框*/	
		 main_search('#haipin_details_search','#tansuo_video_input','.tansuo_video_searchwrap','.tansuo_video_search','.tansuo_video_search_cancel')
		 main_search('#tansuo_one_search','#tansuo_one_input','.tansuo_one_searchwrap','.tansuo_one_search','.tansuo_one_search_cancel')
		 main_search('#person_wmrd_search','#person_wmrd_input','.person_wmrd_searchwrap','.person_wmrd_search','.person_wmrd_search_cancel')
		 main_search('#person_wmcd_search','#person_wmcd_input','.person_wmcd_searchwrap','.person_wmcd_search','.person_wmcd_search_cancel')
}
/*
    添加导航点击事件
*/
function addNavEvent(){
    var aLi = $('.g-footer li');
    aLi.on('click' ,function(){
        $(this).addClass("active").siblings().removeClass("active");
    });
	$('.g-footer li:eq(1)').click(function(e) {
        $('.g-footer li img.default').css('display','none')	
        $('.g-footer li img.click').css('display','block')	
        $('.g-footer li img._default').css('display','none')	
        $('.g-footer li img._click').css('display','block')					
    });
	$('.g-footer li:eq(0)').click(function(e) {
        $('.g-footer li img.default').css('display','block')	
        $('.g-footer li img.click').css('display','none')	
        $('.g-footer li img._default').css('display','block')	
        $('.g-footer li img._click').css('display','none')					
    });	
}
/*
    添加图片轮播
 */
function bannerPlay(){
    $('.flicker-example').flicker();
}

/* 点赞事件 */
function clickLove(){
    var loveNum = $('.hot-live-love');
    loveNum.on('click',function(){
        var span = $(this).find('.love-Num');
        var num = parseInt(span.text())+1;
        span.text(num);
    });

}

/* 图片缓加载 */
function imgLazyLoading(){
    $("img.lazy").lazyload({
        threshold : 0,     //设置灵敏度，表示进入显示区域还有200像素就开始加载
        effect : "fadeIn", //使用淡入特效
        failure_limit : 10 //容差范围，一定要设置此值，原因说明请参考原文档
    });
	$('img').addClass('lazy')
}
/*同城交友*/
function jiaoyou(){	
	$('header ._mid li:eq(1)').click(function(e) {
		$(this).css({'color':'#19b5ff','background':'#fff'}).siblings().css({'color':'#fff','background':'#19b5ff'})
        $('.main_cityfriends').show(0)
    	$('.main_nearby').hide(0)
	});
	$('header ._mid li:eq(0)').click(function(e) {
		$(this).css({'color':'#19b5ff','background':'#fff'}).siblings().css({'color':'#fff','background':'#19b5ff'})
        $('.main_cityfriends').hide(0)
    	$('.main_nearby').show(0)
	});
		
	}
/*关注按钮*/
function guanzhu(){
		var aLi =$('.main_nearby .focus,.main_cityfriends .focus');
		// var onOff = true;	// 只能控制一组！
		for( var i=0; i<aLi.length; i++ ){
			
			aLi[i].onOff = true;
			
			aLi[i].onclick = function (){
				if ( this.onOff ) {
					$(this).css({'color':'#fff','background':'#19b5ff'}).html('已关注')
					this.onOff = false;
				} else {
					$(this).css({'color':'#19b5ff','background':'#fff'}).html('+&nbsp;关注')
					this.onOff = true;
				}
			};
		}
	}
/*更多*/	
function more(){
		$('#nearby_more').click(function(e) {
		  	$('.main_nearby_more').show(0)
			$('.main_nearby_f-overlay').show(0)
    	});
		$('.main_nearby_more li:eq(4)').click(function(e) {
		  	$('.main_nearby_more').hide(0)
			$('.main_nearby_f-overlay').hide(0)
        });
	}
/*分享*/	
function share(){
		function  main_share(btn,overlay,cal){
			$(btn).click(function(e) {
				$(overlay).show(0)
			});
			$(cal).click(function(e) {
				$(overlay).hide(0)
			});
		}
		main_share('#haipin_details_share','.main_haipin_f-overlay','.main_haipin_f-overlay .cancel')
		main_share('#main_video_details_describe_share','.main_haipin_f-overlay','.main_haipin_f-overlay .cancel')
		main_share('#person_share','.main_person_share_f-overlay','.main_person_share_f-overlay .cancel')
		main_share('.main_person_dynamic ul li ul.control li .wrap','.main_person_share_f-overlay','.main_person_share_f-overlay .cancel')
		
	}
/*删除功能*/

	(function($) {
	$('#OA_task_1').on('tap', '.mui-btn-yellow', function(event) {
					var elem = this;
					var li = elem.parentNode.parentNode;
					li.parentNode.removeChild(li);
					setTimeout(function() {
					$.swipeoutClose(li);
					}, 0);
					});

	$('#OA_task_1').on('tap', '.mui-btn-grey', function(event) {
					var elem = this;
					var li = elem.parentNode.parentNode;
					var list=$('#OA_task_1');
					var fristLi=$('#OA_task_1 li')[0];
					li.parentNode.insertBefore(li,fristLi);
					setTimeout(function() {
					$.swipeoutClose(li);
					}, 0);
						
					
				});
			
		
				var btnArray = ['确认', '取消'];
				

				})
	(mui);
	

