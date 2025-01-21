$(function() {
    $(".gun").click(function() {
        let idx = parseInt(Math.random()*12);

        if ($(".sunban img").eq(idx).is(":hidden")) {
            $("#msg").html("꽝!!!"+(idx+1)+"번째 인형은 없습니다");
        } else {
            $("#msg").html((idx+1) + "번째 인형을 맞췄습니다");
            $(".sunban img").eq(idx).hide();
        }

        let n = $(".sunban img:hidden").length;
        if (n == 12) {
            $("#msg").html("Game Over!!!");
        }
    });

    $(".money img").click(function() {
            $(".sunban img").show();
            $("#msg").html("");

        $(this).css("display","none");
    });
});