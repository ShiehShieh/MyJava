/**
 * student number : 1352975
 * name           : 谢志杰Xie zhijie
 *file name       : MyCorporation.java
 *e-mail:         : 1352975@tongji.edu.cn/xie510894496@gmail.com
 *description     : The implement of garage.
 */

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;
import java.awt.event.*;


class Car {
	Car(String number, int hours, int price) {
		this.number      = number;
		this.repairHours = hours;
		this.repairPrice = price;
	}

	/**
 	 * @return The registration number of the car
 	 */
	public String getRegistrationNumber() {
		return "NULL";
	}

	/**
	 * @brief return the String description of a car.
	 *
	 * @return 
	 */
	public String toString() {
		return this.number + "," +  this.repairHours + "," +  this.repairPrice + " ; ";
	}

	/**
	 * @brief return the number of this car.
	 *
	 * @return 
	 */
	public String returnNumber() {
		return this.number;
	}

	/**
	 * @brief return the cost of repair.
	 *
	 * @return 
	 */
	public int returnHours() {
		return this.repairHours;
	}

	/**
	 * @brief return the profit from this car.
	 *
	 * @return 
	 */
	public int returnPrice() {
		return this.repairPrice;
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
	public static Integer theRevenue = 0;
	public static ArrayList<Integer> results;

	public Set<Car> repair(Set<Car> cars, int availableHours) {
		int number               = cars.size();
		int[] allCars            = new int[number];
		int[] time               = new int[number];
		int[][] c                = new int[number + 1][availableHours + 1];
		Iterator<Car> a          = cars.iterator();
		Set<Car> resultCar = new HashSet<Car>();

		for (int i = 0; i < number && a.hasNext(); ++i) {
			Car thisOne   = a.next();
			allCars[i]    = thisOne.returnPrice();
			time[i]       = thisOne.returnHours();
		}

		for(int i = 0; i < number + 1; ++i) {
			for(int j = 0; j < availableHours + 1; ++j) {
				c[i][j] = 0;
			}
		}

		theRevenue = knapsack(number, availableHours, allCars, time, c);
		System.out.println(theRevenue);

		for (int q = 0; q < number + 1; ++q) {
			for (int p = 0; p < availableHours + 1; ++p) {
				System.out.print(" " + c[q][p] + " ");
			}
			System.out.println("\n");
		}

		results = find(number, availableHours, allCars, time, c);

		ArrayList<Car> temp = new ArrayList<Car>(cars);
		for (Integer i : results) {
			resultCar.add(temp.get(i));
		}

		return resultCar;

	}

	/**
	 * Find the specific car selected from the set.
	 * @param  number         [description]
	 * @param  availableHours [description]
	 * @param  allCars        [description]
	 * @param  time           [description]
	 * @param  c              [description]
	 * @return                [description]
	 */
	private ArrayList<Integer> find(int number, int availableHours, int[] allCars, int[] time, int[][] c) {
		int remainTime = availableHours;
		ArrayList<Integer> result = new ArrayList<Integer>();

		for(int i = number; i > 0; --i) {
			for (int j = number - 1; j >= 0; --j) {
				if (c[i][remainTime] - allCars[j] >= 0 && remainTime - time[j] >= 0) {
					if ((c[i][remainTime] - allCars[j]) == c[i - 1][remainTime - time[j]]){
						result.add(new java.lang.Integer(j));
						remainTime = remainTime - time[j];
						break;
					}
				}
			}
		}

		return result;

	}

	/**
	 * The algerithm of knapsack problem.
	 * @param  n       [description]
	 * @param  w       [description]
	 * @param  allCars [description]
	 * @param  time    [description]
	 * @param  c       [description]
	 * @return         [description]
	 */
	private int knapsack(int n, int w, int[] allCars, int[] time, int[][] c) {
		if (w <  0) return -100000;
		if (n == 0) return 0;

		if (c[n][w] != 0) return c[n][w];

		return c[n][w] = max(
			knapsack(n - 1, w - time[n - 1], allCars, time, c) + allCars[n - 1],
			knapsack(n - 1, w, allCars, time, c),
			allCars,
			n - 1
		);
	}

	private int max(int a, int b, int[] allCars, int position) {

		if (a < b) {

			return b;

		}else {

			return a;

		}
	}
}

public class MyCorporation extends JFrame {
	int time                  = 0;
	JButton buttonStart       = new JButton("Start");
	JButton buttonQuit        = new JButton("Quit");
	JButton buttonSubmit      = new JButton("Submit");
	JTextField text           = new JTextField(40);
	Set<Car> cars             = new HashSet<Car>();
	RepairCar rep             = new RepairCar();
	Set<Car> resultCars       = new HashSet<Car>(4);
	JTextArea carsInfo        = new JTextArea("ABC-123,3,100\nDEF-456,5,120\nGHI-789 ,4,80\nZZZ-999,1,50\n", 10, 20);
	JTextArea output          = new JTextArea("Output here :\n", 10, 20);
	JScrollPane barOfCarsInfo = new JScrollPane(carsInfo);
	JScrollPane barOfOutput   = new JScrollPane(output);
	JLabel blank              = new JLabel("Option :");
	JLabel title              = new JLabel("Welcome to my Garage");
	JPanel panelText           = new JPanel(new GridLayout(3, 1));
	JPanel panelButton           = new JPanel(new GridLayout(5, 1));
	JPanel panelUpper           = new JPanel(new GridLayout(1, 2));
	JPanel panelLower           = new JPanel(new FlowLayout());

