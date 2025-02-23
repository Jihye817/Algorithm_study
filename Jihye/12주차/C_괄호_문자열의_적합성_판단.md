# 🔥 괄호 문자열의 적합성 판단
괄호 문자열은 두 개의 괄호 기호인 "("과 ")" 만으로 구성되어 있는 문자열입니다. 입력으로 주어진 괄호 문자열이 올바른지, 그렇지 못한지를 판단하여 결과를 출력하는 프로그램을 작성하세요.

## ✏️ 코드
```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("");

let stack = [];

for (let i = 0; i < input.length; i++) {
  if (input[i] === "(") {
    stack.push(input[i]);
  } else {
    if (stack.length === 0) {
      console.log("No");
      return;
    } else {
      stack.pop();
    }
  }
}

if (stack.length === 0) {
  console.log("Yes");
} else {
  console.log("No");
}
```

## 🌱 설명
- 배열을 이용하여 스택을 구현
- 스택이 비어있을 때만 괄호가 올바르다