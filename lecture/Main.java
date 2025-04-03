package lecture;

public class Main {

  // 10진수로 표현했을 때, nth 자리를 기준으로 정렬한다.
  static void countingSort(int[] a, int nth) {
    int[] count = new int[256]; // 256개의 count가 필요함.
    for (int value : a) {
      int digit =  value >> (nth * 8) & 0xFF; // 256진수 nth 자리의 값을 구함
      ++count[digit]; // digit 값 count 증가
    }
    // nth 자리의 값을 기준으로 정렬 했을 때, 각 값의 시작 위치 계산
    int[] index = new int[256]; // 시작 위치 배열
    index[0] = 0;
    for (int i = 1; i < index.length; ++i)
      index[i] = index[i - 1] + count[i - 1];

    // 위에서 계산한 시작 위치를 사용하여 값들을 temp 배열에 복사함. 즉 정렬함.
    int[] temp = new int[a.length];
    for (int value : a) {
      int digit =  value >> (nth * 8) & 0xFF; // 256진수 nth 자리의 값을 구함
      temp[index[digit]++] = value;
    }

    // 정렬된 temp 배열의 값을 입력 배열에 복사
    for (int i = 0; i < a.length; ++i)
      a[i] = temp[i];
  }

  static void radixSort(int[] a) {
    // 32bit이므로, 256진수 4자리
    for (int i = 0; i < 4; ++i)
      countingSort(a, i);
  }

  static int[] generateRandomArray(int size) {
    int[] a = new int[size];
    for (int i = 0; i < size; ++i)
      a[i] = (int)(Math.random() * Integer.MAX_VALUE);
    return a;
  }

  public static void main(String[] args) {
    int[] a = generateRandomArray(400);
    radixSort(a);
    for (int value : a)
      System.out.println(value);
  }
}