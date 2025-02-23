# 🔥 원형 순열에서의 인원 제거
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K가 주어집니다.

다음의 연산을 N명의 사람들이 모두 제거될때까지 진행합니다.

1. 1번부터 순서대로 K번째 사람을 제거합니다.
2. 한 사람이 제거되면 남은 사람들로 원을 이루며 1번 연산을 과정을 반복합니다.

제거되는 사람의 번호를 순서대로 나열한 순열을 구하는 프로그램을 작성하세요.

## ✏️ 코드
```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split(" ").map(Number);

let queue = [];
let answer = [];

for (let i = 0; i < input[0]; i++) {
  queue.push(i + 1);
}

while (queue.length !== 0) {
  for (let i = 0; i < input[1] - 1; i++) {
    let top = queue.shift();
    queue.push(top);
  }
  answer.push(queue.shift());
}

console.log(answer.join(" "));
```

## 🌱 설명
- 배열을 이용하여 큐를 구현
- for문을 k-1번 돌고 나서 맨 앞 사람을 제거