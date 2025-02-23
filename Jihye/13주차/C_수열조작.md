# 🔥 수열 조작
1부터 N까지의 정수가 오름차순으로 정렬되어 있습니다. 이 수열을 정수가 하나만 남을 때까지 다음과 같은 동작을 반복하는 프로그램을 작성하세요.

1. 맨 앞의 정수를 제거합니다.
2. 그 후 남은 수열의 맨 앞의 정수를 맨 뒤로 이동시킵니다.

## ✏️ 코드
```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = Number(fs.readFileSync(filePath).toString().trim());

class Node {
  constructor(data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.count = 0;
    this.head = null;
    this.tail = null;
  }

  pushBack(data) {
    let node = new Node(data);

    if (this.count === 0) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;
    }
    this.count++;
  }

  popFront() {
    let node = this.head;

    if (this.count === 1) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = node.next;
      this.head.prev = null;
    }
    this.count--;
    return node;
  }
}

let queue = new LinkedList();

for (let i = 0; i < input; i++) {
  queue.pushBack(i + 1);
}

while (queue.count > 1) {
  queue.popFront();
  queue.pushBack(queue.popFront().data);
}

console.log(queue.popFront().data);
```

## 🌱 설명
- 연결리스트로 구현
- 뒤쪽에 넣기 / 맨 앞을 빼기 기능만 필요하므로 2개의 함수만 구현함
- `unshift()` 와 `shift()`를 사용하게 되면 시간초과가 일어남