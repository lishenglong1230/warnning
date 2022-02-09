function annimate(div,target,callback){
    clearInterval(div.timmer);
    div.timmer=setInterval(function(){

        var off =(target-div.offsetLeft)/10;
        off=off>0?Math.ceil(off):Math.floor(off);
        if(div.offsetLeft==target)
        {
            clearInterval(div.timmer);
            //
            callback&&callback();
        }

        div.style.left=div.offsetLeft+off+'px';
    },30);
}