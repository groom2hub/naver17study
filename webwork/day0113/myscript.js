window.onload=function(){
    let mycar=document.querySelectorAll(".mycar");//배열타입

    let photo="";
    mycar[0].onmouseover=function(){
        photo=this.getAttribute("src");
        this.setAttribute("src","../photo/K-052.png");     
    }
    mycar[0].onmouseout=function(){
        this.setAttribute("src",photo);  
    }

    mycar[1].onmouseover=function(){
        this.style.borderStyle="inset";
        this.style.borderWidth="10px";
        this.style.borderColor="green";
    }
    mycar[1].onmouseout=function(){
        this.style.border="none";
    }

    mycar[2].onmouseover=function(){
        this.setAttribute("class","mycar happy");
    }
    mycar[2].onmouseout=function(){
        this.setAttribute("class","mycar");
    }
}