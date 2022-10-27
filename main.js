function getInvCount(arr) {
    let inv_count = 0;
    for (let i = 0; i < 2; i++) {
        for (let j = i + 1; j < 3; j++) {

            // Value 0 is used for empty space
            if (arr[j][i] > 0 && arr[j][i] > arr[i][j])
                inv_count += 1;
        }
    }
    return inv_count;
}
function isSolvable(puzzle) {
    let invCount = getInvCount(puzzle);
    return (invCount % 2 == 0);
}

class Puzzle{
    constructor (){
        var puzzle = [];
        var estado='';//hijo-padre
        var gn=0;
        var hn=0;
        var fn=0;
        var nodoPadre=null;
        var nodoHijo=null;
    }
}


var matrizObjetivo = [[0,1,2],[3,4,5],[6,7,8]];

let nodo = new Puzzle();
matriz = [[1, 8, 2], [0, 4, 3], [7, 6, 5]];

nodo.puzzle = matriz;
if (isSolvable(nodo.puzzle)) {
    console.log('se puede resolver');

} else {
    console.log('no se puede resolver');
}
