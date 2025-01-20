$(function() {
    $("h1.title").click(function() {
        $("ul.music-list").slideDown('slow');
    });

    $("ul.music-list li").click(function(){
        let title = $(this).text();
        $("h1.title").text(title);

        let selectClass = $(this).attr("class");
        $("#cd").animate({width:'0'}, 'slow', function() {
            $("#cd").attr("class",selectClass);
            $(this).animate({width:'300px'}, 'slow');
        });

        $("ul.music-list").slideUp('slow');
    });
});