package machine_learning;

import java.util.Random;

public class LogisticRegression
{
    private int _maxIteration = 1000;
    private double _stepSize = 0.000005;
    //private double _stepSize = 0.1;
    private double _lambda = 0.1;
    private double decay = 0.95;

    public int dim;
    public double[] theta;

    public LogisticRegression(int dim)
    {
        this.dim = dim;
    }

    public LogisticRegression(int dim, double stepSize)
        : this(dim)
    {
        this._stepSize = stepSize;
    }

    public void Train(Instance[] instances)
    {
        Initialize();

        int instCnt = instances.Length;
        double[] dev =new double[this.dim];
        for (int t = 0; t < this._maxIteration; t++)
        {
            double cost = 0;
            for (int i = 0; i < instCnt; i++)
            {
                double h_x = MathLib.Logistic(MathLib.VectorInnerProd(instances[i].featureValues, this.theta));
                // calculate cost function
                cost += instances[i].label * Math.Log(h_x) + (1 - instances[i].label) * Math.Log(1 - h_x);
            }
            cost *= -1.0 / instCnt; 
            Console.WriteLine("{0},{1}", t, cost);

           
            for (int i = 0; i < instCnt; i++)
            {
                ResetArray(dev);
                double h_x = MathLib.Logistic(MathLib.VectorInnerProd(instances[i].featureValues, this.theta));
                double error =   h_x- instances[i].label ;
                for (int j = 0; j < this.dim; j++)
                {
                    dev[j] += error*instances[i].featureValues[j] + 2*dev[j]*this._lambda;
                    this.theta[j] -= this._stepSize * dev[j] ;
                    //BoundaryLimiting(ref this.theta[j], 0, 1);
                }
            }
            //this._stepSize *= decay;
            //if (this._stepSize > 0.000001)
            //{
            //    this._stepSize = 0.000001;
            //}
        }
    }
     
    private void BoundaryLimiting(ref double alpha, double lowerbound, double upperbound)
    {
        if (alpha < lowerbound)
        {
            alpha = lowerbound;
        }
        else if (alpha > upperbound)
        {
            alpha = upperbound;
        }
    }

    public double[] Predict(Instance[] instances)
    {
        double[] results = new double[instances.Length];
        for (int i = 0; i < results.Length; i++)
        {
            results[i] = MathLib.Logistic(MathLib.VectorInnerProd(instances[i].featureValues, this.theta));
        }
        return results;
    }

    private void ResetArray(double[] dev)
    {
        for (int i = 0; i < dev.Length; i++)
        {
            dev[i] = 0;
        }
    }

    private void Initialize()
    {
        Random ran = new Random(DateTime.Now.Second);

        this.theta = new double[this.dim];
        for (int i = 0; i < this.dim; i++)
        {
            this.theta[i] = ran.NextDouble() * 0 ; // initialize theta with a small value
        }
    }


    public static void Test()
    {
        LogisticRegression lr = new LogisticRegression(3);

        List<Instance> instances = new List<Instance>();
        using (StreamReader rd = new StreamReader(@"D:\\local exp\\data.csv"))
        {
            string content = rd.ReadLine();
            while ((content = rd.ReadLine()) != null)
            {
                instances.Add(Instance.ParseInstance(content,','));
            }
        }

       // MinMaxNormalize(instances); 

        lr.Train(instances.ToArray()); 
        
    }

    private static void MinMaxNormalize(List<Instance> instances)
    {
        int dim = instances[0].dim;
        double[] min = new double[dim];
        double[] max = new double[dim];

        int instCnt = instances.Count;
        for (int i = 0; i < instCnt; i++)
        {
            for (int j = 0; j < dim; j++)
            {
                if (i == 0 || instances[i].featureValues[j] < min[j])
                {
                    min[j] = instances[i].featureValues[j];
                }
                if (i == 0 || instances[i].featureValues[j] > max[j])
                {
                    max[j] = instances[i].featureValues[j];
                }
            }
        }


        for (int j = 0; j < dim; j++)
        {
            double gap = max[j] - min[j];
            if (gap <= 0)
            {
                continue;
            }
            for (int i = 0; i < instCnt; i++)
            {
                instances[i].featureValues[j] = (instances[i].featureValues[j] - min[j]) / gap;
            }
        }
         
    }
}
