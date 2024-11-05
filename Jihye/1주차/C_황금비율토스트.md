# 🔥 Iterator - 황금비율토스트
처음 식빵들의 상태와 레시피 암호 명령어가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성해보세요.

## ✏️ 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0].split(" ")[0]; // 식빵 개수
const m = +input[0].split(" ")[1]; // 암호문 개수
const words = input[1].split(""); // 알파벳목록
const inputTestCase = [];

for(let i=2; i<m+2; i++) {
  inputTestCase.push(input[i]);
}
class Node {
  constructor(data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}

class DoublyLinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  //처음 데이터 넣기
  push(data) {
    const newNode = new Node(data);
    if (this.length === 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      newNode.prev = this.tail;
      this.tail = newNode;
    }
    this.length += 1;
  }

  //빵 넣기 (현재 cursor앞에 넣어야 함)
  insertBread(cursor, data) {
    const newNode = new Node(data);

    if (!cursor) {
      //맨 뒤에 넣는 경우
      if (!this.head) {
        //빈배열인경우
        this.head = newNode;
        this.tail = newNode;
      } else {
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
      }
    } else {
      if (!cursor.prev) {
        //맨 앞에 넣는 경우
        this.head.prev = newNode;
        newNode.next = this.head.next;
        this.head = newNode;
      } else {
        cursor.prev.next = newNode;
        newNode.prev = cursor.prev;
        newNode.next = cursor;
        cursor.prev = newNode;
      }
    }
    this.length += 1;
  }

  //빵 삭제
  deleteBread(cursor) {
    if (!cursor) {
      //맨뒤일때
      return;
    }
    if (cursor.prev) {
      //앞 노드가 있는 경우
      cursor.prev.next = cursor.next;
    } else {
      this.head = cursor.next;
    }

    if (cursor.next) {
      //뒷 노드가 있는 경우
      cursor.next.prev = cursor.prev;
    } else {
      this.tail = cursor.prev;
    }

    this.length -= 1;
  }
}

function solution(n, inputTestCase) {
  const l = new DoublyLinkedList();

  for (let i = 0; i < n; i++) {
    l.push(words[i]);
  }
  let cursor = null;

  for (let i = 0; i < m ; i++) {
    switch (inputTestCase[i].split("")[0]) {
      case "L":
        if (cursor !== l.head) {
          cursor = cursor ? cursor.prev : l.tail;
        }
        break;
      case "R":
        if (cursor !== null) {
          cursor = cursor.next;
        }
        break;
      case "D":
        if (cursor !== null) {
          const removeNode = cursor;
          cursor = cursor.next;
          l.deleteBread(removeNode);
        }
        break;
      case "P":
        l.insertBread(cursor, inputTestCase[i].split("")[2]);
        break;
    }
  }

  cursor = l.head;
  for (let i = 0; i < l.length; i++) {
    process.stdout.write(cursor.data);
    cursor = cursor.next;
  }
}

solution(n, inputTestCase);
```

## 🌱 설명
- 이중 연결 리스트인 `DoublyLinkedList` 클래스 구현
- 각각의 명령에 따라 실행할 함수 구현
- 명령은 `switch`문으로 처리
- 처음에 데이터를 넣기 위헤 `push`함수를 따로 작성
- Iterator로 `cursor`라는 변수 사용.
  - 원래 빵 사이를 가리켜야 하지만 Iterator에서 구현 불가능
  - 따라서 빵을 넣을 때는 cursor가 가리키는 노드 앞에 삽입.
  - 빵을 삭제할 때는 해당 cursor가 가리키는 노드를 삭제하는 방식으로 구현.
- 빵 삽입 함수 구현하는 경우는 다음과 같이 나눠짐
  - 맨 뒤에 넣는 경우
    - 빈 배열일 때
    - 빈 배열이 아닐 때
  - 맨 뒤가 아닌 곳에 넣는 경우
    - 맨 앞에 넣는 경우
    - 맨 앞이 아닌 경우
- 빵 삭제하는 함수 구현하는 경우는 다음과 같이 나눠짐
  - 맨 뒤일때 삭제 X
  - 앞에 노드가 있는 경우 연결 바꾸기
  - 뒤에 노드가 있는 경우 연결 바꾸기