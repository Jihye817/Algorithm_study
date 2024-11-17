# 🔥 기수 정렬 구현

n개의 원소가 주어졌을 때, 기수 정렬을 이용해 n개의 숫자를 오름차순으로 정렬하는 프로그램을 작성해보세요.

## ✏️ 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0];
const inputArr = input[1].split(" ").map(Number); //숫자로 받아오기

function solution(n, inputArr) {
  //최댓값 자릿수 구하기
  function getMaxDigit(arr) {
    let max = Math.max(...arr);
    if (max < 10) {
      return 1;
    } else {
      return max.toString().split("").length;
    }
  }

  //숫자별 자릿수의 숫자 반환
  function getDigit(num, pos) {
    //Math.pow()는 거듭제곱을 해주는 함수. Math.pow(제곱할 수, 거듭제곱횟수) 로 사용
    return Math.floor(num / Math.pow(10, pos)) % 10;
  }

  let maxNum = getMaxDigit(inputArr); //최댓값 자릿수

  for (let i = 0; i < maxNum; i++) {
    let doubleArr = Array.from({ length: 10 }, () => []); //2차원 배열
    for (let j = 0; j < inputArr.length; j++) {
      let digit = getDigit(inputArr[j], i);
      doubleArr[digit].push(inputArr[j]); //숫자에 해당하는 곳에 넣기
    }
    inputArr = [].concat(...doubleArr); //2차원 배열을 다시 1차원 배열로 만들기
  }
  //한줄로 출력
  inputArr.map((item) => process.stdout.write(item + " "));
}

solution(n, inputArr);
```

## 🌱 설명

### Array.from

> 배열을 생성해 주는 함수

```
Array.from(배열로 만들 유사 배열 객체, 모든 원소에 대해 수행하는 map 함수(선택사항)
```

따라서 Array.from({length:10}, () => []) 을 하면, length 속성이 10인 유사 배열 객체를 받았기 때문에
길이가 10인 이차원 배열이 생성되게 된다.

### 배열 합치기

> concat과 스프레드 연산자를 사용

```js
let newArray = [].concat(...array);
```
가장 간편하게 사용할 수 있다.

---

> reduce 함수와 concat 사용

```js
let newArray = array.reduce(function (prev, next) {
  return prev.concat(next);
});
```

---

> flat 사용
```js
let newArray = array.flat();
```
flat을 사용하면 느리다.
