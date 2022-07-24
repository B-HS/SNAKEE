let ctx
let cvas
let width
let height
let blockSize= 25
let rows =20
let cols =20
let x = blockSize*1
let y = blockSize*1
let fx;
let fy;
let vx = 0
let vy = 0
let speed = 10
let tail = []
let gameOver = false
window.onload = function(){
    cvas = document.getElementById("canvas")
    ctx = cvas.getContext("2d")
    cvas.height= rows * blockSize
    cvas.width = cols * blockSize
    genFood()
    document.addEventListener("keyup", objectDirect)
    document.addEventListener("keydown", resnake)
    // snake()
    setInterval(snake, 1000/speed)
}
function objectDirect(e){
    switch(e.key){
        case "ArrowUp":
            if (vy!=1){vx = 0; vy = -1;}
            break
        case "ArrowDown":

            if (vy!=-1){vx = 0; vy = 1;}
            break
        case "ArrowLeft":
            if (vx!=1){vx = -1; vy = 0;}
            break
        case "ArrowRight":
            if (vx!=-1){vx = 1 ;vy = 0;}
            break
    }
        
}
function genFood(){
    fx = Math.floor(Math.random()*cols)*blockSize
    fy = Math.floor(Math.random()*rows)*blockSize
}



function snake(){ 
    if(gameOver){
        return
    }
    ctx.fillStyle = "black"
    ctx.fillRect(0, 0, cvas.width, cvas.height)
    
    ctx.fillStyle="red"
    ctx.fillRect(fx, fy, blockSize, blockSize)
    //Generate food when object reached to food and add tail
    if (x==fx&& y==fy){
        genFood()
        tail.push([fx, fy])
    }
    //Move array's last object to -1 array for moving snake
    for(let i = tail.length-1; i>0; i-- ){
        tail[i] = tail[i-1]
    }
    //set head
    if(tail.length){
        tail[0] = [x, y]
    }
    //set initial snake
    x+=vx*blockSize
    y+=vy*blockSize
    ctx.fillStyle="lime" 
    ctx.fillRect(x, y, blockSize, blockSize)
    
    
    //making tail with head
    for(let i = 0; i<tail.length;i++){
        ctx.fillStyle="lime"
        ctx.fillRect(tail[i][0], tail[i][1], blockSize, blockSize)
    }

    //condition for game over
    if(x<0 || x>=cols*blockSize || y<0|| y>=rows*blockSize){
        gameOver=true
        alert("gameOver")
        

    }
    //condition for game over
    for(let i =0; i<tail.length; i++){
        if(x==tail[i][0] && y ==tail[i][1]){
            gameOver=true;
            alert("gameOver")

        }
    }

    }
    //reset
    function resnake(e){
        if(e.keyCode == "32"){
        x = blockSize*1
        y = blockSize*1
        genFood()
        vx = 0
        vy = 0
        speed = 15
        tail = []
        gameOver = false
        snake()
    }

}




