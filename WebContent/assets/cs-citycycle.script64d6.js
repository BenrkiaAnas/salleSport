
var touch = false, clickEv = 'click';

/* Handle detect platform */
function handleDetectPlatform(){
  /* DETECT PLATFORM */
  $.support.touch = 'ontouchend' in document;
  
  if ($.support.touch) {
    touch = true;
    $('body').addClass('touch');
    clickEv = 'touchstart';
  }
  else{
    $('body').addClass('notouch');
    if (navigator.appVersion.indexOf("Mac")!=-1){
      if (navigator.userAgent.indexOf("Safari") > -1){
        $('body').addClass('macos');
      }
      else if (navigator.userAgent.indexOf("Chrome") > -1){
        $('body').addClass('macos-chrome');
      }
        else if (navigator.userAgent.indexOf("Mozilla") > -1){
          $('body').addClass('macos-mozilla');
        }
    }
  }
}

/* Fucntion get width browser */
function getWidthBrowser() {
	var myWidth;

	if( typeof( window.innerWidth ) == 'number' ) { 
		//Non-IE 
		myWidth = window.innerWidth;
		//myHeight = window.innerHeight; 
	} 
	else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) { 
		//IE 6+ in 'standards compliant mode' 
		myWidth = document.documentElement.clientWidth; 
		//myHeight = document.documentElement.clientHeight; 
	} 
	else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) { 
		//IE 4 compatible 
		myWidth = document.body.clientWidth; 
		//myHeight = document.body.clientHeight; 
	}
	
	return myWidth;
}

// handle Animate
function setAnimate() {
  if($(window).innerWidth() > 768 ){
    var ani = '100%';
    if(index==1) ani='50%';
  	$('.left-search-block, .right-links-blocks').waypoint(function() {
		if ( !$( this ).hasClass( "animated" ) ){
      $(this).toggleClass('animated fadeInDown');
	}},
	{ offset: '100%' });
      
    $('.nav-logo, .nav-menu, .shopby-collections-wrapper, .product-detail-content #product-image #gallery-images, #order_payment').waypoint(function() {
	if ( !$( this ).hasClass( "animated" ) ){
      $(this).toggleClass('animated fadeInLeft');
	}},
	{ offset: '100%' });
    
    $('#tabpanel, #home-banner, #home-browser-collections, .blog-content .article, .blogs-item .blog-group, .comments .comment, .comment_form, .product-detail-content #product-image #featuted-image, .product-detail-content #tabs-information, .related-products, #customer_orders, #order_details, #wish-list .table-cart').waypoint(function() {
	if ( !$( this ).hasClass( "animated" ) ){
      $(this).toggleClass('animated fadeInUp');
	}},
	{ offset: ani });
      
    $('#footer-top, #footer-infomation, #footer-links, #footer-bottom').waypoint(function() {
	if ( !$( this ).hasClass( "animated" ) ){
      $(this).toggleClass('animated fadeInUp');
	}},
	{ offset: ani });
      
    $('#home-browser-collections .home-collections-links li, #collections-listing ul li.link-element').waypoint(function() {
	if ( !$( this ).hasClass( "animated" ) ){
      $(this).toggleClass('animated flipInX');
	}},
	{ offset: ani });
    $('.sidebar .sb-item, .product-detail-content #product-information, #customer_sidebar, #order_shipping').waypoint(function() {
	if ( !$( this ).hasClass( "animated" ) ){
      $(this).toggleClass('animated fadeInRight');
	}},
	{ offset: ani });
  }
}
                                               
/* Handle dropdown box */
function handleDropdown(){
  if($('.dropdown-toggle').length){
    $('.dropdown-toggle').parent().hover(function (){
      if(touch == false && getWidthBrowser() > 767 ){
        $(this).find('.dropdown-menu').stop(true, true).slideDown(300);
      }
    }, function (){
      if(touch == false && getWidthBrowser() > 767 ){
        $(this).find('.dropdown-menu').hide();
      }
    });
  }
  
  $('nav .dropdown-menu').each(function(){
    $(this).find('li').last().addClass('last');
  });
  
  $('.dropdown').on('click', function() {
      if(touch == false && getWidthBrowser() > 767 ){
        var href = $(this).find('.dropdown-link').attr('href');
        window.location = href;
    }
  });
  
  $('.cart-link').on('click', function() {
      if(touch == false && getWidthBrowser() > 767 ){
        var href = $(this).find('.dropdown-link').attr('href');
        window.location = href;
    }
  });
}

