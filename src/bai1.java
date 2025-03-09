import java.util.Scanner;

public class bai1 {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] arr = new int[n];
        do{
            System.out.println("1.Nhap giá trị n phần tử phần tử của mảng.");
            System.out.println("2.In ra giá trị của mảng.");
            System.out.println("3.Tính trung bình các phần tử dương trong mảng.");
            System.out.println("4.In ra vị trí các phần tử có giá trị bằng k trong mảng.");
            System.out.println("5.Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6.Tính số lượng các phần tử là số nguyên tố trong mảng.");
            System.out.println("7.Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng" +
                    " theo thứ tự tăng dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự" +
                    " giảm dần, các phần tử còn lại ở giữa mảng theo thứ tự tăng dần ");
            System.out.println("8.Nhập vào giá trị m từ bàn phím,chèn giá trị m vào mảng(sắp xếp giảm dần) đúng vị trí.");
            System.out.println("9.Thoát.");
            int choice = Integer.parseInt(sc.nextLine());
            int count;
            int[] newArr;
            switch(choice){
                case 1:
                    System.out.println("Nhập số lượng phần tử trong mảng :");
                    n = Integer.parseInt(sc.nextLine());
                    arr = new int[n];
                    for ( int i = 0; i < n; i++){
                        System.out.printf("Nhập arr[%d]: ",i);
                        arr[i] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Mảng hiện tại: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    int sum = 0;
                    count = 0;
                    for ( int i = 0; i < n; i++){
                        if(arr[i] > 0){
                            sum += arr[i];
                            count++;
                        }
                    }
                    if (count > 0) {
                        System.out.println("Trung bình các số dương: " + (double) sum / count);
                    } else {
                        System.out.println("Không có số dương trong mảng.");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Nhập giá trị cần tìm :");
                    int value =  Integer.parseInt(sc.nextLine());
                    System.out.println("Vị trí của giá trị trong mảng :");
                    boolean found = false;
                    for ( int i = 0; i < n; i++){
                        if(arr[i] == value){
                            System.out.print(i + " ");
                            found = true;
                        }
                    }
                    if (!found) System.out.print("Không tìm thấy.");
                    System.out.println();
                    break;
                case 5:
                    for ( int i = 0; i < n-1; i++){
                        for ( int j = 0; j < n-i-1; j++){
                            if(arr[j] < arr[j+1]){
                                int temp = arr[j];
                                arr[j] = arr[j+1];
                                arr[j+1] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp giảm dần.");
                    for ( int i = 0; i < n; i++){
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 6:
                    count = 0;
                    for ( int i = 0; i < n; i++){
                        if(isPrime(arr[i])){
                            count++;
                        }
                    }
                    System.out.println("Số lượng số nguyên tố trong mảng: " + count);
                    System.out.println();
                    break;
                case 7:
                    if (n == 0) {
                        System.out.println("Array is empty.");
                        break;
                    }
                    int[] evenDivisibleBy3 = new int[n];
                    int[] oddDivisibleBy3 = new int[n];
                    int[] others = new int[n];
                    int evenCount = 0, oddCount = 0, otherCount = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            evenDivisibleBy3[evenCount++] = arr[i];
                        } else if (arr[i] % 2 != 0 && arr[i] % 3 == 0) {
                            oddDivisibleBy3[oddCount++] = arr[i];
                        } else {
                            others[otherCount++] = arr[i];
                        }
                    }
                    for (int i = 0; i < evenCount - 1; i++) {
                        for (int j = 0; j < evenCount - i - 1; j++) {
                            if (evenDivisibleBy3[j] > evenDivisibleBy3[j + 1]) {
                                int temp = evenDivisibleBy3[j];
                                evenDivisibleBy3[j] = evenDivisibleBy3[j + 1];
                                evenDivisibleBy3[j + 1] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < oddCount - 1; i++) {
                        for (int j = 0; j < oddCount - i - 1; j++) {
                            if (oddDivisibleBy3[j] < oddDivisibleBy3[j + 1]) {
                                int temp = oddDivisibleBy3[j];
                                oddDivisibleBy3[j] = oddDivisibleBy3[j + 1];
                                oddDivisibleBy3[j + 1] = temp;
                            }
                        }
                    }
                    newArr = new int[n];
                    int index = 0;
                    for (int i = 0; i < evenCount; i++) newArr[index++] = evenDivisibleBy3[i];
                    for (int i = 0; i < otherCount; i++) newArr[index++] = others[i];
                    for (int i = 0; i < oddCount; i++) newArr[index++] = oddDivisibleBy3[i];
                    System.out.println("Sorted array:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(newArr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Nhập giá trị cần chèn:");
                    int m = Integer.parseInt(sc.nextLine());
                    newArr = new int[n + 1];
                    int i = 0, j = 0;
                    boolean inserted = false;
                    while (i < n) {
                        if (!inserted && arr[i] < m) {
                            newArr[j++] = m;
                            inserted = true;
                        } else {
                            newArr[j++] = arr[i++];
                        }
                    }
                    if (!inserted) {
                        newArr[j] = m;
                    }
                    arr = newArr;
                    n++;
                    System.out.println("Mảng sau khi chèn (giảm dần):");
                    for (int num : arr) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-9 :");
            }
        }while(true);
    }
}
