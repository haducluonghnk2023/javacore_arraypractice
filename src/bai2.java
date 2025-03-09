import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        System.out.print("Nhập số hàng n: ");
        n = scanner.nextInt();
        System.out.print("Nhập số cột m: ");
        m = scanner.nextInt();
        int[][] array = new int[n][m];
        int choice;
        do {
            printMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Nhập giá trị các phần tử của mảng
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print("array[" + i + "][" + j + "] = ");
                            array[i][j] = scanner.nextInt();
                        }
                    }
                    break;
                case 2:
                    // In giá trị các phần tử trong mảng theo ma trận
                    System.out.println("Mảng 2 chiều:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(array[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    // Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (array[i][j] % 2 == 0 && array[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số lượng phần tử chia hết cho 2 và 3: " + count);
                    break;

                case 4:
                    // In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ
                    int boundarySum = 0;
                    int mainDiagonalSum = 0;
                    int secondaryDiagonalSum = 0;

                    System.out.println("Các phần tử trên đường biên:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                                System.out.print(array[i][j] + " ");
                                boundarySum += array[i][j];
                            }
                        }
                    }
                    System.out.println("\nTổng các phần tử trên đường biên: " + boundarySum);

                    if (n == m) {
                        System.out.println("Các phần tử trên đường chéo chính:");
                        for (int i = 0; i < n; i++) {
                            System.out.print(array[i][i] + " ");
                            mainDiagonalSum += array[i][i];
                        }
                        System.out.println("\nTổng các phần tử trên đường chéo chính: " + mainDiagonalSum);

                        System.out.println("Các phần tử trên đường chéo phụ:");
                        for (int i = 0; i < n; i++) {
                            System.out.print(array[i][n - 1 - i] + " ");
                            secondaryDiagonalSum += array[i][n - 1 - i];
                        }
                        System.out.println("\nTổng các phần tử trên đường chéo phụ: " + secondaryDiagonalSum);
                    } else {
                        System.out.println("Mảng không vuông, không có đường chéo chính và phụ.");
                    }
                    break;
                case 5:
                    // Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n - 1; i++) {
                            int minIndex = i;
                            for (int k = i + 1; k < n; k++) {
                                if (array[k][j] < array[minIndex][j]) {
                                    minIndex = k;
                                }
                            }
                            int temp = array[minIndex][j];
                            array[minIndex][j] = array[i][j];
                            array[i][j] = temp;
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp tăng dần theo cột:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(array[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    // In ra các phần tử là số nguyên tố trong mảng
                    System.out.println("Các số nguyên tố trong mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (isPrime(array[i][j])) {
                                System.out.print(array[i][j] + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 7:
                    // Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính của mảng giảm dần
                    if (n != m) {
                        System.out.println("Mảng không vuông, không thể sắp xếp đường chéo chính.");
                    } else {
                        for (int i = 1; i < n; i++) {
                            int key = array[i][i];
                            int j = i - 1;
                            while (j >= 0 && array[j][j] < key) {
                                array[j + 1][j + 1] = array[j][j];
                                j = j - 1;
                            }
                            array[j + 1][j + 1] = key;
                        }
                        System.out.println("Mảng sau khi sắp xếp đường chéo chính giảm dần:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.print(array[i][j] + "\t");
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 8:
                    // Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, thực hiện chèn vào mảng 2 chiều
                    int[] newRow = new int[m];
                    System.out.print("Nhập chỉ số dòng muốn chèn (từ 0 đến " + n + "): ");
                    int rowIndex = scanner.nextInt();

                    if (rowIndex < 0 || rowIndex > n) {
                        System.out.println("Chỉ số dòng không hợp lệ.");
                    } else {
                        System.out.println("Nhập các phần tử của dòng mới:");
                        for (int i = 0; i < m; i++) {
                            System.out.print("newRow[" + i + "] = ");
                            newRow[i] = scanner.nextInt();
                        }

                        int[][] newArray = new int[n + 1][m];

                        for (int i = 0; i < rowIndex; i++) {
                            newArray[i] = array[i];
                        }

                        newArray[rowIndex] = newRow;

                        for (int i = rowIndex + 1; i < n + 1; i++) {
                            newArray[i] = array[i - 1];
                        }

                        array = newArray;
                        n++; // Cập nhật số hàng

                        System.out.println("Mảng sau khi chèn dòng:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.print(array[i][j] + "\t");
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 9: System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 9);
    }
    public static void printMenu() {
        System.out.println("************************MENU**************************");
        System.out.println("1. Nhập giá trị các phần tử của mảng");
        System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
        System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
        System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ");
        System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng");
        System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
        System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính của mảng giảm dần");
        System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, thực hiện chèn vào mảng 2 chiều");
        System.out.println("9. Thoát");
        System.out.println("******************************************************");
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
