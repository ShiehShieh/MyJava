import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;
import java.awt.event.*;


class Car {
	Car(String number, int hours, int price){
		this.number      = number;
		this.repairHours = hours;
		this.repairPrice = price;
	}

	/**
 	* @return The registration number of the car
 	*/
	public String getRegistrationNumber(){
		return "NULL";
	}

	private String number;

	/**
	* The number of hours it takes to fix the car
 	*/
	private int repairHours;

	/**
 	* The number of euros you can charge the customer for the repairs
 	*/
	private int repairPrice;
}


interface Garage {
 /**
 * Takes a set of Car objects as a parameter, and returns the subset that
 * can be fixed in the given timeframe while generating as much revenue
 * as possible.
 *
 * @param cars Set of cars waiting to be repaired
 * @param availableHours The number of hours you have to repair the cars
 * @return Set of cars that have been repaired
 */
	public Set<Car> repair(Set<Car> cars, int availableHours);
}


class RepairCar implements Garage {
	public Set<Car> repair(Set<Car> cars, int availableHours){
		int number    = 4;
//		int[] allCars = new int[number];
//		int[] time    = new int[number];
		int[] allCars = {100, 120, 80, 50};
		int[] time    = {3, 5, 4, 1};
		int[][] c     = new int[number + 1][availableHours + 1];
		for(int i = 0; i < number + 1; ++i) {
			for(int j = 0; j <availableHours + 1; ++j) {
				c[i][j] = 0;
			}
		}

		System.out.println(knapsack(number, availableHours, allCars, time, c));

		return cars;
	}

	private int knapsack(int n, int w, int[] allCars, int[] time, int[][] c) {
		if (w <  0) return -100000;
		if (n == 0) return 0;
 
		if (c[n][w] != 0) return c[n][w];

		return c[n][w] = max(
			knapsack(n - 1, w - time[n - 1], allCars, time, c) + allCars[n - 1],
			knapsack(n - 1, w, allCars, time, c)
		);
	}

	private int max(int a, int b){
		if (a < b) {
			return b;
		}else{
			return a;
		}
	}
}

public class MyCorporation extends JFrame{
	JButton buttonStart = new JButton("Start");
	JButton buttonQuit  = new JButton("Quit");
	JTextField text = new JTextField(10);
	Set<Car> cars = new HashSet<Car>(4);
	RepairCar rep = new RepairCar();
	int time = 0;

	class MyStartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			time = Integer.parseInt(text.getText());
			rep.repair(cars, time);
		}
	}

	class MyQuitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

	public MyCorporation() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setLayout(new FlowLayout());
				buttonStart.addActionListener(new MyStartButtonListener());
				buttonQuit.addActionListener(new MyQuitButtonListener());
				add(text);
				add(buttonStart);
				add(buttonQuit);
				setTitle("MyCorporation");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setSize(500, 500);
				setVisible(true);
			}
		});
	}
	public static void main(String[] args) {
		MyCorporation test = new MyCorporation();
	}
}

/*
const int N = 100;      // 物品總數上限
const int W = 100000;   // 背包耐重上限
                        //（可以使用物品的總重量作為此值）
int cost[N], weight[N]; // 物品的價值與重量
int c[N + 1][W + 1];    // DP表格
 
// n為物品個數，w為背包耐重限制。
int knapsack(int n, int w)
{
    if (w < 0) return -1e9; // 耐重能力不足，故只能不放。
    if (n == 0) return 0;   // 沒有物品時，就沒有cost。
 
    // memoization，直接讀取記憶體的答案。
    if (c[n][w]) return c[n][w];
 
    // 遞迴求得小問題的答案
    return c[n][w] = max(
        knapsack(n-1, w-weight[n]) + cost[n],
        knapsack(n-1, w)
    );
}
*/
