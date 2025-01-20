$(function(){
    $("ul.list img").click(function() {
         $(this).parent().addClass("active");
 
         $(this).parent().siblings().removeClass("active");
 
         let title = $(this).attr("title");
         $("h1.title").text(title);
         let imgSrc = $(this).attr("src");
         let url = `url(${imgSrc})`;
         $(".wall").css("background-image",url);
    }); 
 });