# 🔥 병합 정렬 구현

n개의 원소가 주어졌을 때, 퀵 정렬을 이용해 n개의 숫자를 오름차순으로 정렬하는 프로그램을 작성해보세요.

## ✏️ 코드

```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0];
const inputArr = input[1].split(" ").map(Number);

function solution(n, inputArr) {
  function selectPivot(arr) {
    if (arr.length > 2) {
      let low = arr[0];
      let high = arr[arr.length - 1];
      let mid = arr[Math.floor(arr.length / 2) - 1];
      let pivotArray = [low, high, mid].sort();

      return pivotArray.indexOf(pivotArray[1]);
    } else {
      return 0;
    }
  }

  function quickSort(arr) {
    let pivotIndex = selectPivot(arr);
    let leftArr = [];
    let rightArr = [];
    
    if (arr.length <= 1) {
      return arr;
    } else {
      for (let i = 0; i < arr.length; i++) {
        if (i == pivotIndex) {
          continue;
        }
        if (arr[i] <= arr[pivotIndex]) {
          leftArr.push(arr[i]);
        } else {
          rightArr.push(arr[i]);
        }
      }

      let left = quickSort(leftArr);
      let right = quickSort(rightArr);

      inputArr = [...left, arr[pivotIndex], ...right]

      return inputArr;
    }
  }

  quickSort(inputArr);
  inputArr.map((item) => {
    process.stdout.write(item + " ");
  });
}

solution(n, inputArr);
```

## 🌱 설명

- 퀵 정렬 구현
- pivot은 배열의 길이가 2 이하면 첫번째 값, 배열의 길이가 3 이상이면 첫번째, 가운데, 마지막 중 가운데 값으로 지정
- for문을 돌려서 pivot보다 작으면 왼쪽, 크면 오른쪽으로 가도록 구현
- for문에서 i가 pivot의 인덱스와 같으면 건너뛰도록 `continue` 사용