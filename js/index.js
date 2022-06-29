

function draw(x1, y1, a, b){
    const canvas = document.getElementById('canvas');
    const ctx = canvas.getContext('2d');
    ctx.fillStyle = 'green';
    ctx.fillRect(50*x1, 50*y1, a, b);
}

draw(10, 10, 50, 50)
draw(11, 11, 50, 50)