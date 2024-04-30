# Java-Learn

------------------------------------------------------------------------

[![last commit](https://img.shields.io/github/last-commit/Coconut-Aero/JavaLearn)](https://github.com/Coconut-Aero/JavaLearn/commits/master)
[![Static Badge](https://img.shields.io/badge/Coconut-Aero-blue)](https://github.com/Coconut-Aero)


_Updated 2024-04-25 19:30 CST_

A Java Repository for learning purpose of Coconut-Aero


[![OrelaV](https://i2.hdslb.com/bfs/face/d812a48f1ca84d4f60a112dc31ba65546a787a76.jpg@240w_240h_1c_1s_!web-avatar-space-header.avif "@OrelaV")](https://space.bilibili.com/3546375738361934)

关注[OrelaV](https://space.bilibili.com/3546375738361934)谢谢喵

## 特别注意
您可以自由地使用本仓库，除非您违反 GNU Public License v3.0 协议中的相关内容。
您可以修改本仓库中的代码，但您保证修改后的代码按照与本仓库类似的方式进行开源。

## 特别声明 
我们不允许任何人将此仓库内容上传到诸如Gitee等存在闭源人工审核等机制的仓库内。

## 相关信息

BooleanWrapper.java 提供可以在方法内部修改并传递到方法外的boolean类型 BooleanWrapper

可以调用的方法：

| 来源                      |     类型     | 用法                                                                   |
|-------------------------|:----------:|----------------------------------------------------------------------|
| arrayTest.java          |    void    | printArr(int[] arr,int size)                                         |
| quadSolve.java          |    int     | solveQuadratic(double[] eqn, BooleanWrapper haveRoot, double[] root) |
| sorted.java             |  boolean   | IsSorted(int[] list)                                                 |
| mergeArray.java         |   int[]    | merge(int[] list1,int[] list2)                                       |
| sorted.java             |   int[]    | Sort(int[] res)                                                      |
| eightQueens.java        |    void    | eightQueenBool2DArrayPrint(boolean[][] arr)                          |
| eightQueens.java        |    void    | solveEightQueens(boolean[][] board, int row)                         |
| eightQueens.java        |  boolean   | eightQueenValid(boolean[][] arr,int row, int col)                    |
| enhancedRandom.java     |    int     | getRandom(int start, int end, int... numbers)                        |
| galtonBoard.java        |  boolean   | BooleanRandom()                                                      |
| sumColumnTest.java      |   double   | sumColumn(double[][] m, int columnIndex)                             |
| addMatrixTest.java      | double[][] | addMatrix(double[][] matrix1, double[][] matrix2)                    |
| maxRowCol.java          |    int     | findMax(int[] matrix)                                                |
| multiplyMatrixTest.java | double[][] | multiplyMatrix(double[][] matrix1, double[][] matrix2)               |
| SRPGame.java            |    void    | SRPGamePlay(int player, int computer)                                |


包含：

| 序号 | 文件名                     | 描述                                 | 备注   |
|----|-------------------------|------------------------------------|------|
| 1  | test.java               | Hello World                        | 作业   |
| 2  | time.java               | 输出系统的UNIX时间戳指向的日期（已经完善）            | 作业   |
| 3  | sumDigit.java           | 一个0~1000的数字各位的和                    | 作业   |
| 4  | triangleArea.java       | 输入三个点的坐标，输出它们构成的三角形的面积（海伦公式）       | 作业   |
| 5  | daysInMonth.java        | 某年某月所包含的天数                         | 作业   |
| 6  | SRPGame.java            | 剪刀石头布游戏                            | 作业   |
| 7  | SRPGameWin2.java        | 人胜利两次自动终止循环的变种                     | 作业   |
| 8  | numberPyramid.java      | 数字金字塔，2的幂                          | 作业   |
| 9  | cityOrder.java          | 把城市按字母顺序排序                         | 4.24 |
| 10 | estimatePI.java         | 计算圆周率                              | 6.14 |
| 11 | arrayTest.java          | 输入一个数组，将其变换后输出                     | 作业   |
| 12 | enhancedRandom.java     | 增强的random，可以选择范围，排除一些不想要的数字        | 作业   |
| 13 | intSum.java             | 命令行参数计算多个数字的和                      | 作业   |
| 14 | hangman.java            | 猜单词的小游戏                            | 7.35 |
| 15 | quadSolve.java          | 解一元二次方程，方法可以调用                     | 7.25 |
| 16 | sorted.java             | 检查数组是否按从小到大排序了                     | 7.19 |
| 17 | lockerPuzzle.java       | 储物柜难题                              | 7.23 |
| 18 | mergeArray.java         | 合并两个有序列表                           | 7.31 |
| 19 | eightQueens.java        | 八皇后难题                              | 7.36 |
| 20 | repeatedInArray.java    | 计算数字的出现次数                          | 7.3  |
| 21 | galtonBoard.java        | 高尔顿瓶问题                             | 7.37 |
| 22 | numberSingleDigit.java  | 由100个个位数组成的数组中各个数字出现的次数统计          | 7.7  |
| 23 | sumColumnTest.java      | 读取一个3×4的矩阵求每列数字的和                  | 8.1  |
| 24 | employeeWorkHours.java  | 每个雇员每周工作的小时数                       | 8.4  |
| 25 | addMatrixTest.java      | 两个矩阵相加                             | 作业   |
| 26 | maxRowCol.java          | 最大的行和列                             | 作业   |
| 27 | multiplyMatrixTest.java | 两个矩阵相乘                             | 8.6  |
| 28 | rectangleTest.java      | Rectangle类                         | 作业   |
| 29 | randomClassTest.java    | 使用Random类                          | 作业   |

跨Class引用函数关系如下：

| 序号 | 引用自                 | 引用到                    | 引用方法/类型的名称      |
|----|---------------------|------------------------|-----------------|
| 1  | BooleanWrapper.java | quadSolve.java         | BooleanWrapper  |
| 2  | arrayTest.java      | sorted.java            | printArr()      |
| 3  | arrayTest.java      | mergeArray.java        | printArr()      |
| 4  | sorted.java         | mergeArray.java        | IsSorted()      |
| 5  | sorted.java         | mergeArray.java        | Sort()          |
| 6  | sorted.java         | repeatedInArray.java   | Sort()          |
| 7  | enhancedRandom.java | galtonBoard.java       | getRandom()     |
| 8  | enhancedRandom.java | numberSingleDigit.java | getRandom()     |
| 9  | galtonBoard.java    | maxRowCol.java         | BooleanRandom() |

