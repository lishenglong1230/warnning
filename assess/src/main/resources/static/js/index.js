window.addEventListener('load',function () {
    var big =document.querySelector('.banner');

    var right =big.querySelector('.right');
    var num=0;
    var circle =0;
    var flag=true;
    big.addEventListener('mouseover',function(){

        right.style.display='block';
        // clearInterval(timmer);
        timmer=null;
    });
    big.addEventListener('mouseleave',function(){

        right.style.display='none';
        // timmer=setInterval(function(){
        //     right.click();
        // },2000);

    });
    //动态生成圆圈
    var ul =big.querySelector('ul');
    var ol =big.querySelector('ol');
    for(var i=0;i<ul.children.length;i++)
    {
        var li =document.createElement('li');
        ol.appendChild(li);
        li.setAttribute('index',i);

    }
    ol.children[0].className='current';
    for (var i=0;i<ol.children.length;i++)
    {
        ol.children[i].addEventListener('click',function(){
            //小圆圈排他思想
            for(var i=0;i<ol.children.length;i++)
            {
                ol.children[i].className='';
            }
            this.className='current';
            //点击圆圈滚动图片
            var index =this.getAttribute('index');
            num=index;
            circle=index;
            annimate(ul,-index*big.offsetWidth);
        });

    }
    var clone =ul.children[0].cloneNode(true);
    ul.appendChild(clone);
    right.addEventListener('click',function(){

        if(flag)
        {
            flag=false;
            if(num==ul.children.length-1)
            {
                console.log(num+'aaa');
                // annimate(ul,-num*big.offsetWidth);
                ul.style.left=0;
                num=0;
            }
            num++;
            annimate(ul,-num*big.offsetWidth,function(){
                flag=true;
            });
            // console.log(num);


            circle++;
            if(circle==ol.children.length)
            {

                circle=0;
            }
            for(var i=0;i<ol.children.length;i++)
            {
                ol.children[i].className='';
            }
            ol.children[circle].className='current';
        }

    });

    var timmer=setInterval(function(){
        right.click();
    },2000);


});