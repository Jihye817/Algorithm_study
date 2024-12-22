# 🔥 병합 정렬 구현

n개의 원소가 주어졌을 때, 병합 정렬을 이용해 n개의 숫자를 오름차순으로 정렬하는 프로그램을 작성해보세요.

## ✏️ 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0];
const inputArr = input[1].split(" ").map(Number); //숫자로 받아오기

function solution(n, inputArr) {
  function mergeSort(inputArr, low, high) {
    //반으로 나눠주는 재귀함수
    if (low < high) {
      let mid = Math.floor((low + high) / 2);
      mergeSort(inputArr, low, mid);
      mergeSort(inputArr, mid + 1, high);
      merge(inputArr, low, mid, high);
    }
  }

  function merge(inputArr, low, mid, high) {
    //합치기 함수
    let i = low;
    let j = mid + 1;
    let k = low;
    let mergedArr = [];
    while (i <= mid && j <= high) {
      //두 배열 다 데이터가 있는 경우
      if (inputArr[i] <= inputArr[j]) {
        mergedArr[k] = inputArr[i];
        i++;
        k++;
      } else {
        mergedArr[k] = inputArr[j];
        j++;
        k++;
      }
    }
    while (i <= mid) {
      //앞 배열에 데이터 남은 경우
      mergedArr[k] = inputArr[i];
      i++;
      k++;
    }
    while (j <= high) {
      //뒷 배열에 데이터 남은 경우
      mergedArr[k] = inputArr[j];
      j++;
      k++;
    }

    for (let i = low; i <= high; i++) {
      inputArr[i] = mergedArr[i];
    }
    return inputArr;
  }

  let low = 0;
  let high = n - 1;
  mergeSort(inputArr, low, high);

  inputArr.map((item) => {process.stdout.write(item + " ")});
}

solution(n, inputArr);
```

## 🌱 설명

- 병합 정렬 구현