// set number of Rows and Collums
const DIMENSIONS = [7, 6];
const NUMCELLS = DIMENSIONS[0] * DIMENSIONS[1];

const SVGS = Object.freeze({
    CAT:0,
    STONE:1,
    COIN:2
})

function createSVGElement(svgID, fillColor = "black", strokeColor = "none") {
    var svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");

    switch (svgID) {
        case SVGS.STONE: {
            svg.setAttribute("viewBox", "0 0 1280 854");
            svg.setAttribute("preserveAspectRatio", "xMidYMid meet");
            svg.setAttribute("version", "1.0");
            svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            
            var g = document.createElementNS("http://www.w3.org/2000/svg", "g");
            g.setAttribute("transform", "translate(0.000000,854.000000) scale(0.100000,-0.100000)");
            g.setAttribute("fill", fillColor);
            g.setAttribute("stroke", strokeColor);
        
            var path = document.createElementNS("http://www.w3.org/2000/svg", "path");
            path.setAttribute("d", `M7715 8529 c-324 -24 -711 -94 -1087 -195 -219 -59 -434 -126 -808
            -255 -1003 -344 -1253 -413 -1555 -431 -206 -12 -726 -4 -1070 17 -137 9 -279
            13 -315 9 -152 -15 -294 -84 -382 -183 -59 -68 -159 -235 -294 -492 -245 -467
            -280 -532 -381 -700 -120 -201 -251 -388 -364 -521 -361 -424 -608 -887 -1059
            -1983 -45 -110 -84 -202 -86 -204 -3 -3 -10 1 -16 7 -7 7 -15 12 -19 12 -8 0
            -35 -78 -74 -217 -15 -51 -32 -105 -40 -120 -8 -16 -19 -59 -25 -98 -6 -38
            -19 -95 -29 -125 -35 -105 -42 -136 -76 -359 l-35 -224 51 -171 c32 -107 59
            -180 73 -196 12 -14 56 -79 96 -145 281 -458 480 -697 695 -838 89 -58 298
            -177 311 -177 2 0 71 -33 153 -74 82 -41 151 -72 154 -70 3 3 22 -3 44 -14 21
            -11 78 -34 127 -51 116 -41 501 -234 681 -341 77 -46 221 -138 320 -204 206
            -139 279 -177 351 -184 102 -9 369 26 534 70 318 84 1192 371 1715 563 195 71
            186 68 1095 300 338 87 930 238 1315 337 656 168 735 185 1255 284 695 131
            948 193 1303 319 290 103 610 251 732 340 168 121 370 309 613 568 290 310
            440 492 510 617 81 145 382 960 508 1375 156 514 187 757 135 1045 -32 182
            -80 409 -90 428 -4 9 -34 94 -66 187 -45 131 -78 204 -141 316 -156 277 -254
            430 -370 574 -74 93 -271 291 -280 282 -3 -3 -56 19 -117 48 -353 167 -1290
            431 -2417 679 -807 178 -1183 224 -1575 195z`);

            g.appendChild(path);
            svg.appendChild(g);

            break;
        }
        case SVGS.CAT: {
            svg.setAttribute("viewBox", "0 0 1228 1280");
            svg.setAttribute("version", "1.0");
            svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            
            var g = document.createElementNS("http://www.w3.org/2000/svg", "g");
            g.setAttribute("transform", "translate(0.000000,1280.000000) scale(0.100000,-0.100000)");
            g.setAttribute("fill", fillColor);
            g.setAttribute("stroke", strokeColor);
    
            var path = document.createElementNS("http://www.w3.org/2000/svg", "path");
            path.setAttribute("d", `M3192 12780 c-156 -56 -378 -289 -574 -605 -42 -66 -94 -152 -116
            -191 -41 -70 -42 -71 -89 -78 -145 -19 -547 -48 -739 -53 -212 -6 -223 -5
            -265 15 -24 12 -150 113 -279 224 -514 442 -745 603 -882 616 -46 4 -50 3 -87
            -36 -142 -148 -125 -508 72 -1564 l33 -176 -53 -79 c-64 -95 -136 -261 -168
            -389 -148 -583 78 -1206 669 -1844 138 -149 150 -170 228 -400 80 -235 80
            -235 72 -515 -7 -288 2 -372 62 -558 57 -176 121 -316 319 -702 451 -877 585
            -1161 615 -1302 23 -104 15 -1487 -10 -1823 -24 -327 -59 -551 -99 -628 -23
            -45 -41 -61 -108 -97 -160 -85 -307 -268 -328 -407 -16 -107 57 -225 184 -298
            57 -33 60 -37 61 -74 0 -100 66 -255 127 -302 19 -14 73 -42 119 -60 189 -76
            423 -110 594 -85 155 23 228 57 378 175 178 140 241 216 336 404 l46 92 38 -6
            c273 -44 347 -60 344 -74 -2 -8 -13 -51 -24 -95 -44 -170 -5 -309 119 -431 75
            -75 174 -127 281 -149 337 -69 1034 16 1883 231 l255 65 45 -25 c131 -73 326
            -110 543 -104 261 9 430 56 759 214 223 108 444 185 662 233 1016 221 2224
            121 2710 -224 309 -219 250 -439 -170 -635 -264 -124 -699 -249 -1173 -336
            l-152 -28 -75 -76 c-137 -137 -190 -233 -183 -331 7 -96 70 -157 211 -205 381
            -130 1000 -50 1667 213 648 256 1081 598 1201 950 35 100 33 250 -3 350 -53
            149 -201 323 -424 504 -935 753 -2510 1100 -3989 879 -71 -10 -166 -26 -210
            -35 -44 -8 -85 -15 -91 -15 -8 0 -5 23 8 68 142 503 244 1100 279 1645 15 234
            6 840 -15 1042 -67 621 -236 1188 -488 1628 -440 772 -1125 1289 -2076 1568
            -146 42 -180 62 -442 260 -177 134 -255 210 -289 282 -90 189 -363 482 -584
            627 -49 33 -93 60 -98 62 -5 2 -26 53 -48 113 -105 298 -219 549 -292 645
            l-42 54 21 141 c26 172 48 339 68 527 21 195 30 643 15 788 -34 350 -156 493
            -359 420z`);

            g.appendChild(path);
            svg.appendChild(g);

            break;
        }
        case SVGS.COIN: {
            svg.setAttribute("viewBox", "0 0 800 800");
            svg.setAttribute("version", "1.0");
            svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            
            var g = document.createElementNS("http://www.w3.org/2000/svg", "g");
            g.setAttribute("transform", "translate(0.000000,0.000000) scale(1, 1)");
            
            var el = document.createElementNS("http://www.w3.org/2000/svg", "ellipse");
            el.setAttribute("stroke", strokeColor);
            el.setAttribute("fill", fillColor);
            el.setAttribute("ry", 350);
            el.setAttribute("rx", 350);
            el.setAttribute("cx", 400);
            el.setAttribute("cy", 400);
            g.appendChild(el);
            
            var el = document.createElementNS("http://www.w3.org/2000/svg", "ellipse");
            el.setAttribute("stroke", "rgba(0, 0, 0, 0.15)");
            el.setAttribute("stroke-width", "6%");
            el.setAttribute("fill", "none");
            el.setAttribute("ry", 320);
            el.setAttribute("rx", 320);
            el.setAttribute("cx", 400);
            el.setAttribute("cy", 400);
            g.appendChild(el);
            
            svg.appendChild(g);

            
            var g = document.createElementNS("http://www.w3.org/2000/svg", "g");
            g.setAttribute("transform", "translate(230.000000,600.000000) scale(0.03,-0.03)");
            
            var path = document.createElementNS("http://www.w3.org/2000/svg", "path");
            path.setAttribute("stroke", "rgba(0, 0, 0, 0.2)");
            path.setAttribute("fill", "rgba(0, 0, 0, 0.2)");
            path.setAttribute("stroke-width", "100%");
            path.setAttribute("d", `M3192 12780 c-156 -56 -378 -289 -574 -605 -42 -66 -94 -152 -116
            -191 -41 -70 -42 -71 -89 -78 -145 -19 -547 -48 -739 -53 -212 -6 -223 -5
            -265 15 -24 12 -150 113 -279 224 -514 442 -745 603 -882 616 -46 4 -50 3 -87
            -36 -142 -148 -125 -508 72 -1564 l33 -176 -53 -79 c-64 -95 -136 -261 -168
            -389 -148 -583 78 -1206 669 -1844 138 -149 150 -170 228 -400 80 -235 80
            -235 72 -515 -7 -288 2 -372 62 -558 57 -176 121 -316 319 -702 451 -877 585
            -1161 615 -1302 23 -104 15 -1487 -10 -1823 -24 -327 -59 -551 -99 -628 -23
            -45 -41 -61 -108 -97 -160 -85 -307 -268 -328 -407 -16 -107 57 -225 184 -298
            57 -33 60 -37 61 -74 0 -100 66 -255 127 -302 19 -14 73 -42 119 -60 189 -76
            423 -110 594 -85 155 23 228 57 378 175 178 140 241 216 336 404 l46 92 38 -6
            c273 -44 347 -60 344 -74 -2 -8 -13 -51 -24 -95 -44 -170 -5 -309 119 -431 75
            -75 174 -127 281 -149 337 -69 1034 16 1883 231 l255 65 45 -25 c131 -73 326
            -110 543 -104 261 9 430 56 759 214 223 108 444 185 662 233 1016 221 2224
            121 2710 -224 309 -219 250 -439 -170 -635 -264 -124 -699 -249 -1173 -336
            l-152 -28 -75 -76 c-137 -137 -190 -233 -183 -331 7 -96 70 -157 211 -205 381
            -130 1000 -50 1667 213 648 256 1081 598 1201 950 35 100 33 250 -3 350 -53
            149 -201 323 -424 504 -935 753 -2510 1100 -3989 879 -71 -10 -166 -26 -210
            -35 -44 -8 -85 -15 -91 -15 -8 0 -5 23 8 68 142 503 244 1100 279 1645 15 234
            6 840 -15 1042 -67 621 -236 1188 -488 1628 -440 772 -1125 1289 -2076 1568
            -146 42 -180 62 -442 260 -177 134 -255 210 -289 282 -90 189 -363 482 -584
            627 -49 33 -93 60 -98 62 -5 2 -26 53 -48 113 -105 298 -219 549 -292 645
            l-42 54 21 141 c26 172 48 339 68 527 21 195 30 643 15 788 -34 350 -156 493
            -359 420z`);
            g.appendChild(path);

            svg.appendChild(g);

        }
    }

    return svg;
}

