
import util.OwnMatrix;
import util.SwingUtils;

import java.util.*;

import Jama.*;

class Program {

    public static double findDeterminant(double[][] arr) {
        if (arr.length == 2) {
            return ((double) arr[0][0] * arr[1][1] - (double) arr[1][0] * arr[0][1]);
        }
        double count = 0;
        for (int i = 0; i < arr.length; i++) { // перебираем числа столбика
            double[][] helpMatrix = new double[arr.length - 1][arr.length - 1];
            double number = arr[i][0];
            int row = 0, col = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    for (int z = 1; z < arr[0].length; z++) {
                        helpMatrix[row][col] = arr[j][z]; // заполняем вспомогательную матрицу
                        col++;
                    }
                    row++;
                    col = 0;
                }
            }
            count += (double) (number * Math.pow(-1, i + 2) * findDeterminant(helpMatrix));
        }
        return count;
    }

    public static double findDeterminant2(double[][] matrix) {
        if (matrix[0][0] == 0.0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] != 0.0) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        double n = matrix[i - 1][j];
                        matrix[i - 1][j] = matrix[i][j];
                        matrix[i][j] = n;
                    }
                    break;
                }
            }
        }
        double[][] rez = copy(matrix);
        int r = 1, c = 0, index = 0;
        double constanta = 0;
        for (int z = 1; z < matrix.length; z++) {
            for (int i = r; i < matrix.length; i++) {
                for (int j = c; j < matrix[0].length; j++) {
                    if (j == c & matrix[i][j] != 0) {
                        constanta = (-matrix[i][j]) / matrix[index][j];
                    }
                    rez[i][j] = matrix[i][j] + constanta * matrix[index][j];
                }
            }
            r++;
            c++;
            index++;
            matrix = copy(rez);
        }

        double n = 1;
        for (int i = 0; i < matrix.length; i++) {
            n *= matrix[i][i];
        }
        return n;
    }

    public static double[] matrixNewKramer(double[][] matrix) {
        double[] variable = new double[matrix.length + 1];
        for (int n = -1; n < matrix.length; n++) {
            double[][] helpMatrix = new double[matrix.length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (i == n) {
                        helpMatrix[j][i] = matrix[j][matrix.length];
                    } else {
                        helpMatrix[j][i] = matrix[j][i];
                    }
                }
            }
            variable[n + 1] = findDeterminant(helpMatrix);
        }
        if (variable[0] == 0) {
            return new double[1];
        }
        for (int i = 1; i < variable.length; i++) {
            variable[i] = variable[i] / variable[0];
        }
        return variable;

    }

    public static double[][] matrixMulti(double[][] matrix, double[][] matrix2) {
        double[][] matrixNew = new double[matrix.length][matrix.length];
        double rez = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int z = 0; z < matrix2[0].length; z++) {
                rez = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    rez += matrix[i][j] * matrix2[j][z];
                    // добавляю переменную
                }
                matrixNew[i][z] = rez;
                // добавить
            }
        }
        return matrixNew;
    }

    public static double attachedMatrix(double[][] matrix, int i, int j) {
        double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];
        int row = 0, col = 0;
        for (int r = 0; r < matrix.length; r++) {
            if (r != i) {
                for (int c = 0; c < matrix.length; c++) {
                    if (c != j) {
                        newMatrix[row][col] = matrix[r][c];
                        col++;
                    }
                }
                row++;
                col = 0;
            }
        }
        return (double) (Math.pow(-1, i + j + 2) * findDeterminant(newMatrix));
    }


    public static double[][] reverseMatrix(double[][] matrix) {
        double[][] clone = new double[matrix.length][matrix[0].length];
        double determinant = findDeterminant(matrix);
        double[][] matrixNew = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixNew[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                clone[i][j] = ((1 / determinant) * (attachedMatrix(matrixNew, i, j)));
            }
        }
        return clone;
    }

    public static double[] methodReverse(double[][] matrix) {
        double[] rez = new double[matrix.length];
        double[][] matrixA = new double[matrix.length][matrix[0].length - 1];
        double[] matrixB = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == matrix[0].length - 1) {
                    matrixB[i] = matrix[i][j];
                } else {
                    matrixA[i][j] = matrix[i][j];
                }
            }
        }
        matrixA = reverseMatrix(matrixA);
        for (int i = 0; i < matrixA.length; i++) {
            double count = 0;
            for (int j = 0; j < matrixA[0].length; j++) {
                count += matrixA[i][j] * matrixB[j];
            }
            rez[i] = count;
        }
        return rez;
    }

    public static double[][] copy(double[][] m) {
        double[][] rez = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                rez[i][j] = m[i][j];
            }
        }
        return rez;
    }

    public static int checkExistResults(double[][] array) { // проверяем на наличиее нулевых строк(сущ ли решение в числах)
        int count = 0;
        boolean flag;
        for (int i = 0; i < array.length; i++) {
            flag = true;
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }


    public static double[][] methodGaussa(double[][] matrix) {
        if (matrix[0][0] == 0.0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] != 0.0) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        double n = matrix[i - 1][j];
                        matrix[i - 1][j] = matrix[i][j];
                        matrix[i][j] = n;
                    }
                    break;
                }
            }
        }
        double[][] rez = copy(matrix);
        int r = 1, c = 0, index = 0; // c - в каком столбце искать константу, r - с какой строки идти
        double constanta = 0.0;
        for (int z = 1; z < matrix.length; z++) { // z идти со второй строки
            for (int i = r; i < matrix.length; i++) {
                for (int j = c; j < matrix[0].length; j++) {
                    if (matrix[index][j] != 0) {
                        if (j == c) {
                            constanta = (-matrix[i][j]) / matrix[index][j];
                            System.out.printf("");

                        }
                        rez[i][j] = matrix[i][j] + constanta * matrix[index][j];
                        System.out.printf("");
                    }
                }
            }
            r++;
            c++;
            index++;
            matrix = copy(rez);
        }
        int zerostrock = checkExistResults(rez);
        if (zerostrock == 0) { // если у всех х есть решение
            int count = matrix.length - 1;
            double[][] answer = new double[2][count + 1]; // список со значениями иксов
            for (int i = matrix.length - 1; i >= 0; i--) {
                double n = matrix[i][count]; // коэ-нт перед числом
                double result = matrix[i][matrix[0].length - 1]; // значение последнего столбца (ответ)
                for (int j = count + 1; j < matrix[0].length - 1; j++) { // идти с count до конца и умножать значения из answer и элемента
                    result -= matrix[i][j] * answer[0][j];
                }
                answer[0][count] = (n == 0) ? 0 : result / n;
                count--;
            }

            return answer;
        }
        return solutionToUnknow(rez, zerostrock);
    }

    public static List<OwnMatrix> ownVectors(double[][] array) {
        List<OwnMatrix> result = new ArrayList<>();
        Matrix A = new Matrix(array);
        //System.out.println("matrix: " + Arrays.deepToString(A.getArray()));

        EigenvalueDecomposition el = new EigenvalueDecomposition(A); // создаю класс библиотеки для работы с собств. знач.

        double[] real = el.getRealEigenvalues(); // получаю из библиотеки собств. знач.
        long[] lambda = new long[real.length]; // список собств. знач. (если в примере значения не целые, заменить на double)

        System.out.println("real - целые");
        for (int i = 0; i < real.length; i++) {
            lambda[i] = Math.round(real[i]); // привожу к целым
        }
        double[][] arrayProm;
        for (int i = 0; i < real.length; i++) { // перебираю значения лямбды
            arrayProm = new double[array.length][array[0].length + 1];
            for (int j = 0; j < array.length; j++) { // заполняю промежуточный список значениями массива, только из главной диагонали вычитаю лямбду
                for (int z = 0; z < array[0].length; z++) {
                    if (j == z) {
                        arrayProm[j][z] = array[j][z] - lambda[i];
                    } else {
                        arrayProm[j][z] = array[j][z];
                    }
                }
            }
            System.out.println();
            result.add(new OwnMatrix(lambda[i], methodGaussa(arrayProm.clone())));
        }
        return result;
    }

    public static double[][] solutionToUnknow(double[][] array, int zerostrock) {
        int[][] mas = new int[zerostrock][zerostrock];
        int z = -1;
        for (int i = 0; i < zerostrock; i++) { // заполняем значениями 0 и 1 неизвестные х1...хn, получим массив [0, 1], [1, 0]
            z++;
            for (int j = 0; j < zerostrock; j++) {
                if (j == z) {
                    mas[i][j] = 1;
                } else {
                    mas[i][j] = 0;
                }
            }
        }

        double[][] answerResult = new double[mas.length][array[0].length - 1];
        for (int i = 0; i < mas.length; i++) { // ЦИКЛ ДЛЯ СМЕНЫ ЗНАЧЕНИЙ ЭЛЕМЕНТОВ
            double[] answer = new double[array[0].length - 1];
            int index = mas[0].length - 1; // для переноса значений матрицы mas в ответы
            for (int k = array[0].length - 2; k >= array.length - mas.length; k--) { // заносим последние значения в матрицу ответов
                answer[k] = mas[i][index];
                index--;
            }
            int count = array.length - zerostrock - 1; // для последней строки вычисляем индекс крайне правого аргуменнты
            for (int ii = array.length - zerostrock - 1; ii >= 0; ii--) {
                double n = array[ii][count]; //коэф-т перед элементов, который ищем
                double result = 0; // значение последнего столбца (ответ)
                for (int j = count + 1; j < array[0].length - 1; j++) { // идти с count до конца и умножать значения из answer и элемента
                    result -= array[ii][j] * answer[j];
                }
                answer[count] = (n == 0) ? 0 : result / n;
                count--; // в строке выше элемент находится левее
            }
            answerResult[i] = answer;
        }
        return answerResult;
    }


    public static void main(String[] args) throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    /*public static double[][] solutionToUnknow(double[][] array, int emptyLines) {
        int[][] mas = new int[emptyLines][emptyLines];
        int z = -1;
        for (int i = 0; i < emptyLines; i++) { // заполняем значениями 0 и 1 неизвестные х1...хn, получим массив [0, 1], [1, 0]
            z++;
            for (int j = 0; j < emptyLines; j++) {
                if (j == z) {
                    mas[i][j] = 1;
                } else {
                    mas[i][j] = 0;
                }
            }
        }

        double[][] answerMas = new double[mas.length * 2][array[0].length - 1];

        double[][] answerResult = new double[mas.length][array[0].length - 1];
        for (int i = 0; i < mas.length; i++) { // ЦИКЛ ДЛЯ СМЕНЫ ЗНАЧЕНИЙ ЭЛЕМЕНТОВ
            double[] answer = new double[array[0].length - 1];
            int index = mas[0].length - 1; // для переноса значений матрицы mas в ответы
            for (int k = array[0].length - 2; k >= array.length - mas.length; k--) { // заносим последние значения в матрицу ответов
                answer[k] = mas[i][index];
                index--;
            }
            int count = array.length - emptyLines - 1; // для последней строки вычисляем индекс крайне правого аргуменнты
            for (int ii = array.length - emptyLines - 1; ii >= 0; ii--) {
                double n = array[ii][count]; //коэф-т перед элементов, который ищем
                double result = 0; // значение последнего столбца (ответ)
                for (int j = count + 1; j < array[0].length - 1; j++) { // идти с count до конца и умножать значения из answer и элемента
                    result -= array[ii][j] * answer[j];
                }
                answer[count] = (n == 0) ? 0 : result / n;
                count--; // в строке выше элемент находится левее
            }
            answerResult[i] = answer;
        }

        double[][] answerResult2 = new double[mas.length][array[0].length - 1];
        for (int i = 0; i < mas.length; i++) { // ЦИКЛ ДЛЯ СМЕНЫ ЗНАЧЕНИЙ ЭЛЕМЕНТОВ
            double[] answer2 = new double[array[0].length - 1];
            int index = mas[0].length - 1; // для переноса значений матрицы mas в ответы
            for (int k = array[0].length - 2; k >= array.length - mas.length; k--) { // заносим последние значения в матрицу ответов
                answer2[k] = mas[i][index];
                index--;
            }
            int count = array.length - emptyLines - 1; // для последней строки вычисляем индекс крайне правого аргуменнты
            for (int ii = array.length - emptyLines - 1; ii >= 0; ii--) {
                double n = array[ii][count]; //коэф-т перед элементов, который ищем
                double result = array[ii][array[0].length - 1]; // значение последнего столбца (ответ)
                for (int j = count + 1; j < array[0].length - 1; j++) { // идти с count до конца и умножать значения из answer и элемента
                    result -= array[ii][j] * answer2[j];
                }
                answer2[count] = (n == 0) ? 0 : result / n;
                count--; // в строке выше элемент находится левее
            }
            answerResult2[i] = answer2;
        }

        int index = 0;
        for (double[] i : answerResult) {
            answerMas[index] = i;
            index++;
        }
        for (double[] i : answerResult2) {
            answerMas[index] = i;
            index++;
        }
        return answerMas;
    }*/
}