/* Log-in Dropdown */
function handleLogin(){
  $("#loginBox input").focus(function() {
    $(this).parents('#loginBox').addClass('focus');
  }).blur(function() {
    $(this).parents('#loginBox').removeClass('focus');
  });
}
      
/* Full Width Carousel */
function handleFlexCasousel(){
  var animate,text;
    if ( $('.slides li').size() > 1 ) {
    $('.home-slideshow').flexslider({
      namespace: "jemiz-",
      slideshow: false,
      animation: "fade",
      slideshowSpeed:5000,
      directionNav: false,
      controlNav: true,
      pauseOnHover: false,
      randomize:false,
      smoothHeight: true,
      directionNav: false,
      start: function(){
        $('.home-slideshow-wrapper').css({"overflow":"","height":"" });
      	$('.home-slideshow').css("opacity","1"); 
        $('.home-slideshow-loader').hide();
      	$( ".home-slideshow .slides li" ).each(function() {
         if($(window).innerWidth() >= 1200 && $(window).innerHeight() >= 600){
           $(this).css("height",$(window).innerHeight());
           $('.home-slideshow').css("height",$(window).innerHeight());           
         }
     	 if($(this).hasClass("jemiz-active-slide")){
      		$(this).children('div').addClass("animated");
      		$(this).children('div.caption-text').each(function() {
      			animate = $(this).attr('data-jemiz-animate');
      			$(this).addClass(animate);
      			text = $(this).attr('data-jemiz-text');
      			$(this).html("<img src='"+text+"' alt='' />");
    		});
    	 }	
         else{
            $(this).children('div').removeClass("animated");
      		$(this).children('div').each(function() {
                animate = $(this).attr('data-jemiz-animate');
      			$(this).removeClass(animate);
      			$(this).html("");
            });
         }
    	});
      },
      after: function(){
      	$( ".home-slideshow .slides li" ).each(function() {
         if($(window).innerWidth() >= 1200 && $(window).innerHeight() >= 600){
           $(this).css("height",$(window).innerHeight());
         }
     	 if($(this).hasClass("jemiz-active-slide")){
      		$(this).children('div').addClass("animated");
      		$(this).children('div.caption-text').each(function() {
      			animate = $(this).attr('data-jemiz-animate');
      			$(this).addClass(animate);
      			text = $(this).attr('data-jemiz-text');
      			$(this).html("<img src='"+text+"' alt='' />");
    		});
    	 }	
         else{
            $(this).children('div').removeClass("animated");
      		$(this).children('div').each(function() {
                animate = $(this).attr('data-jemiz-animate');
      			$(this).removeClass(animate);
      			$(this).html("");
            });
         }
    	});
      }
    });

  }
}

/* Parallax Carousel and Opacity Caption*/
function parallaxOpacityCarousel() {
  $(document).scroll(function(){
  	var scrollPos = $(this).scrollTop();
  	$('.caption-text').css({'opacity' : 1-(scrollPos*2/$(window).innerHeight())});
    //$(".slides img").css("transform","translateY(" +  -(scrollPos/4)  + "px)");
  });
}
      
