const canvas = document.getElementById('canvas');
let currentX = 0
let currentY = 0
let prevX = 0
let prevY = 0
function draw(x1, y1, a, b) {
	const ctx = canvas.getContext('2d');
	ctx.fillStyle = 'green';
	ctx.fillRect(50 * x1, 50 * y1, a, b);
	currentX = x1
	currentY = y1
	
}
function unDraw(x1, y1, a, b){
	const ctx = canvas.getContext('2d');
	ctx.fillStyle = 'white';
	ctx.fillRect(50 * x1, 50 * y1, a, b);

	if(x1<0){
		
	}

}

function genFed(){

}
let DIRECTION = ""
function recogKey(e, dirc) {
	if (dirc == "") { dirc = e.key } else { e.key = dirc }
	switch (e.key) {
		case "ArrowDown":
			prevX = currentX
			prevY = currentY
			
			draw(currentX, currentY + 1, wBoxSize, hBoxSize)	
			unDraw(prevX, prevY, wBoxSize, hBoxSize)
			console.log("ArrowDown");
			DIRECTION = "ArrowDown"
			break;
		case "ArrowUp":
			draw(currentX, currentY - 1, wBoxSize, hBoxSize)
			unDraw(prevX, prevY, wBoxSize, hBoxSize)
			console.log("ArrowUp");
			DIRECTION = "ArrowUp"
			break;
		case "ArrowLeft":
			draw(currentX - 1, currentY, wBoxSize, hBoxSize)
			unDraw(prevX, prevY, wBoxSize, hBoxSize)
			console.log("ArrowLeft");
			DIRECTION = "ArrowLeft"

			break;
		case "ArrowRight":
			draw(currentX + 1, currentY, wBoxSize, hBoxSize)
			unDraw(prevX, prevY, wBoxSize, hBoxSize)
			console.log("ArrowRight");
			DIRECTION = "ArrowRight"
			break;
		default:
			console.log(e.key, e.keyCode);
			return;
	}
	prevX = currentX
	prevY = currentY
	console.log(prevX, prevY, currentX, currentY);
}



const wBoxSize = 50
const hBoxSize = 50
draw(0, 0, 50, 50)
addEventListener("keydown", recogKey)
let cnt = 0