// function addToSVG()

const CELLSTATE = Object.freeze({
    NONE:-1,
    PLAYER1:0,
    PLAYER2:2
})

function Cell (htmldiv, position) {
    this.div = htmldiv;
    this.position = position;
    this.cellState = CELLSTATE.NONE;

    var that = this;
    this.onclick = null;
    this.div.addEventListener("click", function(e) {
        if(that.cellState == CELLSTATE.NONE) {
            // call onclick callback
            if(that.onclick != null) {
                that.onclick(that.position);
            }
        }
    });

    this.log = function() {
        console.log("element", this.div);
        console.log("position: ", this.position);
    };

    this.hasDrawn = function() {
        return this.cellState != CELLSTATE.NONE;
    };

    this.drawCoin = function(cellState, topPosition = 0) {
        this.cellState = cellState;
        const stoneColor = this.cellState > 0 ? "rgb(201, 36, 36)" : "rgb(54, 107, 227)"; 

        var drawable = document.createElement("div");
        var drawableCoin = createSVGElement(SVGS.COIN, stoneColor);
        // drawable.appendChild(drawableCoin);

        drawableCoin.style.top = topPosition - this.div.offsetTop;
        setTimeout(function() {
            drawableCoin.style.top = "";
        }, 0.4);

        this.div.appendChild( drawableCoin );
    };

    this.reset = function() {
        this.cellState = CELLSTATE.NONE;
        
        // remove drawn svgs
        if(this.div.children.length > 0) {
            this.div.children[0].remove();
        }
    }
}