	/**
	 * @brief Add some cars into the set.
	 *
	 * @return 
	 */
	synchronized public void addCar(final String carInfo) throws IOException {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				String name;
				int time;
				int income;
				int i = 0;
				String now;
				String[] present = carInfo.split(",");
				cars.clear();
				try{
					while(i < present.length - 2) {
						name = present[i];
						++i;
						time = Integer.parseInt(present[i]);
						++i;
						income = Integer.parseInt(present[i]);
						++i;
						cars.add(new Car(name, time, income));
					}	
				}catch(NumberFormatException e){
					output.append("Illegal Input.\n");
				}
			}
		});
	}

	public class MySubmitButtonLister implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				addCar(carsInfo.getText().replace('\n', ','));
				output.append("The information of cars have been added.\n");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	class MyStartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try{
				time = Integer.parseInt(text.getText());
			}catch(NumberFormatException e){
				output.append("Illegal Input.\n");
			}
			resultCars = rep.repair(cars, time);
			output.append("The maximum revenue :");
			output.append(rep.theRevenue.toString());
			output.append("\n");
			for (Car i : resultCars) {
				output.append(i + ",");
			}
			output.append("\n");
		}
	}

	class MyQuitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
//
	public MyCorporation() throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageIcon img        = new ImageIcon("LookIntoMyEyes.jpg");
					JLabel imgLabel      = new JLabel(img);

					getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
					imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

					Container cp         = getContentPane();
					GridLayout theLayout = new GridLayout(2, 1);

					theLayout.setVgap(10);
					cp.setLayout(theLayout);
					((JPanel)cp).setOpaque(false);
					(panelText).setOpaque(false);
					(panelButton).setOpaque(false);
					(panelUpper).setOpaque(false);
					(panelLower).setOpaque(false);

					buttonStart.addActionListener(new MyStartButtonListener());
					buttonQuit.addActionListener(new MyQuitButtonListener());
					buttonSubmit.addActionListener(new MySubmitButtonLister());

					panelText.add(title);
					panelText.add(text);
					panelUpper.add(panelText);
					panelButton.add(blank);
					panelButton.add(buttonStart);
					panelButton.add(buttonSubmit);
					panelButton.add(buttonQuit);
					panelUpper.add(panelButton);
					panelLower.add(barOfCarsInfo);
					panelLower.add(barOfOutput);
					cp.add(panelUpper);
					cp.add(panelLower);

					setTitle("MyCorporation");
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setSize(654, 654);
					setVisible(true);

				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) throws IOException {
		MyCorporation test = new MyCorporation();
	}
}

