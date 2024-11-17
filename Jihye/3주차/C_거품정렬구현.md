# 🔥 거품 정렬 구현

n개의 원소가 주어졌을 때, 버블 정렬을 이용해 n개의 숫자를 오름차순으로 정렬하는 프로그램을 작성해보세요.

## ✏️ 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0];
const inputTestCase = input[1].split(" ");
let sorted = false;

function solution(n, inputTestCase) {
  for (;;) {
    //무한반복
    sorted = true;
    for (let i = 0; i < n - 1; i++) {
      if (+inputTestCase[i] > +inputTestCase[i + 1]) {
        //number로 만들어줘야 함
        let temp = inputTestCase[i];
        inputTestCase[i] = inputTestCase[i + 1];
        inputTestCase[i + 1] = temp;
        sorted = false;
      }
    }
    if (sorted) {
      //sorted가 true일때 빠져나오기
      break;
    }
  }

  for (let i = 0; i < n; i++) {
    process.stdout.write(inputTestCase[i] + " "); //한줄 출력
  }
}

solution(n, inputTestCase);
```

## 🌱 설명

- 이중 for문을 사용하여 구현
- sorted 변수를 등록하여 정렬이 다 된경우 끝까지 돌지 않고 빠져나오도록 함
- 그냥 정렬하면 string 순서로 정렬하기 때문에 `+`를 사용하여 number로 바꾸어 주어야 함
