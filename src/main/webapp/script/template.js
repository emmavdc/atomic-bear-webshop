/*window.onscroll = function() {toggleStickyHeader()};

// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
function toggleStickyHeader() {
    let header = document.getElementsByClassName("headerStyle");
    header = header[0];
    let sticky = header.offsetTop;

    if (window.pageYOffset > sticky) {
        header.classList.add("fixed-top");
        //header.classList.add("sticky");
    } else {
        header.classList.remove("fixed-top");
        //header.classList.remove("sticky");
    }
}*/

if ($(window).width() > 992) {
    $(window).scroll(function(){
        if ($(this).scrollTop() > 0) {
            $('#navbar_top').addClass("fixed-top");
            // add padding top to show content behind navbar
            $('body').css('padding-top', $('.navbar').outerHeight() + 'px');
        }else{
            $('#navbar_top').removeClass("fixed-top");
            // remove padding top from body
            $('body').css('padding-top', '0');
        }
    });
} // end if