function VOERGameHandler(cells, dimensions) {
    this.cells = cells;
    this.dimensions = dimensions;

    // register cell click events to this.handleclickevent
    var that = this;
    for(var i = 0; i < this.dimensions[0]; i++) {
        for(var j = 0; j < this.dimensions[1]; j++) {
            this.cells[i][j].onclick = function(pos) {
                that.handleClickEvent(pos);
            };
        }
    }

    this.getCell = function(pos) {
        return this.cells[pos[1]][pos[0]];
    }
    
    this.playerHasWon = false;
    this.player1Turn = true;    
    this.handleClickEvent = function(pos) {
        if(!this.playerHasWon) {
            var droppedStonePos = this.dropStone(pos, this.player1Turn);

            if( this.checkForWin(droppedStonePos) ) {
                this.showWinScreen();
            }

            this.player1Turn = !this.player1Turn;
            this.setWhosTurnText();
        }
    };

    this.dropStone = function(pos, playersTurn) {
        for(var i = this.dimensions[1]-1; i > -1 ; i--) {
            if(!this.cells[pos[1]][i].hasDrawn()) {
                const stoneDroppedTopPosition = this.getCell(pos).div.offsetTop;
                console.log(stoneDroppedTopPosition);
                this.cells[pos[1]][i].drawCoin(playersTurn, stoneDroppedTopPosition);

                // return dropped position in grid
                return [ pos[1],i ];
            }
        }
    };

    this.checkForWin = function(pos) {
        if(this.playerHasWon) {
            return false;
        }

        const CONSC_VALS = 4;
        const stonePlayer = this.cells[pos[0]][pos[1]].cellState;

        this.isPosInGrid = function(position) {
            if(position[0] >= 0 && position[0] < this.dimensions[0] && position[1] >= 0 && position[1] < this.dimensions[1])
                return true;
            return false;
        }

        // all vierOpEenRij win directions
        var increments = [ [1, 0], [0, 1], [1, 1], [1, -1] ];

        // loop through all possible directions for VierOpEenRij
        for(var directions = 0; directions < 4; directions++) {
            const incr = increments[directions];

            // loop through all Cells and count consecutive values
            var cons_count = 0;
            for(var i = -CONSC_VALS; i < CONSC_VALS+1; i++) {

                const newPos = [ Math.round( pos[0] + incr[0] * i ), Math.round( pos[1] + incr[1] * i ) ];
                // console.log(newPos, "is", this.isPosInGrid(newPos), "inside grid ", this.dimensions);        // Print out-of-bounds fields

                if( this.isPosInGrid(newPos) ) {
                    // this.cells[newPos[0]][newPos[1]].div.style.backgroundColor = "#000";                     // Display checked fields
                    if(this.cells[newPos[0]][newPos[1]].cellState == stonePlayer) {
                        cons_count++;
                        if(cons_count == CONSC_VALS) {
                            this.playerHasWon = true;
                            return true;
                        }
                    } else {
                        cons_count = 0;
                    }
                }
            }
        }

        return false;
    };

    this.showWinScreen = function() {
        // set new menu data
        var playername = this.player1Turn ? document.getElementById("playerone").value : document.getElementById("playertwo").value;
        document.getElementById("wintext").innerHTML = playername + " won!";
        document.getElementById("submit").value = "P L A Y   A G A I N";

        // add winscreen class
        document.getElementById("winscreen").classList.add("won");
        var that = this;
        setTimeout(function() {
            that.changeView(false);
            document.getElementById("winscreen").classList.remove("won");
        }, 1400);
    }

    this.changeView = function(showOrHideGame) {
        var voerClasses = document.getElementById("voer").classList;
        var menuClasses = document.getElementById("menu").classList;

        if(showOrHideGame == true) {
            this.setWhosTurnText();
            voerClasses.remove("invisible");
            voerClasses.add("fadein");
            voerClasses.remove("fadeout");
            menuClasses.add("fadeout");
            menuClasses.remove("fadein");
        } else {
            this.setWhosTurnText();
            voerClasses.add("fadeout");
            voerClasses.remove("fadein");
            menuClasses.remove("fadeout"); 
            menuClasses.add("fadein"); 
        }
    }

    this.setWhosTurnText = function() {
        var playername = this.player1Turn ? document.getElementById("playerone").value : document.getElementById("playertwo").value;
        document.getElementById("voer-text").innerHTML = "it's " + playername + "'s turn!";
    }

    this.reset = function() {
        this.playerHasWon = false;
        for(var i = 0; i < this.dimensions[0]; i++) {
            for(var j = 0; j < this.dimensions[1]; j++) {
                this.cells[i][j].reset();
            }
        }
    }
}

