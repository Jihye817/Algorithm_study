# 🔥 힙 정렬 구현
n개의 원소가 주어졌을 때, 힙 정렬을 이용해 n개의 숫자를 오름차순으로 정렬하는 프로그램을 작성해보세요.

## ✏️ 코드
```js
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = +input[0].split(" ");
const arr = input[1].split(" ").map(Number);

const heapSort = () => {
  for (let i = Math.floor(n / 2) - 1; i >= 0; i--) {
    heapify(n, i);
  }

  for (let i = n - 1; i > 0; i--) {
    if (arr[0] > arr[i]) {
      let temp = arr[i];
      arr[i] = arr[0];
      arr[0] = temp;
    }
    heapify(i, 0);
  }

  arr.map((item) => process.stdout.write(item + " "));
};

const heapify = (n, i) => {
  let largest = i;
  let left = i * 2 + 1;
  let right = i * 2 + 2;

  if (left < n && arr[left] > arr[largest]) {
    largest = left;
  }
  if (right < n && arr[right] > arr[largest]) {
    largest = right;
  }
  if (largest !== i) {
    let temp = arr[i];
    arr[i] = arr[largest];
    arr[largest] = temp;
    heapify(n, largest);
  }
};

heapSort();
```

## 🌱 설명
- 힙 정렬 구현