/* Function update scroll product thumbs */
function updateScrollThumbsQS(){
  if($('#gallery_main_qs').length){
    
    $('#quick-shop-image .fancybox').on(clickEv, function() {
      var _items = [];
      var _index = 0;
      var product_images = $('#gallery_main_qs .image-thumb');
      product_images.each(function(key, val) {
        _items.push({'href' : val.href, 'title' : val.title});
        if($(this).hasClass('active')){
          _index = key;
        }
      });
      $.fancybox(_items,{
        closeBtn: true,
        index: _index,
        helpers: {
          buttons: {}
        }
      });
      return false;
    });

    $('#quick-shop-image').on(clickEv, '.image-thumb', function() {

      var $this = $(this);
      var background = $('.product-image .main-image .main-image-bg');
      var parent = $this.parents('.product-image-wrapper');
      var src_original = $this.attr('data-image-zoom');
      var src_display = $this.attr('data-image');
      
      background.show();
      
      parent.find('.image-thumb').removeClass('active');
      $this.addClass('active');
      
      parent.find('.main-image').find('img').attr('data-zoom-image', src_original);
      parent.find('.main-image').find('img').attr('src', src_display).load(function() {
        background.hide();
      });
      
      return false;
    });
  }
}
                                                                     
/* Carousel Product*/
function HandleCarousel(){
  /* Collection Carousel */
  if($(".home-collections-links").length){
    $(".home-collections-links").owlCarousel({
      navigation : true,
      pagination: false,
      items: 4,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,4],
      itemsDesktopSmall : [979,3],
      itemsTablet: [768,3],
      itemsTabletSmall: [540,2],
      itemsMobile : [360,1],
      navigationText: ['<i class="fa fa-angle-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-angle-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }
  
  if($(".video-embed").length){
    $(".video-embed").owlCarousel({
      navigation : true,
      pagination: false,
      items: 1,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,1],
      itemsDesktopSmall : [979,1],
      itemsTablet: [768,1],
      itemsTabletSmall: [540,1],
      itemsMobile : [360,1],
      navigationText: ['<i class="fa fa-caret-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-caret-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }
  
  /* Most Viewed Carousel */
  if($(".mostview-content").length){
    $(".mostview-content").owlCarousel({
      navigation : true,
      pagination: false,
      items: 1,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,1],
      itemsDesktopSmall : [979,1],
      itemsTablet: [768,1],
      itemsTabletSmall: [540,1],
      itemsMobile : [360,1],
      navigationText: ['<i class="fa fa-angle-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-angle-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }
  
  /* Sale Off Carousel */
  if($(".saleoff-content").length){
    $(".saleoff-content").owlCarousel({
      navigation : true,
      pagination: false,
      items: 1,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,1],
      itemsDesktopSmall : [979,1],
      itemsTablet: [768,1],
      itemsTabletSmall: [540,1],
      itemsMobile : [360,1],
      navigationText: ['<i class="fa fa-angle-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-angle-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }
  
  if($("#partners").length){
    $("#partners").owlCarousel({
      navigation : true,
      pagination: false,
      items: 5,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,5],
      itemsDesktopSmall : [979,4],
      itemsTablet: [768,4],
      itemsTabletSmall: [540,3],
      itemsMobile : [360,2],
      navigationText: ['<i class="fa fa-angle-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-angle-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }
  
  if($(".related-products ul.related-products-items").length){
    $(".related-products ul.related-products-items").owlCarousel({
      navigation : true,
      pagination: false,
      items: 4,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,4],
      itemsDesktopSmall : [979,3],
      itemsTablet: [768,3],
      itemsTabletSmall: [540,2],
      itemsMobile : [360,1],
      navigationText: ['<i class="fa fa-angle-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-angle-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }
  
  if($("#gallery-images-mobile .vertical-slider").length){
    $("#gallery-images-mobile .vertical-slider").owlCarousel({
      navigation : true,
      pagination: false,
      items: 4,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,4],
      itemsDesktopSmall : [979,4],
      itemsTablet: [768,4],
      itemsTabletSmall: [540,4],
      itemsMobile : [360,4],
      navigationText: ['<i class="fa fa-angle-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-angle-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }
  
  if($("#gallery-images .vertical-slider").length){
    $("#gallery-images .vertical-slider").owlCarousel({
      navigation : true,
      pagination: false,
      items: 4,
      slideSpeed : 200,
      paginationSpeed : 800,
      rewindSpeed : 1000,
      itemsDesktop : [1199,4],
      itemsDesktopSmall : [979,4],
      itemsTablet: [768,4],
      itemsTabletSmall: [540,4],
      itemsMobile : [360,4],
      navigationText: ['<i class="fa fa-angle-left" title="Previous" data-toggle="tooltip" data-placement="top"></i>', '<i class="fa fa-angle-right" title="Next" data-toggle="tooltip" data-placement="top"></i>']
    });
  }

}
      
// handle scroll-to-top button
function handleScrollTop() {
  function totop_button(a) {
    var b = $("#scroll-to-top");
    b.removeClass("off on");
    if (a == "on") { b.addClass("on") } else { b.addClass("off") }
  }
  $(window).scroll(function() {
    var b = $(this).scrollTop();
    var c = $(this).height();
    if (b > 0) { 
      var d = b + c / 2;
    } 
    else { 
      var d = 1 ;
    }    
    if (d < 1e3 && d < c) { 
      totop_button("off");
    } 
    else {
      totop_button("on"); 
    }
  });  
  $("#scroll-to-top").click(function (e) {
    e.preventDefault();
    $('body,html').animate({scrollTop:0},800,'swing');
  });
}    
      
function ModalNewsletter(){  
  
  	if ($.cookie('jemiz-cookie') != "active"){
  		$('#newsletter-popup').modal('toggle');
  		$('.nl-wraper-popup').addClass('animated'); 
    }
    $.cookie('jemiz-cookie', 'active', { expires: 1});
  
  
}
      
function checkcookie(){
    $.cookie('jemiz-cookie', 'deactive', { expires: 1});
}
      
function autocompleteSearch(){
  var currentAjaxRequest = null;  
  var searchForms = $('form[action="/search"]').css('position','relative').each(function() {    
    var input = $(this).find('input[name="q"]');    
    var offSet = input.position().top + input.innerHeight();
    $('<ul class="search-results"></ul>').css( { 'position': 'absolute', 'left': '0px', 'top': offSet } ).appendTo($(this)).hide();    
    input.attr('autocomplete', 'off').bind('keyup change', function() {
      var term = $(this).val();
      var form = $(this).closest('form');
      var searchURL = '/search?type=product&q=' + term;
      var resultsList = form.find('.search-results');      
      if (term.length > 3 && term != $(this).attr('data-old-term')) {      
        $(this).attr('data-old-term', term);      
        if (currentAjaxRequest != null) currentAjaxRequest.abort();     
        currentAjaxRequest = $.getJSON(searchURL + '&view=json', function(data) {          
          resultsList.empty();          
          if(data.results_count == 0) {          
            resultsList.hide();
          } else {         
            $.each(data.results, function(index, item) {
              var link = $('<a></a>').attr('href', item.url);
              link.append('<span class="thumbnail"><img src="' + item.thumbnail + '" /></span>');
              link.append('<span class="title">' + item.title + '</span>');
              link.wrap('<li></li>');
              resultsList.append(link.parent());
            });      
            if(data.results_count > 10) {
              resultsList.append('<li><span class="title"><a href="' + searchURL + '">See all results (' + data.results_count + ')</a></span></li>');
            }
            resultsList.fadeIn(200);
          }        
        });
      }
    });
  });
  $('body').bind('click', function(){
    $('.search-results').hide();
  });
}

/* Handle Grid - List */
function handleGridList(){
  
  
  if($('#goList').length){
    $('#goList').on(clickEv, function(e){
      $(this).parent().find('li').removeClass('active');
      $(this).addClass('active');
      $('#sandBox .element').addClass('full_width');
      $('#sandBox .element').removeClass('no_full_width');
      $('#sandBox .element .row-left').addClass('col-md-4');
      $('#sandBox .element .row-right').addClass('col-md-8');
      $('#sandBox .element').removeClass('animated flipInX');
      $('#sandBox .element').addClass('jemiz-animated');
      $('#sandBox').isotope('layout');
    });
  }
  
  if($('#goGrid').length){
    $('#goGrid').on(clickEv, function(e){
      $(this).parent().find('li').removeClass('active');
      $(this).addClass('active');
      $('#sandBox .element').removeClass('full_width');
      $('#sandBox .element').addClass('no_full_width');
      $('#sandBox .element .row-left').removeClass('col-md-4');
      $('#sandBox .element .row-right').removeClass('col-md-8');
      $('#sandBox').isotope('layout');
    });
  }
}
      
/* Handle product quantity */
function handleQuantity(){
  if($('.quantity-wrapper').length){
    $('.quantity-wrapper').on(clickEv, '.qty-up', function() {
      var $this = $(this);

      var qty = $this.data('src');
      $(qty).val(parseInt($(qty).val()) + 1);
    });
    $('.quantity-wrapper').on(clickEv, '.qty-down', function() {
      var $this = $(this);

      var qty = $this.data('src');

      if(parseInt($(qty).val()) > 1)
        $(qty).val(parseInt($(qty).val()) - 1);
    });
  }
}
      
function colorwarches(){
   jQuery('.swatch :radio').change(function() {
     var optionIndex = jQuery(this).closest('.swatch').attr('data-option-index');
     var optionValue = jQuery(this).val();
     jQuery(this)
       .closest('form')
       .find('.single-option-selector')
       .eq(optionIndex)
       .val(optionValue)
       .trigger('change');
   }); 
}

/* Handle Map with GMap */
function handleMap(){
  if(jQuery().gMap){
    if($('#contact_map').length){
      $('#contact_map').gMap({
        zoom: 17,
        scrollwheel: false,
        maptype: 'ROADMAP',
        markers:[
          {
            address: '474 Ontario St Toronto, ON M4X 1M7 Canada',
            html: '_address'
          }
        ]
      });
    }
  }
}      

function toggleLeftMenu(){ 
  if(window.innerWidth <= 1199 ){
    var menuLeft = document.getElementById( 'is-mobile-nav-menu' ),				
        showLeftPush = document.getElementById( 'showLeftPush' ),	
        rightcontent = document.getElementById( 'right-content' ),
        body = document.body;			
    showLeftPush.onclick = function() {
      classie.toggle( this, 'active' );
      classie.toggle( body, 'pushed' );
      classie.toggle( menuLeft, 'leftnavi-open' );
      classie.toggle( rightcontent, 'leftnavi-pushed' );
      if(classie.has( this, 'active' ))
        $('#showLeftPush').html("<i class='fa fa-times fa-2x'></i>");
      else $('#showLeftPush').html("<i class='fa fa-bars fa-2x'></i>");
    };
  }
};
      
function toggleTagsFilter(){ 
  if(window.innerWidth >= 768 ){
    var tagsbutton = document.getElementById( 'showTagsFilter' ),				
        tagscontent = document.getElementById( 'tags-filter-content' );    
    if(tagsbutton != null ){
      tagsbutton.onclick = function() {
        classie.toggle( this, 'closed' );
        classie.toggle( tagscontent, 'tags-closed' );
        if(classie.has( this, 'closed' ))
          $('#showTagsFilter').html("Filter <i class='fa fa-angle-down'></i>");
        else $('#showTagsFilter').html("Filter <i class='fa fa-angle-up'></i>");
      };
    }
  }
}
      
$( window ).resize(function() {
  toggleLeftMenu();
});
      
$(window).ready(function($) {
  
  handleDetectPlatform();
  
   autocompleteSearch()  
  
  parallaxOpacityCarousel();
  
  updateScrollThumbsQS();
  
  handleDropdown();
  
  handleLogin();
  
  HandleCarousel();
  
  $('#home-tabs a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
  });
  
  $('[data-toggle="tooltip"]').tooltip();  
  
  handleGridList();
  
  handleQuantity();
  
  colorwarches();
  
  handleScrollTop();
  
  handleMap();

  toggleLeftMenu();
  
  toggleTagsFilter();
  
  handleFlexCasousel();
});
     
      
$(window).load(function() {
  $("#loading-div").addClass("fadeOut animated");
  $("#loading-div").fadeOut(800);
  
  

  ModalNewsletter();
  
  
  
});