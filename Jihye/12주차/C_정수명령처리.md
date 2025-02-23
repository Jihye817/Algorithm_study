# 🔥 정수 명령 처리
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하세요. 명령어는 총 5가지 입니다.

1. push A: 정수 A를 스택에 넣는 연산입니다. 새로 들어온 정수는 상단부터 차례대로 스택에 쌓입니다.
2. pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력합니다.
3. size: 스택에 들어있는 정수의 개수를 출력합니다.
4. empty: 스택이 비어있으면 1, 아니면 0을 출력합니다.
5. top: 스택의 가장 위에 있는 정수를 출력합니다.

## ✏️ 코드
```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let n = Number(input[0]);

let answer = [];

for (let i = 0; i < n; i++) {
  let prompt = input[i + 1].split(" ");

  switch (prompt[0]) {
    case "push":
      answer.push(Number(prompt[1]));
      break;
    case "size":
      console.log(answer.length);
      break;
    case "pop":
      console.log(answer.pop());
      break;
    case "top":
      console.log(answer[answer.length - 1]);
      break;
    case "empty":
      if (answer.length === 0) {
        console.log(1);
      } else {
        console.log(0);
      }
      break;
  }
}
```

## 🌱 설명
- 배열을 이용하여 스택을 구현
- switch-case 문을 사용하여 각 명령어를 처리