public class Polynomial {
    double[] Coefficents;

    public Polynomial() {
        Coefficents = new double[0];
    }

    public Polynomial(double[] _coefficents) {
        Coefficents = _coefficents;
    }
    
    public Polynomial add(Polynomial Addend) {
        double[] Sum = new double[(Addend.Coefficents.length >= Coefficents.length) ? Addend.Coefficents.length : Coefficents.length];

        int i = 0, j = 0, k = 0;
        int AddendLength = Addend.Coefficents.length;
        int LocalLength = Coefficents.length;

        while (i < AddendLength || j < LocalLength) {
            if (i < AddendLength && j >= LocalLength) {
                Sum[k] = Addend.Coefficents[i];
                k++;
                i++;
            } else if (i >= AddendLength && j < LocalLength) {
                Sum[k] = Coefficents[i];
                k++;
                j++;
            } else {
                Sum[k] = Addend.Coefficents[i] + Coefficents[i];
                k++;
                i++;
                j++;
            }
        }
        return new Polynomial(Sum);
    }
    
    public double evaluate(double Input)
    {
        double Result = 0;
        for (int i = 0; i < Coefficents.length; i++) {
            Result += Coefficents[i] * Math.pow(Input, i);
        }
        //System.out.println("The result is:" + Result);
        return Result;
    }
    
    public boolean hasRoot(double Input)
    {
        return (evaluate(Input) == 0.0);
    }
}
