package algo.leetCode;

/**
 * 这个题目的本质是让你求平方根，比如求x^2=t ，我们可以设一个函数f(x)=x^2- t  ，令f(x)=0，很明显解x就是t的平方根，在图里表示为与X轴的交点横坐标。而我们要做的就是求出这个交点，手段是取图像上一个初始点（t,f(t)），作它的切线，切线与X轴交点横坐标为X0，接下来我们又作（X0，f(X0）)的切线，有没有发现，我们作的切线再逐渐向左偏，切线与X轴的交点也慢慢接近图像与X轴的交点，一直重复以上作切线过程，最后它们会无限逼近，到最后f(Xn)近似等于0（i从0到n），那么我们就可以认为Xn就是要求的平方根。

 平方根的具体过程如下：

 1、题目要求的是x的平方根，所以t =x，同时我们假设x0开始等于x；

 2、如上图所示，过点（x0,f(x0)）做曲线的切线 ，切线方程是y1-f( x0 )=f(x0)' ( x1 - x0 ) - t，令y1=0,解得x1=x0 / 2+t / (2*x0)

 3、接下来重复2，即过点（x1,f(x1)）做曲线的切线，切线方程是y2-f(x1)=f(x1)'(x2-x1) - t ，令y2=0,解得x2=x1 / 2 +t /(2*x1)

        接着重复2，一直到 f(xn) 趋向于0，而f(xn)=xn^2-t=0，所以最后近似解就是xn
        
        
  设r是f(x) = 0的根，选取x0作为r初始近似值，过点（x0,f(x0)）做曲线y = f(x)的切线L，L的方程为y = f(x0)+f'(x0)(x-x0)，求出L与x轴交点的横坐标 x1 = x0-f(x0)/f'(x0)，称x1为r的一次近似值。

  过点（x1,f(x1)）做曲线y = f(x)的切线，并求该切线与x轴交点的横坐标 x2 = x1-f(x1)/f'(x1)，称x2为r的二次近似值。重复以上过程，得r的近似值序列，其中x(n+1)=x(n)－f(x(n))/f'(x(n))，称为r的n+1次近似值，上式称为牛顿迭代公式。
 */
public class Q069_SqrtX {
    public static void main(String[] args){
        Q069_SqrtX solution = new Q069_SqrtX();
        double d = 16;
        double res = solution.sqrt(d);
        System.out.println(res);
    }

    public double sqrt(double c) {

        if (c < 0) {
            return Double.NaN;
        }

        double e = 1e-15;
        double x = c;
        double y = (x + c / x) / 2;
        while (Math.abs(x - y) > e) {
            x = y;
            y = (x + c / x) / 2;
        }
        return x;
    }

}
