#include<stdio.h>
#include<math.h>
//#define F(x) (x)*(x)*(x)- (x)-3
//#define F(x) (x)*(x)-25
#define F(x) sin(x)-2*(x)+1
//#define F(x) exp(x)-(x)-2
//#define F(x) log(x)-cos(x)
//#define F(x) (x)*tan(x)-1
#define EPS 0.001
main()
{
 float bisection(float, float);
 float a, b, fa, fb;
 //int count=0;
 printf("\nEnter bracket for root");
 scanf("%f%f",&a,&b);
 fa=F(a);
 fb=F(b);
 if(fa*fb>0)
 {
 printf("\nThe given values cannot bracket root, try again");

 }
 else
 bisection(a, b);
 //printf("\nRoot=%f", root);
 //getch();
 }
 float bisection(float a, float b)
 {
 int count=0;
 float x1, x2, x0, f1, f2, f0, err;
 x1=a; x2=b;
 do
 {
 count=count+1;
 x0=(x1+x2)/2.0;
 f1=F(x1);
 f2=F(x2);
 f0=F(x0);
 if(f1*f0>0)
 x1=x0;
 else
 x2=x0;
 err=fabs(x1-x2)/x1;

 }while(err>EPS);
 ////
 //return x0;
 printf("\nThe solution is %f", x0);
 printf("\nNo. of iterations %d", count);
 printf("\nError is %f", err);
 //getch();
 }
