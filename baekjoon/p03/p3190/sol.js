class Location {
    constructor(y, x) {
        this.y = y;
        this.x = x;
    }

    equals(obj) {
        if (!(obj instanceof Location)) return false;
        return obj.y === this.y && obj.x === this.x;
    }

    hashCode() {
        return `${this.y},${this.x}`;
    }
}

class Board {
    constructor(size) {
        this.size = size;
        this.apples = new Set();
    }

    addApple(y, x) {
        this.apples.add(new Location(y, x).hashCode());
    }

    hasApple(location) {
        return this.apples.has(location.hashCode());
    }

    removeApple(location) {
        this.apples.delete(location.hashCode());
    }

    isCollision(location) {
        return location.y < 1 || location.y > this.size || location.x < 1 || location.x > this.size;
    }
}

class Snake {
    constructor() {
        this.body = [];
        this.vx = 1;
        this.vy = 0;
        this.body.push(new Location(1, 1));
    }

    getNextHeadLocation() {
        const head = this.body[0];
        return new Location(head.y + this.vy, head.x + this.vx);
    }

    moveHead(location) {
        this.body.unshift(location);
    }

    moveTail() {
        this.body.pop();
    }

    isCollision(location) {
        return this.body.some(part => part.equals(location));
    }

    turn(direction) {
        if (this.vy === -1) {
            this.vy = 0;
            this.vx = direction === 'L' ? -1 : 1;
        } else if (this.vy === 1) {
            this.vy = 0;
            this.vx = direction === 'L' ? 1 : -1;
        } else if (this.vx === -1) {
            this.vx = 0;
            this.vy = direction === 'L' ? 1 : -1;
        } else if (this.vx === 1) {
            this.vx = 0;
            this.vy = direction === 'L' ? -1 : 1;
        }
    }
}

function move(snake, board) {
    const newLocation = snake.getNextHeadLocation();
    if (board.isCollision(newLocation)) return false;
    if (snake.isCollision(newLocation)) return false;
    snake.moveHead(newLocation);
    if (board.hasApple(newLocation)) {
        board.removeApple(newLocation);
    } else {
        snake.moveTail();
    }
    return true;
}

function play(board, turnCommands) {
    const snake = new Snake();
    let time = 1;
    while (move(snake, board)) {
        const direction = turnCommands[time];
        if (direction) snake.turn(direction);
        time++;
    }
    return time;
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const input = [];
rl.on('line', line => {
    input.push(line);
}).on('close', () => {
    const N = parseInt(input[0]);
    const board = new Board(N);

    const appleCount = parseInt(input[1]);
    for (let i = 0; i < appleCount; i++) {
        const [y, x] = input[2 + i].split(' ').map(Number);
        board.addApple(y, x);
    }

    const turnCount = parseInt(input[2 + appleCount]);
    const turnCommands = {};
    for (let i = 0; i < turnCount; i++) {
        const [time, direction] = input[3 + appleCount + i].split(' ');
        turnCommands[parseInt(time)] = direction;
    }

    const time = play(board, turnCommands);
    console.log(time);
});
