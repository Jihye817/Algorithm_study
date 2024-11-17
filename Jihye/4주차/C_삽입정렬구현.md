# 🔥 삽입 정렬 구현

n개의 원소가 주어졌을 때, 삽입 정렬을 이용해 n개의 숫자를 오름차순으로 정렬하는 프로그램을 작성해보세요.

## ✏️ 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0];
const inputArr = input[1].split(" ").map(Number); //숫자로 변환

function solution(n, inputArr) {
  //삽입정렬 구현
  for (let i = 1; i < inputArr.length; i++) {
    let j = i - 1;
    let key = inputArr[i];
    for (; j >= 0; j--) {
      if (inputArr[j] > key) {
        inputArr[j + 1] = inputArr[j];
        inputArr[j] = key;
      }
    }
  }
  //한줄로 출력
  inputArr.map((item) => process.stdout.write(item + " "));
}

solution(n, inputArr);
```

## 🌱 설명

- 삽입 정렬 구현