function startGame() {
    gameHandler.reset();
    gameHandler.changeView(true);
    window.onresize();
};

var cells = null;
var gameHandler = null;
window.onload = function() {
    cells = [];
    
    // genereer Cellen en voeg deze toe aan de Cells array
    var voerContainer = document.getElementById("voer-game");
    var rowDiv = null;

    for(var i = 0; i < NUMCELLS; i++) {
        if(i % DIMENSIONS[0] == 0) {
            cells[cells.length] = [];
            rowDiv = document.createElement("div");
            voerContainer.appendChild(rowDiv);
        }

        var newCell = document.createElement("div");
        newCell.className = "cell";
        const wPerCell = 91 / DIMENSIONS[0];
        const margin = 4.5 / DIMENSIONS[0];
        newCell.style.setProperty("width", wPerCell + "%");
        newCell.style.setProperty("margin", margin + "%");
        newCell.style.setProperty("height", wPerCell + "%");
        rowDiv.appendChild(newCell);
        
        cells[cells.length-1].push(new Cell(newCell, [ cells.length-1, i % DIMENSIONS[0] ] ));

        // Set height according to width (squares)
        newCell.style.setProperty("height", newCell.offsetWidth);
    }

    var shiftedCells = [];
    for(var i = 0; i < DIMENSIONS[0]; i++) {
        shiftedCells[i] = [];
        for(var j = 0; j < DIMENSIONS[1]; j++) {
            shiftedCells[i][j] = cells[j][i];
        }
    }
    this.cells = shiftedCells;

    gameHandler = new VOERGameHandler(cells, DIMENSIONS);
    document.getElementById("submit").disabled= false;

    window.onresize();
};

window.onresize = function() {
    const newW = cells[0][0].div.offsetWidth;

    for(var i = 0; i < DIMENSIONS[0]; i++) {
        for(var j = 0; j < DIMENSIONS[1]; j++) {
            var cell = cells[i][j].div;
            cell.style.height = newW + "px";
        }
    }
};