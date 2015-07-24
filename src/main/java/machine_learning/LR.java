package machine_learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class MyInstance {
    public int label;
    public double[] x;

    public MyInstance(int label, double[] x) {
        this.label = label;
        this.x = x;
    }

    public int getLabel() {
        return label;
    }

    public double[] getX() {
        return x;
    }
}

public class LR {
	
	private double rate;

	private double weights[];
	
	private int iteration;
	
	private double  threshold;
	
	public LR(int featureNumber){
		this.rate = 0.01;
		this.iteration = 1000000;
		this.threshold=0.000001;
        weights = new double[featureNumber];		
	}
	
	public void train(List<MyInstance> instances){
		double preJ=0;
		for(int count=0;count<this.iteration;count++){
			//System.out.println(threshold);
			double curJ=0;
			double tmpWeightSum[]= new double[this.weights.length];
			for(int i=0;i<instances.size();i++){
				//System.out.println("hehe");
				double[] x = instances.get(i).getX();
				int lable=instances.get(i).getLabel();
				double predicted =classify(x);				
				for(int j=0;j<tmpWeightSum.length;j++){
					tmpWeightSum[j] +=(lable-predicted)*x[j];
				}
				curJ += (lable*Math.log(predicted)+(1-lable)*Math.log(1-predicted));		
			}			
			curJ=-curJ/instances.size();
			if(Math.abs(curJ-preJ )< this.threshold) break;
			preJ=curJ;
			for(int i=0;i<this.weights.length;i++){
				this.weights[i]+=(tmpWeightSum[i]/instances.size())*this.rate;
			}
			System.out.println("iteration: " + count + " " + Arrays.toString(weights) + " cost: " + preJ);
		}
		
	}
	
	public double classify(double x[]){
		double logit=0;
		for(int i=0;i<this.weights.length;i++){
			logit+=this.weights[i]*x[i];
		}
		return sigmoid(logit);
	}

	private double sigmoid(double logit) {
		return 1/(1+Math.exp(-logit));
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double[] getWeights() {
		return weights;
	}

	public void setWeights(double[] weights) {
		this.weights = weights;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		List<MyInstance> dataset = new ArrayList<MyInstance>();
        Scanner scanner = new Scanner(new File("dataset.txt"));
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("#")) {
                continue;
            }
            String[] columns = line.split("\\s+");

            // skip first column and last column is the label
            int i = 1;
            double[] data = new double[columns.length-2];
            for (i=1; i<columns.length-1; i++) {
                data[i-1] = Integer.parseInt(columns[i]);
            }
            int label = Integer.parseInt(columns[i]);
            MyInstance instance = new MyInstance(label, data);
            dataset.add(instance);
        }
        
        LR lr = new LR(5);
        lr.train(dataset);
        double[] x = {2, 1, 1, 0, 1};
        System.out.println("prob(1|x) = " + lr.classify(x));

        double[] x2 = {1, 0, 1, 0, 0};
        System.out.println("prob(1|x2) = " + lr.classify(x2));

	}

}
