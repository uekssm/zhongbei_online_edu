$(function(){
    var swiper = new Swiper('.swiper-container', {
        slidesPerView: 5,
        paginationClickable: true,
        spaceBetween: 30,
        scrollbar: '.swiper-scrollbar',
        scrollbarHide: true,
        // centeredSlides: true,
        // grabCursor: true
    });
    $('.close').on('click',function(){
         $('.spider').css({opacity:0,zIndex:-1});
    })
});